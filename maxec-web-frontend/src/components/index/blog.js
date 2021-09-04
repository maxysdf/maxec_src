import Script from "next/script"
import Link from "next/link"
import Image from "next/image"

export default function IndexBlog() {
    return (
        <>
        <section className="latest-blog spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="section-title">
                            <h2>精選文章</h2>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-lg-4 col-md-6">
                        <div className="single-latest-blog">
                            <Image src="/images/latest-1.jpg" width={371} height={267} alt=""/>
                            <div className="latest-text">
                                <div className="tag-list">
                                    <div className="tag-item">
                                        <i className="fa fa-calendar-o"></i>
                                        May 4,2019
                                    </div>
                                    <div className="tag-item">
                                        <i className="fa fa-comment-o"></i>
                                        5
                                    </div>
                                </div>
                                <Link href="/blog/xxx">
                                    <a><h4>The Best Street Style From London Fashion Week</h4></a>
                                </Link>
                                <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-md-6">
                        <div className="single-latest-blog">
                            <Image src="/images/latest-2.jpg" width={371} height={267} alt=""/>
                            <div className="latest-text">
                                <div className="tag-list">
                                    <div className="tag-item">
                                        <i className="fa fa-calendar-o"></i>
                                        May 4,2019
                                    </div>
                                    <div className="tag-item">
                                        <i className="fa fa-comment-o"></i>
                                        5
                                    </div>
                                </div>
                                <a href="#">
                                    <h4>Vogue&apos;s Ultimate Guide To Autumn/Winter 2019 Shoes</h4>
                                </a>
                                <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-md-6">
                        <div className="single-latest-blog">
                            <Image src="/images/latest-3.jpg" width={371} height={267} alt=""/>
                            <div className="latest-text">
                                <div className="tag-list">
                                    <div className="tag-item">
                                        <i className="fa fa-calendar-o"></i>
                                        May 4,2019
                                    </div>
                                    <div className="tag-item">
                                        <i className="fa fa-comment-o"></i>
                                        5
                                    </div>
                                </div>
                                <a href="#">
                                    <h4>How To Brighten Your Wardrobe With A Dash Of Lime</h4>
                                </a>
                                <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="benefit-items">
                    <div className="row">
                        <div className="col-lg-4">
                            <div className="single-benefit">
                                <div className="sb-icon">
                                    <Image src="/images/icon-1.png" width={47} height={34} alt=""/>
                                </div>
                                <div className="sb-text">
                                    <h6>Free Shipping</h6>
                                    <p>For all order over 99$</p>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4">
                            <div className="single-benefit">
                                <div className="sb-icon">
                                    <Image src="/images/icon-2.png" width={47} height={34} alt=""/>
                                </div>
                                <div className="sb-text">
                                    <h6>Delivery On Time</h6>
                                    <p>If good have prolems</p>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4">
                            <div className="single-benefit">
                                <div className="sb-icon">
                                    <Image src="/images/icon-1.png" width={47} height={34} alt=""/>
                                </div>
                                <div className="sb-text">
                                    <h6>Secure Payment</h6>
                                    <p>100% secure payment</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        </>
    );
}