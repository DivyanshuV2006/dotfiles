return {
 {
  "neovim/nvim-lspconfig",
  config = function()
   local lspconfig = require("lspconfig")

   local on_attach = function(client, bufnr)
    -- Autoformat on save
    vim.api.nvim_create_autocmd("BufWritePre", {
     buffer = bufnr,
     callback = function()
      vim.lsp.buf.format({ async = false })
     end,
    })
   end

   -- TypeScript / JavaScript / React
   lspconfig.ts_ls.setup({
    on_attach = on_attach,
   })

   -- Python
   lspconfig.pyright.setup({
    on_attach = on_attach,
   })

   -- Java
   lspconfig.jdtls.setup({
    on_attach = on_attach,
   })

   -- Lua (for Neovim config)
   lspconfig.lua_ls.setup({
    on_attach = on_attach,
    settings = {
     Lua = {
      diagnostics = {
       globals = { "vim" },        -- suppress warning for global 'vim'
      },
      workspace = {
       library = vim.api.nvim_get_runtime_file("", true),
       checkThirdParty = false,
      },
      telemetry = {
       enable = false,
      },
     },
    },
   })
  end,
 },
}
