import Head from 'next/head'

import '../styles/globals.css'

// common
import '../styles/bootstrap.min.css'
import '../styles/font-awesome.min.css'
import '../styles/themify-icons.css'
import '../styles/elegant-icons.css'
import '../styles/owl.carousel.min.css'
import '../styles/nice-select.css'
import '../styles/jquery-ui.min.css'
import '../styles/style.css'

function MyApp({ Component, pageProps }) {
  return (
    <>
    <Head>
        <title>MaxEC購物平台</title>
    </Head>
    <Component {...pageProps} />
    </>
  )
}

export default MyApp
