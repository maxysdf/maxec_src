import '../styles/globals.css'
import '../styles/styles.css'

import Header from '../components/header'
import Footer from '../components/footer'

import 'bootstrap/dist/css/bootstrap.min.css'
import "owl.carousel/dist/assets/owl.carousel.min.css"
import "owl.carousel/dist/assets/owl.carousel.min.css"

import '../styles/font-awesome.min.css'
import '../styles/themify-icons.css'
import '../styles/elegant-icons.css'

import '../styles/nice-select.css'
import '../styles/jquery-ui.min.css'
import '../styles/owl.carousel.min.css'


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
