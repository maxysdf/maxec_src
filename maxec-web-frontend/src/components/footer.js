import Image from "next/image"

export default function Footer() {
    return (
        <>
        <footer className="footer-section">
            <div className="container">
                <div className="row">
                    <div className="col-lg-3">
                        <div className="footer-left">
                            <div className="footer-logo">
                                <a href="#"><Image width={88} height={23} src="/images/footer-logo.png" alt=""/></a>
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
                            <h5>資訊中心</h5>
                            <ul>
                                <li><a href="#">關於我們</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Serivius</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-2">
                        <div className="footer-widget">
                            <h5>我的帳號</h5>
                            <ul>
                                <li><a href="#">我的帳號</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">購物車</a></li>
                                <li><a href="#">Shop</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <div className="newslatter-item">
                            <h5>現在加入我們的電子報</h5>
                            <p>取得最新情報及特殊優惠</p>
                            <form action="#" className="subscribe-form">
                                <input type="text" placeholder="您的Email"/>
                                <button type="button">訂閱</button>
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
                                <Image src="/images/payment-method.png" alt="" width={288} height={25}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        
        </>


    )
}