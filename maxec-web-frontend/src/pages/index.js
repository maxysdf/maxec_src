import Script from "next/script"
import IndexDoTW from "../components/index/dotw";
import IndexHero from "../components/index/hero";
import IndexBlog from "../components/index/blog";
import IndexIG from "../components/index/ig";

import LayoutSimple from "../components/layout_simple";
import IndexCategoryBanner from "../components/index/banner";
import IndexManBanner from "../components/index/banner-man";
import IndexWomanBanner from "../components/index/banner-woman";
import { useEffect } from "react";


export default function IndexPage() {

    useEffect(() => {
        /*------------------
            Background Set
        --------------------*/
        $('.set-bg').each(function () {
            var bg = $(this).data('setbg');
            $(this).css('background-image', 'url(' + bg + ')');
        });
    }, [])

    const cont = (
        <>
        <IndexHero />

        <IndexCategoryBanner />

        <IndexWomanBanner />
        
        <IndexDoTW />

        <IndexManBanner />

        <IndexIG />

        <IndexBlog />

        </>
    );

    return (
        <LayoutSimple title="首頁" components={cont}></LayoutSimple>
    );
}



// export default function Home() {
//     const router = useRouter();
//     const goPath = () => {

//     };

//     useEffect(() => {
//         /*------------------
//             Background Set
//         --------------------*/
//         $('.set-bg').each(function () {
//             var bg = $(this).data('setbg');
//             $(this).css('background-image', 'url(' + bg + ')');
//         });

//         /*------------------
//             Hero Slider
//         --------------------*/
//         $(".hero-items").owlCarousel({
//             loop: true,
//             margin: 0,
//             nav: true,
//             items: 1,
//             dots: false,
//             animateOut: 'fadeOut',
//             animateIn: 'fadeIn',
//             navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
//             smartSpeed: 1200,
//             autoHeight: false,
//             autoplay: true,
//         });
//     }, []);

//     return (
//         <>
//             <section className={'hero-section'}>
//                 <div className={'hero-items owl-carousel'}>
//                     <div className={'single-hero-items set-bg'} data-setbg="/images/hero-1.jpg">
//                         <div className={'container'}>
//                             <div className={'row'}>
//                                 <div className={'col-lg-5'}>
//                                     <span>Bag,kids</span>
//                                     <h1>Black friday</h1>
//                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
//                                         incididunt ut labore et dolore</p>
//                                     <a href="#" className={'primary-btn'}>Shop Now</a>
//                                 </div>
//                             </div>
//                             <div className={'off-card'}>
//                                 <h2>Sale <span>50%</span></h2>
//                             </div>
//                         </div>
//                     </div>
//                     <div className={'single-hero-items set-bg'} data-setbg="images/hero-2.jpg">
//                         <div className={'container'}>
//                             <div className={'row'}>
//                                 <div className={'col-lg-5'}>
//                                     <span>Bag,kids</span>
//                                     <h1>Black friday</h1>
//                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
//                                         incididunt ut labore et dolore</p>
//                                     <a href="#" className={'primary-btn'}>Shop Now</a>
//                                 </div>
//                             </div>
//                             <div className={'off-card'}>
//                                 <h2>Sale <span>50%</span></h2>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </section>

//             {/* banner section */}
//             <div className={'banner-section spad'}>
//                 <div className={'container-fluid'}>
//                     <div className={'row'}>
//                         <div className={'col-lg-4'}>
//                             <Link href="/category/men" passHref>
//                             <div className={'single-banner'}>
//                                 <Image src="/images/banner-1.jpg" width={570} height={320} layout="responsive" alt="" />
//                                 <div className={'inner-text'}>
//                                     <h4>Men&apos;s</h4>
//                                 </div>
//                             </div>
//                             </Link>
//                         </div>
//                         <div className={'col-lg-4'}>
//                             <div className={'single-banner'}>
//                             <Image src="/images/banner-2.jpg" width={570} height={320} layout="responsive" alt="" />
//                                 <div className={'inner-text'}>
//                                     <h4>Women&apos;s</h4>
//                                 </div>
//                             </div>
//                         </div>
//                         <div className={'col-lg-4'}>
//                             <div className={'single-banner'}>
//                             <Image src="/images/banner-3.jpg" width={570} height={320} layout="responsive" alt="" />
//                                 <div className={'inner-text'}>
//                                     <h4>Kid&apos;s</h4>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </div>

