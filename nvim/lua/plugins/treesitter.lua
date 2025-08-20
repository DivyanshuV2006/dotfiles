return {
 {
  "nvim-treesitter/nvim-treesitter",
  build = ":TSUpdate",
  event = { "BufReadPost", "BufNewFile" },
  config = function()
   require("nvim-treesitter.configs").setup({
    ensure_installed = {
     -- Core
     "lua", "vim", "bash", "json", "markdown",

     -- C/C++ (if you use them)
     "c", "cpp",

     -- Web stack
     "html",
     "css",
     "javascript",
     "typescript",
     "tsx",   -- ← React JSX/TSX support
     "jsdoc", -- For JS/TS doc comments

     -- Optional but useful
     "yaml",
     "toml",
     "regex",
     "comment",
     "python", -- if you use Python
     "java",
    },
    auto_install = true,
    highlight = {
     enable = true,
     additional_vim_regex_highlighting = false,
    },
    indent = { enable = true },
   })
  end,
 },
}
