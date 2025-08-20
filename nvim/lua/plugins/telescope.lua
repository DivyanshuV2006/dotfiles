return {
  {
    "nvim-telescope/telescope.nvim",
    version = false,                 -- or tag = '0.1.6' for stable
    dependencies = {
      "nvim-lua/plenary.nvim",       -- required
      "nvim-tree/nvim-web-devicons", -- optional, for icons
    },
    cmd = "Telescope",
    config = function()
      require("telescope").setup({
        defaults = {
          layout_strategy = "horizontal",
          layout_config = { preview_width = 0.6 },
          sorting_strategy = "ascending",
          winblend = 0,
        },
      })
    end,
  },
}
