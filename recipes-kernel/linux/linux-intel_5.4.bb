require linux-intel.inc

KBRANCH = "5.4/yocto"
KMETA_BRANCH = "yocto-5.4"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI:append = " file://0001-menuconfig-mconf-cfg-Allow-specification-of-ncurses-.patch"

DEPENDS += "elfutils-native openssl-native util-linux-native"

LINUX_VERSION ?= "5.4.182"
SRCREV_machine ?= "24a04b07c7bd790c411cfc7e751aee310333f95e"
SRCREV_meta ?= "98cce1c95fcc9a26965cbc5f038fd71d53c387c8"

# For Crystalforest and Romley
KERNEL_MODULE_AUTOLOAD:append:core2-32-intel-common = " uio"
KERNEL_MODULE_AUTOLOAD:append:corei7-64-intel-common = " uio"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc features/security/security.scc"

# Kernel config 'CONFIG_GPIO_LYNXPOINT' goes by a different name 'CONFIG_PINCTRL_LYNXPOINT' in
# linux-intel 5.4 specifically. This cause warning during kernel config audit. So suppress the
# harmless warning for now.
KCONF_BSP_AUDIT_LEVEL = "0"