//             {/* women banner */}
//             <section className={'women-banner spad'}>
//                 <div className={'container-fluid'}>
//                     <div className={'row'}>
//                         <div className={'col-lg-3'}>
//                             <div className={'product-large set-bg'} data-setbg="/images/products/women-large.jpg">
//                                 <h2>Women’s</h2>
//                                 <a href="#">Discover More</a>
//                             </div>
//                         </div>
//                         <div className={'col-lg-8 offset-lg-1'}>
//                             <div className={'filter-control'}>
//                                 <ul>
//                                     <li className={'active'}>Clothings</li>
//                                     <li>HandBag</li>
//                                     <li>Shoes</li>
//                                     <li>Accessories</li>
//                                 </ul>
//                             </div>
//                             <div className={'product-slider owl-carousel'}>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/women-1.jpg" width={225} height={275} alt=""/>
//                                         <div className={'sale'}>Sale</div>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Coat</div>
//                                         <a href="#">
//                                             <h5>Pure Pineapple</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $14.00
//                                             <span>$35.00</span>
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/women-2.jpg" width={225} height={275} alt=""/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Shoes</div>
//                                         <a href="#">
//                                             <h5>Guangzhou sweater</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $13.00
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/women-3.jpg" alt="" width={225} height={275}/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Towel</div>
//                                         <a href="#">
//                                             <h5>Pure Pineapple</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $34.00
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/women-4.jpg" width={225} height={275} alt=""/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Towel</div>
//                                         <a href="#">
//                                             <h5>Converse Shoes</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $34.00
//                                         </div>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </section>

//             {/* deal of week section */}
//             <section className={'deal-of-week set-bg spad'} data-setbg="/images/time-bg.jpg">
//                 <div className={'container'}>
//                     <div className={'col-lg-6 text-center'}>
//                         <div className={'section-title'}>
//                             <h2>Deal Of The Week</h2>
//                             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed<br /> do ipsum dolor sit amet,
//                                 consectetur adipisicing elit </p>
//                             <div className={'product-price'}>
//                                 $35.00
//                                 <span>/ HanBag</span>
//                             </div>
//                         </div>
//                         <div className={'countdown-timer'} id="countdown">
//                             <div className={'cd-item'}>
//                                 <span>56</span>
//                                 <p>Days</p>
//                             </div>
//                             <div className={'cd-item'}>
//                                 <span>12</span>
//                                 <p>Hrs</p>
//                             </div>
//                             <div className={'cd-item'}>
//                                 <span>40</span>
//                                 <p>Mins</p>
//                             </div>
//                             <div className={'cd-item'}>
//                                 <span>52</span>
//                                 <p>Secs</p>
//                             </div>
//                         </div>
//                         <a href="#" className={'primary-btn'}>Shop Now</a>
//                     </div>
//                 </div>
//             </section>

//             {/* man banner */}
//             <section className={'man-banner spad'}>
//                 <div className={'container-fluid'}>
//                     <div className={'row'}>
//                         <div className={'col-lg-8'}>
//                             <div className={'filter-control'}>
//                                 <ul>
//                                     <li className={'active'}>Clothings</li>
//                                     <li>HandBag</li>
//                                     <li>Shoes</li>
//                                     <li>Accessories</li>
//                                 </ul>
//                             </div>
//                             <div className={'product-slider owl-carousel'}>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/man-1.jpg" width={225} height={275} alt=""/>
//                                         <div className={'sale'}>Sale</div>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Coat</div>
//                                         <a href="#">
//                                             <h5>Pure Pineapple</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $14.00
//                                             <span>$35.00</span>
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/man-2.jpg" width={225} height={275} alt=""/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Shoes</div>
//                                         <a href="#">
//                                             <h5>Guangzhou sweater</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $13.00
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/man-3.jpg" width={225} height={275} alt=""/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Towel</div>
//                                         <a href="#">
//                                             <h5>Pure Pineapple</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $34.00
//                                         </div>
//                                     </div>
//                                 </div>
//                                 <div className={'product-item'}>
//                                     <div className={'pi-pic'}>
//                                         <Image src="/images/products/man-4.jpg" width={225} height={275} alt=""/>
//                                         <div className={'icon'}>
//                                             <i className={'icon_heart_alt'}></i>
//                                         </div>
//                                         <ul>
//                                             <li className={'w-icon active'}><a href="#"><i className={'icon_bag_alt'}></i></a></li>
//                                             <li className={'quick-view'}><a href="#">+ Quick View</a></li>
//                                             <li className={'w-icon'}><a href="#"><i className={'fa fa-random'}></i></a></li>
//                                         </ul>
//                                     </div>
//                                     <div className={'pi-text'}>
//                                         <div className={'catagory-name'}>Towel</div>
//                                         <a href="#">
//                                             <h5>Converse Shoes</h5>
//                                         </a>
//                                         <div className={'product-price'}>
//                                             $34.00
//                                         </div>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                         <div className={'col-lg-3 offset-lg-1'}>
//                             <div className={'product-large set-bg m-large'} data-setbg="/images/products/man-large.jpg">
//                                 <h2>Men’s</h2>
//                                 <a href="#">Discover More</a>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </section>

