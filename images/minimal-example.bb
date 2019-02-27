SUMMARY = "A Meta Example image"

require ${LAYERDIR}/images/core-image-minimal.bb

TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL += " \
    ${TEST_APPS} \
"

export IMAGE_BASENAME = "minimal-example"
