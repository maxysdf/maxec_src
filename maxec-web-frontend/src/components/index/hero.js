import Script from "next/script"
import { useEffect } from "react";

export default function IndexHero() {
    useEffect(() => {
        /*------------------
            Hero Slider
        --------------------*/
        $(".hero-items").owlCarousel({
            loop: true,
            margin: 0,
            nav: true,
            items: 1,
            dots: false,
            animateOut: 'fadeOut',
            animateIn: 'fadeIn',
            navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true,
        });
    }, []);

    return (
        <>
        <section className="hero-section">
            <div className="hero-items owl-carousel">
                <div className="single-hero-items set-bg" data-setbg="/images/hero-1.jpg">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-5">
                                <span>Bag,kids</span>
                                <h1>Black friday</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore</p>
                                <a href="#" className="primary-btn">Shop Now</a>
                            </div>
                        </div>
                        <div className="off-card">
                            <h2>Sale <span>50%</span></h2>
                        </div>
                    </div>
                </div>
                <div className="single-hero-items set-bg" data-setbg="/images/hero-2.jpg">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-5">
                                <span>Bag,kids</span>
                                <h1>Black friday</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore</p>
                                <a href="#" className="primary-btn">Shop Now</a>
                            </div>
                        </div>
                        <div className="off-card">
                            <h2>Sale <span>50%</span></h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        </>
        
    );
}