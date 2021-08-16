import '../styles/globals.css'
import styles from '../styles/frontend.scss'

import Header from '../components/header'
import Footer from '../components/footer'

import 'bootstrap/dist/css/bootstrap.min.css'

function MyApp({ Component, pageProps }) {
  return (
    <>
      <Header />
      <Component {...pageProps} />
      <Footer />
    </>
  )
}

export default MyApp
