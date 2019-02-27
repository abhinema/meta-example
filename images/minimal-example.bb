SUMMARY = "A Meta Example image"

require ${LAYERDIR}/../meta/recipes-extended/images/core-image-minimal.bb

TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL += " \
    ${TEST_APPS} \
"

export IMAGE_BASENAME = "minimal-example"
