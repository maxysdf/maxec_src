import { useEffect, useState } from "react";
import { GraphQLClient, request, gql } from "graphql-request"
import Head from "next/head"
import Breadcrumb from "../components/breadcrumb";
import { utGQL, utNumber } from "../components/util"
import Link from "next/link"

const CUST_ID = 'max'; // FIXME!!!!!

export default function CartPage() {
    const [cart,setCart] = useState(null);

    const updateItem = (id,qty) => {
        const query = `mutation($customerId:ID, $productId:ID, $qty:Int) {
            addOrUpdateCartItem(customerId:$customerId, productId:$productId, qty:$qty) {
              cart {
                total subtotal shipFee
                items { name price subtotal}
              }
            }
        }`;
        const customerId = CUST_ID;
        utGQL(query, {customerId:customerId, productId:id, qty:qty}, (res) => {
            const { addOrUpdateCartItem } = res;
            const { cart } = addOrUpdateCartItem;
            setCart(cart);
        })
    }

    const removeItem = (id) => {
        if(!confirm('確定要刪除嗎?')) { return; }

        const query = `mutation($customerId:ID, $productId:ID) {
            removeCartItem(customerId:$customerId, productId:$productId) {
              cart {
                total subtotal shipFee
                items { name price subtotal}
              }
            }
        }`;
        const customerId = CUST_ID;
        utGQL(query, {customerId:customerId, productId:id}, (res) => {
            const { removeCartItem } = res;
            const { cart } = removeCartItem;
            setCart(cart);
        })
    }

    useEffect(() => {
        const query = `query($customerId:ID) {
            getCart(customerId:$customerId) {
              response { result errorMessage code }
              cart {
                subtotal total shipFee
                items { productId name price qty subtotal }
              }
            }
        }`;
        const customerId = CUST_ID;
        utGQL(query, {customerId:customerId}, (res) => {
            const { getCart } = res;
            const { cart } = getCart;
            setCart(cart);
        })
    }, [cart])

    return (
        <>
        <Head>
            <title>購物車</title>
            <script type="text/javascript" src="/js/jquery.min.js"></script>
            <script type="text/javascript" src="/js/jquery-ui.min.js"></script>
            <script type="text/javascript" src="/js/jquery.nice-select.min.js"></script>
            <link type="text/css" rel="stylesheet" href="/css/jquery-ui.min.css" />
        </Head>
        <Breadcrumb list={[
            {label:'首頁', path:'/', hasLink: true, icon: 'HOME' },
            {label:`購物車`, path: `/cart`, hasLink: false}
        ]} />
        <section className="shopping-cart spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        { cart && cart.items &&
                        <>
                        <div className="cart-table">
                            <table>
                                <thead>
                                    <tr>
                                        <th>商品圖</th>
                                        <th className="p-name">品名</th>
                                        <th>價格</th>
                                        <th>數量</th>
                                        <th>商品小計</th>
                                        <th><i className="ti-close"></i></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    { cart.items.map( (ci,cii) => (
                                        <tr key={cii}>
                                            <td className="cart-pic first-row"><img src="img/cart-page/product-1.jpg" alt=""/></td>
                                            <td className="cart-title first-row">
                                                <h5>{ci.name}</h5>
                                            </td>
                                            <td className="p-price first-row">{utNumber(ci.price,true)}</td>
                                            <td className="qua-col first-row">
                                                <div className="quantity">
                                                    <div className="pro-qty">
                                                        <input type="text" defaultValue={ci.qty} onChange={e=>updateItem(ci.productId, e.target.value)} />
                                                    </div>
                                                </div>
                                            </td>
                                            <td className="total-price first-row">{utNumber(ci.subtotal,true)}</td>
                                            <td className="close-td first-row"><i className="ti-close" onClick={e=>removeItem(ci.productId)}></i></td>
                                        </tr>
                                    ) ) }
                                </tbody>
                            </table>
                        </div>
                        <div className="row">
                            <div className="col-lg-4">
                                <div className="cart-buttons">
                                    <a className="primary-btn continue-shop">繼續購物</a>
                                    <a href="#" className="primary-btn up-cart">更新購物車</a>
                                </div>
                                <div className="discount-coupon">
                                    <h6>折扣碼</h6>
                                    <form action="#" className="coupon-form">
                                        <input type="text" placeholder="輸入序號"/>
                                        <button type="submit" className="site-btn coupon-btn">套用</button>
                                    </form>
                                </div>
                            </div>
                            <div className="col-lg-4 offset-lg-4">
                                <div className="proceed-checkout">
                                    <ul>
                                        <li className="subtotal">小計 <span>{utNumber(cart.subtotal,true)}</span></li>
                                        <li className="cart-total">總計 <span>{utNumber(cart.total,true)}</span></li>
                                    </ul>
                                    <Link href="/checkout"><a className="proceed-btn">結帳</a></Link>
                                </div>
                            </div>
                        </div>
                        </>
                        }
                    </div>
                </div>
            </div>
        </section>

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