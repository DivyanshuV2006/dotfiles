local transparent_theme = {
  normal = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
  insert = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
  visual = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
  replace = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
  command = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
  inactive = {
    a = { bg = 'NONE', fg = 'NONE', gui = 'bold' },
    b = { bg = 'NONE', fg = 'NONE' },
    c = { bg = 'NONE', fg = 'NONE' },
  },
}


return {
  'nvim-lualine/lualine.nvim',
  dependencies = { 'nvim-tree/nvim-web-devicons' },
  config = function()
    require('lualine').setup {
      options = {
        theme = transparent_theme,
        section_separators = '',
        component_separators = ''
      }
    }
  end
}
