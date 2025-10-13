#!/usr/bin/env bash

iatest=$(expr index "$-" i)

#######################################################
# BASIC SYSTEM SETUP
#######################################################

# Source global definitions
[[ -f /etc/bashrc ]] && source /etc/bashrc

#fastfetch

#if [ -f /usr/bin/fastfetch ]; then
#  fastfetch
#fi

# Bash completion (lazy-load)
_bash_completion_loaded=false
load_bash_completion() {
  [[ $_bash_completion_loaded == true ]] && return
  if [[ -f /usr/share/bash-completion/bash_completion ]]; then
    source /usr/share/bash-completion/bash_completion
  elif [[ -f /etc/bash_completion ]]; then
    source /etc/bash_completion
  fi
  _bash_completion_loaded=true
}

# Disable bell
[[ $iatest -gt 0 ]] && bind "set bell-style visible"

# Ignore case and auto-complete settings
[[ $iatest -gt 0 ]] && bind "set completion-ignore-case on"
[[ $iatest -gt 0 ]] && bind "set show-all-if-ambiguous On"

# Ctrl-S support
[[ $- == *i* ]] && stty -ixon

# History settings
HISTFILESIZE=10000
HISTSIZE=500
HISTCONTROL=erasedups:ignoredups:ignorespace
HISTTIMEFORMAT="%F %T"
shopt -s checkwinsize histappend
PROMPT_COMMAND='history -a'

# XDG folders
export XDG_DATA_HOME="$HOME/.local/share"
export XDG_CONFIG_HOME="$HOME/.config"
export XDG_STATE_HOME="$HOME/.local/state"
export XDG_CACHE_HOME="$HOME/.cache"

# Useful variables
export LINUXTOOLBOXDIR="$HOME/linuxtoolbox"
export EDITOR=nvim
export VISUAL=nvim
export TERM=xterm-256color
export CRYPTOGRAPHY_OPENSSL_NO_LEGACY=1
export PATH="$PATH:$HOME/.local/bin:$HOME/.cargo/bin:/var/lib/flatpak/exports/bin:/.local/share/flatpak/exports/bin"

#######################################################
# LIGHTWEIGHT ALIASES
#######################################################
alias vim='nvim'
alias vi='nvim'
alias sv='sudo nvim'
alias svi='sudo nvim'
alias vis='nvim "+set si"'
alias spico='sudo pico'
alias snano='sudo nano'
alias cls='clear'
alias ebrc='edit ~/.bashrc'
alias hlp='less ~/.bashrc_help'
alias da='date "+%Y-%m-%d %A %T %Z"'

#######################################################
# LS AND COLOR SETTINGS
#######################################################
export CLICOLOR=1
export LS_COLORS='no=00:fi=00:di=00;34:ln=01;36:pi=40;33:so=01;35:do=01;35:bd=40;33;01:cd=40;33;01:or=40;31;01:ex=01;32:*.tar=01;31:*.tgz=01;31:*.zip=01;31:*.jpg=01;35:*.png=01;35:*.mp3=01;35:*.xml=00;31:'

# Grep alias (uses ripgrep if available)
if command -v rg &>/dev/null; then
  alias grep='rg'
else
  alias grep='/usr/bin/grep'
fi

# LESS colors
export LESS_TERMCAP_mb=$'\E[01;31m'
export LESS_TERMCAP_md=$'\E[01;31m'
export LESS_TERMCAP_me=$'\E[0m'
export LESS_TERMCAP_se=$'\E[0m'
export LESS_TERMCAP_so=$'\E[01;44;33m'
export LESS_TERMCAP_ue=$'\E[0m'
export LESS_TERMCAP_us=$'\E[01;32m'

#######################################################
# DIRECTORY ALIASES
#######################################################
alias home='cd ~'
alias cd..='cd ..'
alias ..='cd ..'
alias ...='cd ../..'
alias ....='cd ../../..'
alias .....='cd ../../../..'
alias web='cd /var/www/html'
alias bd='cd "$OLDPWD"'

# LS variants
alias ls='ls -aFh --color=always'
alias la='ls -Alh'
alias ll='ls -Fls'
alias lx='ls -lXBh'
alias lk='ls -lSrh'
alias lc='ls -ltcrh'
alias lu='ls -lturh'
alias lr='ls -lRh'
alias lt='ls -ltrh'
alias lm='ls -alh | more'
alias lw='ls -xAh'
alias labc='ls -lap'
alias lf='ls -l | egrep -v "^d"'
alias ldir='ls -l | egrep "^d"'
alias lla='ls -Al'
alias las='ls -A'
alias lls='ls -l'

