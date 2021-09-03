import Head from "next/head"

import '../../styles/globals.css'

// common css
import '../../styles/adminlte/adminlte.min.css'
import '../../styles/icheck-bootstrap.min.css'
import '../../styles/font-awesome/all.min.css'
import '../../styles/overlayScrollbars/OverlayScrollbars.min.css'

function MaxECApp({ Component, pageProps }) {
  return (
    <>
    <Head>
        <title>MaxEC後台</title>
    </Head>
    <Component {...pageProps} />
    </>
  );
}

export default MaxECApp
