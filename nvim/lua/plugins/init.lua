return {
 -- ── Core UI / UX ────────────────────────────────────────────────────────────
 { "nvim-treesitter/nvim-treesitter", build = ":TSUpdate" },
 { "nvim-lualine/lualine.nvim" },

 -- Telescope + deps
 {
  "nvim-telescope/telescope.nvim",
  dependencies = { "nvim-lua/plenary.nvim" },
 },

 -- ── Mason: binary / LSP manager ────────────────────────────────────────────
 {
  "williamboman/mason.nvim",
  config = true,
 },
 {
  "williamboman/mason-lspconfig.nvim",
  dependencies = "williamboman/mason.nvim",
  config = function()
   require("mason-lspconfig").setup({
    ensure_installed = {
     "lua_ls",  -- Lua LSP
     "ts_ls",   -- TypeScript/JavaScript LSP ✅ CORRECT
     "pyright", -- Python LSP
     "jdtls",   -- Java LSP
    },
    automatic_installation = true,
   })
  end,
 },

 -- ── Your modular plugin configurations ──────────────────────────────────────
 { import = "plugins.colorscheme" },
 { import = "plugins.telescope" },
 { import = "plugins.treesitter" },
 { import = "plugins.lsp" },
}
