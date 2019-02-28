SUMMARY = "A Meta Example image"

require core-image-minimal.bb

IMAGE_TYPE_live = "image-live"

inherit ${IMAGE_TYPE_live}

#
PACKAGE_CLASSES = "package_ipk"
IMAGE_FSTYPES = "live"
NOISO = "0"
#IMAGE_TYPE_live="iso"
FEED_DEPLOYDIR_BASE_URI = "http://10.40.20.70:9999"
#
POKY_DEFAULT_DISTRO_FEATURES_append = " systemd"
DISTRO_FEATURES_append = " systemd"

PREFERRED_PROVIDER_udev ?= "systemd"
PREFERRED_PROVIDER_udev-utils ?= "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"


TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL += " \
    ${TEST_APPS} \
"

export IMAGE_BASENAME = "sysd-minimal-image"
