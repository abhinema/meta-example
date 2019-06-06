SUMMARY = "A Meta Example image"

#require core-image-minimal.bb
#require angstrom-lxde-image.bb

require angstrom-qt-x11-image.bb

FEED_DEPLOYDIR_BASE_URI = "http://10.40.20.74:9999/ http://<10.40.20.74>:9999/"
#ANGSTROM_URI ?= "http://feeds.angstrom-distribution.org"

ANGSTROM_URI = "http://10.40.20.74:9999/"

TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL_append = "cpcmd"

export IMAGE_BASENAME = "minimal-example"
