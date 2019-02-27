SUMMARY = "A Meta Example image"

inherit core-image

TEST_APPS = " \
    cpcmd \
"

IMAGE_INSTALL += " \
    ${TEST_APPS} \
"

export IMAGE_BASENAME = "minimal-example"
