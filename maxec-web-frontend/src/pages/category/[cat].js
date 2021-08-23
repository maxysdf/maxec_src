import axios from "axios";
import ProductSidebar from "../../components/product/sidebar";
import Head from "next/head"
import ProductList from "../../components/product/list";
import { useState } from "react";

export default function CategoryPage(props) {
    const [filterData,setFilterData] = useState({cat:props.cat});

    const filter = (data) => {
        setFilterData({...data, cat:props.cat});
    };

    return (
        <>
        <Head>
            <title>列表頁</title>
            <script type="text/javascript" src="/js/jquery.min.js"></script>
            <script type="text/javascript" src="/js/jquery-ui.min.js"></script>
            <link type="text/css" rel="stylesheet" href="/css/jquery-ui.min.css" />
        </Head>
        <div className="breacrumb-section">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="breadcrumb-text">
                            <a href="#"><i className="fa fa-home"></i> 首頁</a>
                            <span>列表頁</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        {/* photo shop */}
        <section className="product-shop spad">
            <div className="container">
                <div className="row">
                    <ProductSidebar 
                        categories={props.categories}
                        brands={props.brands}
                        tagTypes={props.tagTypes}
                        onFilter={filter}>
                    </ProductSidebar>
                    <ProductList
                        filterData={filterData}>
                    </ProductList>
                </div>
            </div>
        </section>
        
        {/* partner */}
        <div className="partner-logo">
            <div className="container">
                <div className="logo-carousel owl-carousel">
                    <div className="logo-item">
                        <div className="tablecell-inner">
                            <img src="img/logo-carousel/logo-1.png" alt=""/>
                        </div>
                    </div>
                    <div className="logo-item">
                        <div className="tablecell-inner">
                            <img src="img/logo-carousel/logo-2.png" alt=""/>
                        </div>
                    </div>
                    <div className="logo-item">
                        <div className="tablecell-inner">
                            <img src="img/logo-carousel/logo-3.png" alt=""/>
                        </div>
                    </div>
                    <div className="logo-item">
                        <div className="tablecell-inner">
                            <img src="img/logo-carousel/logo-4.png" alt=""/>
                        </div>
                    </div>
                    <div className="logo-item">
                        <div className="tablecell-inner">
                            <img src="img/logo-carousel/logo-5.png" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        {/* footer */}
        <footer className="footer-section">
            <div className="container">
                <div className="row">
                    <div className="col-lg-3">
                        <div className="footer-left">
                            <div className="footer-logo">
                                <a href="#"><img src="img/footer-logo.png" alt=""/></a>
                            </div>
                            <ul>
                                <li>Address: 60-49 Road 11378 New York</li>
                                <li>Phone: +65 11.188.888</li>
                                <li>Email: hello.colorlib@gmail.com</li>
                            </ul>
                            <div className="footer-social">
                                <a href="#"><i className="fa fa-facebook"></i></a>
                                <a href="#"><i className="fa fa-instagram"></i></a>
                                <a href="#"><i className="fa fa-twitter"></i></a>
                                <a href="#"><i className="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-2 offset-lg-1">
                        <div className="footer-widget">
                            <h5>Information</h5>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Serivius</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-2">
                        <div className="footer-widget">
                            <h5>My Account</h5>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Shopping Cart</a></li>
                                <li><a href="#">Shop</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <div className="newslatter-item">
                            <h5>Join Our Newsletter Now</h5>
                            <p>Get E-mail updates about our latest shop and special offers.</p>
                            <form action="#" className="subscribe-form">
                                <input type="text" placeholder="Enter Your Mail"/>
                                <button type="button">Subscribe</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div className="copyright-reserved">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-12">
                            <div className="copyright-text">
                            </div>
                            <div className="payment-pic">
                                <img src="img/payment-method.png" alt=""/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        </>
    );
}

export async function getServerSideProps(context) {
    const cat = context.params?.cat;

    // load ...
    const catsResp = await axios.get(`http://${process.env.APP_SERVER}:${process.env.APP_PORT}/product/category`);
    const { categories } = await catsResp.data.result;

    const brandsResp = await axios.get(`http://${process.env.APP_SERVER}:${process.env.APP_PORT}/product/brand`);
    const { brands } = await brandsResp.data.result;

    const tagTypesResp = await axios.get(`http://${process.env.APP_SERVER}:${process.env.APP_PORT}/product/tag/types?types=COLOR,SIZE,TAG`);
    const { types:tagTypes } = await tagTypesResp.data.result;

    return {props: { cat:cat, categories:categories, brands:brands, tagTypes:tagTypes }};
}