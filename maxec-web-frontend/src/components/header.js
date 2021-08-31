import styles from "./header.module.css"
import Image from "next/image"
import Link from "next/link"
import { useRouter } from "next/dist/client/router";

export default function Header() {
    const router = useRouter();
    const trcls = (cls) => cls.split(' ').map(m=>styles[m] || m).join(' ');

    const gotoPath = (path) => {
        router.replace(path);
    };

    return (
        <header className={trcls('header-section')}>
            <div className={trcls('header-top')}>
                <div className={trcls('container')}>
                    <div className={trcls('ht-left')}>
                        <div className={trcls('mail-service')}>
                            <i className={trcls(' fa fa-envelope')}></i>
                            hello.colorlib@gmail.com
                        </div>
                        <div className={trcls('phone-service')}>
                            <i className={trcls(' fa fa-phone')}></i>
                            +65 11.188.888
                        </div>
                    </div>
                    <div className={trcls('ht-right')}>
                        <Link href="/login"><a className={trcls('login-panel')}><i className={trcls('fa fa-user')}></i>登入</a></Link>
                        <div className={trcls('lan-selector')}>
                            <select className={trcls('language_drop')} name="countries" id="countries" >
                                <option value='yt' data-image="img/flag-1.jpg" data-imagecss="flag yt"
                                    data-title="English">English</option>
                                <option value='yu' data-image="img/flag-2.jpg" data-imagecss="flag yu"
                                    data-title="Bangladesh">German </option>
                            </select>
                        </div>
                        <div className={trcls('top-social')}>
                            <a href="#"><i className={trcls('ti-facebook')}></i></a>
                            <a href="#"><i className={trcls('ti-twitter-alt')}></i></a>
                            <a href="#"><i className={trcls('ti-linkedin')}></i></a>
                            <a href="#"><i className={trcls('ti-pinterest')}></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div className={trcls('container')}>
                <div className={trcls('inner-header')}>
                    <div className={trcls('row')}>
                        <div className={trcls('col-lg-2 col-md-2')}>
                            <div className={trcls('logo')}>
                                <a href="./index.html">
                                    <Image src="/images/logo.png" alt="" height="23" width="88" layout="fixed" />
                                </a>
                            </div>
                        </div>
                        <div className={trcls('col-lg-7 col-md-7')}>
                            <div className={trcls('advanced-search')}>
                                <button type="button" className={trcls('category-btn')}>All Categories</button>
                                <div className={trcls('input-group')}>
                                    <input type="text" placeholder="What do you need?" />
                                    <button type="button"><i className={trcls('ti-search')}></i></button>
                                </div>
                            </div>
                        </div>
                        <div className={trcls('col-lg-3 text-right col-md-3')}>
                            <ul className={trcls('nav-right')}>
                                <li className={trcls('heart-icon')}>
                                    <a href="#">
                                        <i className={trcls('icon_heart_alt')}></i>
                                        <span>1</span>
                                    </a>
                                </li>
                                <li className={trcls('cart-icon')}>
                                    <Link href="/cart">
                                        <a>
                                            <i className={trcls('icon_bag_alt')}></i>
                                            <span>3</span>
                                        </a>
                                    </Link>
                                    <div className={trcls('cart-hover')}>
                                        <div className={trcls('select-items')}>
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td className={trcls('si-pic')}><Image src="/images/select-product-1.jpg" width={70} height={70} alt="" /></td>
                                                        <td className={trcls('si-text')}>
                                                            <div className={trcls('product-selected')}>
                                                                <p>$60.00 x 1</p>
                                                                <h6>Kabino Bedside Table</h6>
                                                            </div>
                                                        </td>
                                                        <td className={trcls('si-close')}>
                                                            <i className={trcls('ti-close')}></i>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td className={trcls('si-pic')}><Image src="/images/select-product-2.jpg" width={70} height={70} alt=""/></td>
                                                        <td className={trcls('si-text')}>
                                                            <div className={trcls('product-selected')}>
                                                                <p>$60.00 x 1</p>
                                                                <h6>Kabino Bedside Table</h6>
                                                            </div>
                                                        </td>
                                                        <td className={trcls('si-close')}>
                                                            <i className={trcls('ti-close')}></i>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div className={trcls('select-total')}>
                                            <span>total:</span>
                                            <h5>$120.00</h5>
                                        </div>
                                        <div className={trcls('select-button')}>
                                            <a href="#" className={trcls('primary-btn view-card')}>VIEW CARD</a>
                                            <a href="#" className={trcls('primary-btn checkout-btn')}>CHECK OUT</a>
                                        </div>
                                    </div>
                                </li>
                                <li className={trcls('cart-price')}>$150.00</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div className={trcls('nav-item')}>
                <div className={trcls('container')}>
                    <div className={trcls('nav-depart')}>
                        <div className={trcls('depart-btn')}>
                            <i className={trcls('ti-menu')}></i>
                            <span>All departments</span>
                            <ul className={trcls('depart-hover')}>
                                <li className={trcls('active')}><a href="#">Women&apos;s Clothing</a></li>
                                <li><a href="#">Men&apos;s Clothing</a></li>
                                <li><a href="#">Underwear</a></li>
                                <li><a href="#">Kid&apos;s Clothing</a></li>
                                <li><a href="#">Brand Fashion</a></li>
                                <li><a href="#">Accessories/Shoes</a></li>
                                <li><a href="#">Luxury Brands</a></li>
                                <li><a href="#">Brand Outdoor Apparel</a></li>
                            </ul>
                        </div>
                    </div>
                    <nav className={trcls('nav-menu mobile-menu')}>
                        <ul>
                            <li className={trcls('active')}>
                                <Link href="/"><a>首頁</a></Link>
                            </li>
                            <li><Link href="/category/all"><a>商品</a></Link></li>
                            <li><a href="#">目錄</a>
                                <ul className={trcls('dropdown')}>
                                    <li><a href="#">Men&apos;s</a></li>
                                    <li><a href="#">Women&apos;s</a></li>
                                    <li><a href="#">Kid&apos;s</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                            <li><a href="#">Pages</a>
                                <ul className={trcls('dropdown')}>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                    <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                    <li><a href="./check-out.html">Checkout</a></li>
                                    <li><a href="./faq.html">Faq</a></li>
                                    <li><a href="./register.html">Register</a></li>
                                    <li><a href="./login.html">Login</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                    <div id="mobile-menu-wrap"></div>
                </div>
            </div>
        </header>
    )
}