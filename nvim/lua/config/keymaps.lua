vim.keymap.set("n", "<leader>rf", function()
  -- Only save if in a normal buffer (not terminal, help, etc.)
  if vim.bo.buftype == "" then
    vim.cmd("w")
  end

  local file = vim.fn.expand("%:t")            -- Filename (e.g., main.py)
  local file_noext = vim.fn.expand("%:t:r")    -- Filename without extension
  local ext = vim.fn.expand("%:e")             -- File extension
  local file_dir = vim.fn.expand("%:p:h")      -- Full directory of current file
  local cmd = nil

  local function file_exists(name)
    return vim.fn.filereadable(file_dir .. "/" .. name) == 1
  end

  -- Determine the appropriate command to run
  if file_exists("package.json") then
    if ext == "jsx" then
      cmd = "npx babel-node " .. file
    else
      cmd = "npm run dev -- --host"
    end
  elseif ext == "py" then
    cmd = "python " .. file
  elseif ext == "js" then
    cmd = "node " .. file
  elseif ext == "ts" then
    cmd = "ts-node " .. file
  elseif ext == "jsx" then
    cmd = "npx babel-node " .. file
  elseif ext == "tsx" then
    cmd = "npx ts-node " .. file
  elseif ext == "rs" or vim.fn.glob(file_dir .. "/*.rs") ~= "" then
    cmd = "cargo run"
  elseif ext == "c" or vim.fn.glob(file_dir .. "/*.c") ~= "" then
    cmd = "gcc *.c -o out && ./out"
  elseif ext == "go" or vim.fn.glob(file_dir .. "/*.go") ~= "" then
    cmd = "go run ."
  elseif ext == "java" then
    cmd = "javac " .. file .. " && java " .. file_noext
  elseif file_exists("Makefile") then
    cmd = "make"
  else
    vim.notify("No suitable run command found for file: " .. file, vim.log.levels.WARN)
    return
  end

  -- Close all terminal buffers before opening a new one
  for _, buf in ipairs(vim.api.nvim_list_bufs()) do
    if vim.api.nvim_buf_is_valid(buf) and vim.api.nvim_buf_get_option(buf, "buftype") == "terminal" then
      vim.api.nvim_buf_delete(buf, { force = true })
    end
  end

  -- Open a new terminal at the bottom
  vim.cmd("botright split | resize 15 | terminal")

  -- After terminal starts, send the command
  vim.defer_fn(function()
    local chan = vim.b.terminal_job_id
    if chan then
      local full_cmd = 'cd "' .. file_dir .. '" && ' .. cmd
      vim.fn.chansend(chan, full_cmd .. "\r") -- Use \r to simulate Enter on Windows
    else
      vim.notify("Terminal not initialized", vim.log.levels.ERROR)
    end
  end, 100)
end, { desc = "Run file based on context/project" })