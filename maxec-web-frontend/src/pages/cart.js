
export default function CartPage() {
    return (
        <>
        <section class="shopping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="cart-table">
                            <table>
                                <thead>
                                    <tr>
                                        <th>商品圖</th>
                                        <th class="p-name">品名</th>
                                        <th>價格</th>
                                        <th>數量</th>
                                        <th>商品小計</th>
                                        <th><i class="ti-close"></i></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="cart-pic first-row"><img src="img/cart-page/product-1.jpg" alt=""/></td>
                                        <td class="cart-title first-row">
                                            <h5>Pure Pineapple</h5>
                                        </td>
                                        <td class="p-price first-row">$60.00</td>
                                        <td class="qua-col first-row">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="total-price first-row">$60.00</td>
                                        <td class="close-td first-row"><i class="ti-close"></i></td>
                                    </tr>
                                    <tr>
                                        <td class="cart-pic"><img src="img/cart-page/product-2.jpg" alt=""/></td>
                                        <td class="cart-title">
                                            <h5>American lobster</h5>
                                        </td>
                                        <td class="p-price">$60.00</td>
                                        <td class="qua-col">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="total-price">$60.00</td>
                                        <td class="close-td"><i class="ti-close"></i></td>
                                    </tr>
                                    <tr>
                                        <td class="cart-pic"><img src="img/cart-page/product-3.jpg" alt=""/></td>
                                        <td class="cart-title">
                                            <h5>Guangzhou sweater</h5>
                                        </td>
                                        <td class="p-price">$60.00</td>
                                        <td class="qua-col">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="total-price">$60.00</td>
                                        <td class="close-td"><i class="ti-close"></i></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="cart-buttons">
                                    <a href="#" class="primary-btn continue-shop">繼續購物</a>
                                    <a href="#" class="primary-btn up-cart">更新購物車</a>
                                </div>
                                <div class="discount-coupon">
                                    <h6>折扣碼</h6>
                                    <form action="#" class="coupon-form">
                                        <input type="text" placeholder="輸入序號"/>
                                        <button type="submit" class="site-btn coupon-btn">套用</button>
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-4 offset-lg-4">
                                <div class="proceed-checkout">
                                    <ul>
                                        <li class="subtotal">小計 <span>$240.00</span></li>
                                        <li class="cart-total">總計 <span>$240.00</span></li>
                                    </ul>
                                    <a href="#" class="proceed-btn">結帳</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div class="partner-logo">
            <div class="container">
                <div class="logo-carousel owl-carousel">
                    <div class="logo-item">
                        <div class="tablecell-inner">
                            <img src="img/logo-carousel/logo-1.png" alt=""/>
                        </div>
                    </div>
                    <div class="logo-item">
                        <div class="tablecell-inner">
                            <img src="img/logo-carousel/logo-2.png" alt=""/>
                        </div>
                    </div>
                    <div class="logo-item">
                        <div class="tablecell-inner">
                            <img src="img/logo-carousel/logo-3.png" alt=""/>
                        </div>
                    </div>
                    <div class="logo-item">
                        <div class="tablecell-inner">
                            <img src="img/logo-carousel/logo-4.png" alt=""/>
                        </div>
                    </div>
                    <div class="logo-item">
                        <div class="tablecell-inner">
                            <img src="img/logo-carousel/logo-5.png" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="footer-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="footer-left">
                            <div class="footer-logo">
                                <a href="#"><img src="img/footer-logo.png" alt=""/></a>
                            </div>
                            <ul>
                                <li>Address: 60-49 Road 11378 New York</li>
                                <li>Phone: +65 11.188.888</li>
                                <li>Email: hello.colorlib@gmail.com</li>
                            </ul>
                            <div class="footer-social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 offset-lg-1">
                        <div class="footer-widget">
                            <h5>Information</h5>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Serivius</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="footer-widget">
                            <h5>My Account</h5>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Shopping Cart</a></li>
                                <li><a href="#">Shop</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="newslatter-item">
                            <h5>Join Our Newsletter Now</h5>
                            <p>Get E-mail updates about our latest shop and special offers.</p>
                            <form action="#" class="subscribe-form">
                                <input type="text" placeholder="Enter Your Mail"/>
                                <button type="button">Subscribe</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright-reserved">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="copyright-text">
                            </div>
                            <div class="payment-pic">
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