# File permissions
alias mx='chmod a+x'
alias 000='chmod -R 000'
alias 644='chmod -R 644'
alias 666='chmod -R 666'
alias 755='chmod -R 755'
alias 777='chmod -R 777'

# Other frequently used aliases
alias cp='cp -i'
alias mv='mv -i'
alias rm='trash -v'
alias mkdir='mkdir -p'
alias ps='ps auxf'
alias ping='ping -c 10'
alias less='less -R'
alias apt-get='sudo apt-get'
alias multitail='multitail --no-repeat -c'
alias freshclam='sudo freshclam'
alias yayf="yay -Slq | fzf --multi --preview 'yay -Sii {1}' --preview-window=down:75% | xargs -ro yay -S"
alias docker-clean='docker container prune -f; docker image prune -f; docker network prune -f; docker volume prune -f'
alias about="fastfetch"
alias storage="qdirstat"

#######################################################
# FUNCTIONS (ALL PRESERVED)
#######################################################
extract() { for archive in "$@"; do
  [[ -f "$archive" ]] || {
    echo "'$archive' is not valid"
    continue
  }
  case $archive in *.tar.bz2) tar xvjf "$archive" ;; *.tar.gz) tar xvzf "$archive" ;; *.bz2) bunzip2 "$archive" ;; *.rar) rar x "$archive" ;; *.gz) gunzip "$archive" ;; *.tar) tar xvf "$archive" ;; *.tbz2) tar xvjf "$archive" ;; *.tgz) tar xvzf "$archive" ;; *.zip) unzip "$archive" ;; *.Z) uncompress "$archive" ;; *.7z) 7z x "$archive" ;; *) echo "Unknown archive type: $archive" ;; esac
done }
ftext() { grep -iIHrn --color=always "$1" . | less -r; }
mkdirg() { mkdir -p "$1" && cd "$1"; }
mvg() { mv "$1" "$2" && [[ -d "$2" ]] && cd "$2"; }
cpg() { cp "$1" "$2" && [[ -d "$2" ]] && cd "$2"; }
up() {
  local d=""
  for ((i = 1; i <= $1; i++)); do d=$d/..; done
  cd "${d#/}"
  [[ -z $d ]] && cd ..
}
pwdtail() { pwd | awk -F/ '{n=NF; print $(n-1)"/"$NF}'; }
gcom() { git add . && git commit -m "$1"; }
lazyg() { git add . && git commit -m "$1" && git push; }
trim() {
  local var=$*
  var="${var#"${var%%[![:space:]]*}"}"
  var="${var%"${var##*[![:space:]]}"}"
  echo -n "$var"
}
whatsmyip() {
  echo -n "Internal IP: "
  command -v ip &>/dev/null && ip addr show wlan0 | awk '/inet /{print $2}' | cut -d/ -f1 || ifconfig wlan0 | awk '/inet /{print $2}'
  echo -n " External IP: "
  curl -4 ifconfig.me
}
alias whatismyip="whatsmyip"

# Override cd to auto-ls using zoxide
cd() { z "$@" || builtin cd "$@" && ls; }

# Lazy-load heavy stuff
lazy_starship() { command -v starship &>/dev/null && eval "$(starship init bash)"; }
lazy_zoxide() { command -v zoxide &>/dev/null && eval "$(zoxide init bash)"; }
lazy_conda() { [[ -f "/opt/miniconda3/etc/profile.d/conda.sh" ]] && source "/opt/miniconda3/etc/profile.d/conda.sh"; }
lazy_sdkman() { [[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"; }

# Only load heavy commands in interactive shells
if [[ $- == *i* ]]; then
  lazy_starship
  lazy_zoxide
  lazy_conda
  lazy_sdkman
fi

# Start X automatically on tty1
[[ -z $DISPLAY ]] && [[ $(tty) == /dev/tty1 ]] && exec startx

# >>> conda initialize >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$('/opt/miniconda3/bin/conda' 'shell.bash' 'hook' 2> /dev/null)"
if [ $? -eq 0 ]; then
    eval "$__conda_setup"
else
    if [ -f "/opt/miniconda3/etc/profile.d/conda.sh" ]; then
        . "/opt/miniconda3/etc/profile.d/conda.sh"
    else
        export PATH="/opt/miniconda3/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda initialize <<<

