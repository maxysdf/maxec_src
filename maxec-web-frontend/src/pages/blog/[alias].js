import Link from "next/link"
import Image from "next/image"

import LayoutSimple from "../../components/layout_simple";

export default function BlogDetailPage() {

    const cont = (
        <section className="blog-details spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="blog-details-inner">
                            <div className="blog-detail-title">
                                <h2>The Personality Trait That Makes People Happier</h2>
                                <p>travel <span>- May 19, 2019</span></p>
                            </div>
                            <div className="blog-large-pic">
                                <Image src="/images/blog/blog-detail.jpg" width={1140} height={608} alt="" />
                            </div>
                            <div className="blog-detail-desc">
                                <p>psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit
                                    amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                                    magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                    aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.
                                </p>
                            </div>
                            <div className="blog-quote">
                                <p>“ Technology is nothing. What&apos;s important is that you have a faith in people, that
                                    they&apos;re basically good and smart, and if you give them tools, they&apos;ll do wonderful
                                    things with them.” <span>- Steven Jobs</span></p>
                            </div>
                            <div className="blog-more">
                                <div className="row">
                                    <div className="col-sm-4">
                                        <Image src="/images/blog/blog-detail-1.jpg" width={1140} height={608} alt="" />
                                    </div>
                                    <div className="col-sm-4">
                                        <Image src="/images/blog/blog-detail-2.jpg" width={1140} height={608} alt="" />
                                    </div>
                                    <div className="col-sm-4">
                                        <Image src="/images/blog/blog-detail-3.jpg" width={1140} height={608} alt="" />
                                    </div>
                                </div>
                            </div>
                            <p>Sum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
                                nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet,
                                consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                                ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.</p>
                            <div className="tag-share">
                                <div className="details-tag">
                                    <ul>
                                        <li><i className="fa fa-tags"></i></li>
                                        <li>Travel</li>
                                        <li>Beauty</li>
                                        <li>Fashion</li>
                                    </ul>
                                </div>
                                <div className="blog-share">
                                    <span>Share:</span>
                                    <div className="social-links">
                                        <a href="#"><i className="fa fa-facebook"></i></a>
                                        <a href="#"><i className="fa fa-twitter"></i></a>
                                        <a href="#"><i className="fa fa-google-plus"></i></a>
                                        <a href="#"><i className="fa fa-instagram"></i></a>
                                        <a href="#"><i className="fa fa-youtube-play"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div className="blog-post">
                                <div className="row">
                                    <div className="col-lg-5 col-md-6">
                                        <a href="#" className="prev-blog">
                                            <div className="pb-pic">
                                                <i className="ti-arrow-left"></i>
                                                <Image src="/images/blog/prev-blog.png" width={1140} height={608} alt="" />
                                            </div>
                                            <div className="pb-text">
                                                <span>Previous Post:</span>
                                                <h5>The Personality Trait That Makes People Happier</h5>
                                            </div>
                                        </a>
                                    </div>
                                    <div className="col-lg-5 offset-lg-2 col-md-6">
                                        <a href="#" className="next-blog">
                                            <div className="nb-pic">
                                                <Image src="/images/blog/next-blog.png" width={1140} height={608} alt="" />
                                                <i className="ti-arrow-right"></i>
                                            </div>
                                            <div className="nb-text">
                                                <span>Next Post:</span>
                                                <h5>The Personality Trait That Makes People Happier</h5>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div className="posted-by">
                                <div className="pb-pic">
                                    <Image src="/images/blog/post-by.png" width={91} height={89} alt="" />
                                </div>
                                <div className="pb-text">
                                    <a href="#">
                                        <h5>Shane Lynch</h5>
                                    </a>
                                    <p>Aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                                        velit esse cillum bore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                                        amodo</p>
                                </div>
                            </div>
                            <div className="leave-comment">
                                <h4>Leave A Comment</h4>
                                <form action="#" className="comment-form">
                                    <div className="row">
                                        <div className="col-lg-6">
                                            <input type="text" placeholder="Name"/>
                                        </div>
                                        <div className="col-lg-6">
                                            <input type="text" placeholder="Email"/>
                                        </div>
                                        <div className="col-lg-12">
                                            <textarea placeholder="Messages"></textarea>
                                            <button type="submit" className="site-btn">Send message</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );

    return (
        <LayoutSimple 
            components={cont}
            breadcrumbs={[
                {label:'首頁', path:'/', hasLink: true, icon: 'HOME' },
                {label:`專題文章`, path: `/blog/xxx`, hasLink: false}
            ]}
            title="專題文章"
        ></LayoutSimple>
    );
}

