import Script from "next/script"
import Image from "next/image"
import Link from "next/link"
import Head from "next/head"

import Header from "../components/header"
import Partner from "../components/partner"
import Footer from "../components/footer"
import Breadcrumb from "./breadcrumb"

export default function LayoutSimple({components,breadcrumbs=[],title=null}) {
    return (
        <>
        <Head>
            <title>{title ? `${title} - ` : ''}MaxEC購物平台</title>
        </Head>

        <Header />

        <Breadcrumb list={breadcrumbs} />

        {components }

        <Partner />

        <Footer />


        {/* script */}

        <Script src="/js/jquery-3.3.1.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/bootstrap.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery-ui.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery.countdown.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery.nice-select.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery.zoom.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery.dd.min.js" strategy="beforeInteractive"></Script>
        <Script src="/js/jquery.slicknav.js" strategy="beforeInteractive"></Script>
        <Script src="/js/owl.carousel.min.js" strategy="beforeInteractive"></Script>
        </>
    );
}