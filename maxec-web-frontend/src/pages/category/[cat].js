import axios from "axios";
import ProductSidebar from "../../components/product/sidebar";
import Head from "next/head"
import { useEffect } from "react";

export default function CategoryPage(props) {

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
                            <a href="#"><i className="fa fa-home"></i> Home</a>
                            <span>Shop</span>
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
                        brands={props.brands} />
                    <div className="col-lg-9 order-1 order-lg-2">
                        <div className="product-show-option">
                            <div className="row">
                                <div className="col-lg-7 col-md-7">
                                    <div className="select-option">
                                        <select className="sorting">
                                            <option value="">Default Sorting</option>
                                        </select>
                                        <select className="p-show">
                                            <option value="">Show:</option>
                                        </select>
                                    </div>
                                </div>
                                <div className="col-lg-5 col-md-5 text-right">
                                    <p>Show 01- 09 Of 36 Product</p>
                                </div>
                            </div>
                        </div>
                        <div className="product-list">
                            <div className="row">
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-1.jpg" alt=""/>
                                            <div className="sale pp-sale">Sale</div>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div className="product-price">
                                                $14.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-2.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Coat</div>
                                            <a href="#">
                                                <h5>Guangzhou sweater</h5>
                                            </a>
                                            <div className="product-price">
                                                $13.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-3.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Guangzhou sweater</h5>
                                            </a>
                                            <div className="product-price">
                                                $34.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-4.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Coat</div>
                                            <a href="#">
                                                <h5>Microfiber Wool Scarf</h5>
                                            </a>
                                            <div className="product-price">
                                                $64.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-5.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Men's Painted Hat</h5>
                                            </a>
                                            <div className="product-price">
                                                $44.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-6.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Converse Shoes</h5>
                                            </a>
                                            <div className="product-price">
                                                $34.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-7.jpg" alt=""/>
                                            <div className="sale pp-sale">Sale</div>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div className="product-price">
                                                $64.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-8.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Coat</div>
                                            <a href="#">
                                                <h5>2 Layer Windbreaker</h5>
                                            </a>
                                            <div className="product-price">
                                                $44.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-sm-6">
                                    <div className="product-item">
                                        <div className="pi-pic">
                                            <img src="img/products/product-9.jpg" alt=""/>
                                            <div className="icon">
                                                <i className="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                                <li className="quick-view"><a href="#">+ Quick View</a></li>
                                                <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                            </ul>
                                        </div>
                                        <div className="pi-text">
                                            <div className="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Converse Shoes</h5>
                                            </a>
                                            <div className="product-price">
                                                $34.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="loading-more">
                            <i className="icon_loading"></i>
                            <a href="#">
                                Loading More
                            </a>
                        </div>
                    </div>
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

    return {props: { categories:categories, brands:brands }};
}