//             {/* ig section */}
//             <div className={'instagram-photo'}>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-1.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-2.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-3.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-4.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-5.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//                 <div className={'insta-item set-bg'} data-setbg="/images/insta-6.jpg">
//                     <div className={'inside-text'}>
//                         <i className={'ti-instagram'}></i>
//                         <h5><a href="#">colorlib_Collection</a></h5>
//                     </div>
//                 </div>
//             </div>

//             {/* last blog section */}
//             <section className={'latest-blog spad'}>
//                 <div className={'container'}>
//                     <div className={'row'}>
//                         <div className={'col-lg-12'}>
//                             <div className={'section-title'}>
//                                 <h2>From The Blog</h2>
//                             </div>
//                         </div>
//                     </div>
//                     <div className={'row'}>
//                         <div className={'col-lg-4 col-md-6'}>
//                             <div className={'single-latest-blog'}>
//                                 <Image src="/images/latest-1.jpg" width={360} height={259} alt=""/>
//                                 <div className={'latest-text'}>
//                                     <div className={'tag-list'}>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-calendar-o'}></i>
//                                             May 4,2019
//                                         </div>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-comment-o'}></i>
//                                             5
//                                         </div>
//                                     </div>
//                                     <a href="#">
//                                         <h4>The Best Street Style From London Fashion Week</h4>
//                                     </a>
//                                     <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
//                                 </div>
//                             </div>
//                         </div>
//                         <div className={'col-lg-4 col-md-6'}>
//                             <div className={'single-latest-blog'}>
//                                 <Image src="/images/latest-2.jpg" width={360} height={259} alt=""/>
//                                 <div className={'latest-text'}>
//                                     <div className={'tag-list'}>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-calendar-o'}></i>
//                                             May 4,2019
//                                         </div>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-comment-o'}></i>
//                                             5
//                                         </div>
//                                     </div>
//                                     <a href="#">
//                                         <h4>Vogue&apos;s Ultimate Guide To Autumn/Winter 2019 Shoes</h4>
//                                     </a>
//                                     <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
//                                 </div>
//                             </div>
//                         </div>
//                         <div className={'col-lg-4 col-md-6'}>
//                             <div className={'single-latest-blog'}>
//                                 <Image src="/images/latest-3.jpg" width={360} height={259} alt=""/>
//                                 <div className={'latest-text'}>
//                                     <div className={'tag-list'}>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-calendar-o'}></i>
//                                             May 4,2019
//                                         </div>
//                                         <div className={'tag-item'}>
//                                             <i className={'fa fa-comment-o'}></i>
//                                             5
//                                         </div>
//                                     </div>
//                                     <a href="#">
//                                         <h4>How To Brighten Your Wardrobe With A Dash Of Lime</h4>
//                                     </a>
//                                     <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                     <div className={'benefit-items'}>
//                         <div className={'row'}>
//                             <div className={'col-lg-4'}>
//                                 <div className={'single-benefit'}>
//                                     <div className={'sb-icon'}>
//                                         <Image src="/images/icon-1.png" width={47} height={34} alt=""/>
//                                     </div>
//                                     <div className={'sb-text'}>
//                                         <h6>Free Shipping</h6>
//                                         <p>For all order over 99$</p>
//                                     </div>
//                                 </div>
//                             </div>
//                             <div className={'col-lg-4'}>
//                                 <div className={'single-benefit'}>
//                                     <div className={'sb-icon'}>
//                                         <Image src="/images/icon-2.png" width={38} height={38} alt=""/>
//                                     </div>
//                                     <div className={'sb-text'}>
//                                         <h6>Delivery On Time</h6>
//                                         <p>If good have prolems</p>
//                                     </div>
//                                 </div>
//                             </div>
//                             <div className={'col-lg-4'}>
//                                 <div className={'single-benefit'}>
//                                     <div className={'sb-icon'}>
//                                         <Image src="/images/icon-1.png" width={47} height={34} alt=""/>
//                                     </div>
//                                     <div className={'sb-text'}>
//                                         <h6>Secure Payment</h6>
//                                         <p>100% secure payment</p>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </section>

//             <Partner />
            
//             <Footer />

//             <Script src="/js/jquery.min.js" strategy="beforeInteractive"></Script>
//             <Script src="/js/owl.carousel.min.js" strategy="beforeInteractive"></Script>
//         </>
//     );
// }
