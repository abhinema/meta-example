SUMMARY = "A Meta Example image"

#require core-image-minimal.bb
require angstrom-lxde-image.bb

TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL += " \
    ${TEST_APPS} \
"

export IMAGE_BASENAME = "minimal-example"
