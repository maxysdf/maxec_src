import '../styles/globals.css'

import 'bootstrap/dist/css/bootstrap.min.css'
import Layout from '../components/layout';

import '@fortawesome/fontawesome-free/js/fontawesome';
import '@fortawesome/fontawesome-free/js/solid';
import '@fortawesome/fontawesome-free/js/regular';
import '@fortawesome/fontawesome-free/js/brands';

function MyApp({ Component, pageProps }) {

  return Component.getLayout ?
    Component.getLayout(Component) :
    <Layout><Component {...pageProps} /></Layout>
    ;
}

export default MyApp
