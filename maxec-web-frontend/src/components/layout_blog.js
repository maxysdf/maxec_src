import Script from "next/script"
import Image from "next/image"
import Link from "next/link"

import Header from "../components/header"
import Partner from "../components/partner"
import Footer from "../components/footer"
import Breadcrumb from "./breadcrumb"
import BlogSidebar from "./blog/sidebar"

export default function LayoutBlog({components}) {
    return (
        <>
        <Header />

        <Breadcrumb />

        <section className="blog-section spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
                        <BlogSidebar />
                    </div>
                    <div className="col-lg-9 order-1 order-lg-2">
                        {components}
                    </div>
                </div>
            </div>
        </section>

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