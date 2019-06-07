DESCRIPTION = "Configuration files for online package repositories aka feeds"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PV = "${DISTRO_VERSION}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH ?= "unstable/feed/"

IWMMXT_FEED = "${@bb.utils.contains('MACHINE_FEATURES', 'iwmmxt', 'iwmmxt', '',d)}"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg

	# Weed out duplicates, e.g. arm1176* will show up twice
	FILTERED_FEED_ARCHS="$(echo ${FEED_ARCHS}| tr ' ' '\n' | sort | uniq | tr '\n' ' ')"

	rm -f ${S}/${sysconfdir}/opkg/its-feed.conf
	for feed_arch in ${FILTERED_FEED_ARCHS} ; do
            echo "src/gz its-${feed_arch} ${ITS_URI}/${FEED_BASEPATH}${feed_arch}" >> ${S}/${sysconfdir}/opkg/its-feed.conf
        done
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = "${sysconfdir}/opkg/its-feed.conf"

CONFFILES_${PN} += "${sysconfdir}/opkg/its-feed.conf"

RRECOMMENDS_${PN} += "opkg"

python populate_packages_prepend () {
    etcdir = bb.data.expand('${sysconfdir}/opkg', d)
    do_split_packages(d, etcdir, '^locale-(.*)\.conf$', 'angstrom-locale-%s-config', 'Angstrom feed config for the %s locale', extra_depends='', allow_links=True)
}

