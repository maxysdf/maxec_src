import Link from "next/link"
import Image from "next/image"

import LayoutBlog from "../components/layout_blog";

export default function BlogPage() {

    const cont = (
        <>
        <div className="row">
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-1.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                    <Link href="/blog/xxx">
                            <a><h4>This was one of our first days in Hawaii last week.</h4></a>
                        </Link>
                        <p>travel <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-2.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                        <Link href="/blog/xxx">
                            <a><h4>This was one of our first days in Hawaii last week.</h4></a>
                        </Link>
                        <p>Fashion <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-3.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                        <a href="./blog-details.html">
                            <h4>Last week I had my first work trip of the year to Sonoma Valley</h4>
                        </a>
                        <p>travel <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-4.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                        <a href="./blog-details.html">
                            <h4>Happppppy New Year! I know I am a little late on this post</h4>
                        </a>
                        <p>Fashion <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-5.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                        <a href="./blog-details.html">
                            <h4>Absolue collection. The Lancome team has been one…</h4>
                        </a>
                        <p>Model <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-6 col-sm-6">
                <div className="blog-item">
                    <div className="bi-pic">
                        <Image src="/images/blog/blog-6.jpg" width={408} height={279} alt="" />
                    </div>
                    <div className="bi-text">
                        <a href="./blog-details.html">
                            <h4>Writing has always been kind of therapeutic for me</h4>
                        </a>
                        <p>Fashion <span>- May 19, 2019</span></p>
                    </div>
                </div>
            </div>
            <div className="col-lg-12">
                <div className="loading-more">
                    <i className="icon_loading"></i>
                    <a href="#">
                        Loading More
                    </a>
                </div>
            </div>
        </div>
        </>
    );

    return (<LayoutBlog components={cont}></LayoutBlog>)
}