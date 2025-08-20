return {
  {
    -- Use a real plugin to satisfy Lazy, even though we’re just using it for config
    "nvim-lua/plenary.nvim",
    priority = 1000,
    lazy = false,
    config = function()
      -- Set Neovim's built-in theme
      vim.cmd.colorscheme("default")

      -- Make the UI fully transparent and all foreground text pure white
      vim.api.nvim_create_autocmd("VimEnter", {
        callback = function()
          local groups = {
            "Normal", "NormalNC", "EndOfBuffer", "VertSplit",
            "StatusLine", "StatusLineNC", "MsgArea",
            "SignColumn", "LineNr", "CursorLineNr", "FoldColumn",
            "Pmenu", "PmenuSel", "FloatBorder", "WinSeparator",
            "DiagnosticSignError", "DiagnosticSignWarn",
            "DiagnosticSignInfo", "DiagnosticSignHint",
            "TelescopeNormal", "TelescopeBorder",
            "TelescopePromptNormal", "TelescopePromptBorder",
            "TelescopeResultsNormal", "TelescopeResultsBorder",
            "TelescopePreviewNormal", "TelescopePreviewBorder"
          }

          for _, group in ipairs(groups) do
            vim.cmd("highlight " .. group .. " guibg=NONE guifg=#FFFFFF ctermbg=NONE ctermfg=15")
          end
        end,
      })
    end,
  }
}
