import Script from "next/script"
import Head from "next/head"

import Nav from "../components/nav"
import SideBar from "../components/sidebar"
import Footer from "../components/footer"

export default function LayoutAdmin ({title,components,breadcrumbs}) {
    return (
        <> 
            <Head>
                <title>MaxEC後台 - {title}</title>
            </Head>
            <div className="wrapper">
                <Nav />
                <SideBar /> 

                <div className="content-wrapper">
                    <div className="content-header">
                        <div className="container-fluid">
                            <div className="row mb-2">
                                <div className="col-sm-6">
                                    <h1 className="m-0">{title}</h1>
                                </div>
                                <div className="col-sm-6">
                                    <ol className="breadcrumb float-sm-right">
                                        <li className="breadcrumb-item"><a href="#">首頁</a></li>
                                        <li className="breadcrumb-item active">{title}</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="content">
                        <div className="container-fluid">
                            {components}
                        </div>
                    </div>
                </div>

                <Footer />
            </div>

            <Script src="/js/jquery/jquery.min.js" strategy="beforeInteractive" />
            <Script src="/js/jquery-ui/jquery-ui.min.js" strategy="beforeInteractive"  />
            <Script src="/js/bootstrap/bootstrap.bundle.min.js" strategy="beforeInteractive"  />
            <Script src="/js/overlayScrollbars/jquery.overlayScrollbars.js" strategy="beforeInteractive"  />

            <Script src="/js/adminlte/adminlte.js" strategy="beforeInteractive"  />
            <Script src="/js/adminlte/demo.js" strategy="beforeInteractive"  />
        </>
    );
}