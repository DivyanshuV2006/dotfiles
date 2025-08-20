vim.cmd("set expandtab")
vim.cmd("set tabstop=2")
vim.cmd("set softtabstop=2")
vim.cmd("set shiftwidth=2")
vim.opt.number = true
vim.opt.relativenumber = true

-- QOL Features

vim.opt.clipboard = "unnamedplus" 
vim.opt.smartindent = true
vim.opt.ignorecase = true               
vim.opt.smartcase = true                
vim.opt.termguicolors = true            
vim.opt.signcolumn = "yes"     
vim.opt.scrolloff = 8                   
vim.opt.updatetime = 250                
 
-- Load Lazy and plugins
require("config.lazy")
require("config.keymaps")
