import Image from "next/image"

export default function BlogSidebar() {
    return (
        <>
        <div className="blog-sidebar">
            <div className="search-form">
                <h4>Search</h4>
                <form action="#">
                    <input type="text" placeholder="Search . . .  "/>
                    <button type="submit"><i className="fa fa-search"></i></button>
                </form>
            </div>
            <div className="blog-catagory">
                <h4>Categories</h4>
                <ul>
                    <li><a href="#">Fashion</a></li>
                    <li><a href="#">Travel</a></li>
                    <li><a href="#">Picnic</a></li>
                    <li><a href="#">Model</a></li>
                </ul>
            </div>
            <div className="recent-post">
                <h4>Recent Post</h4>
                <div className="recent-blog">
                    <a href="#" className="rb-item">
                        <div className="rb-pic">
                            <Image src="/images/blog/recent-1.jpg" width={80} height={80} alt="" />
                        </div>
                        <div className="rb-text">
                            <h6>The Personality Trait That Makes...</h6>
                            <p>Fashion <span>- May 19, 2019</span></p>
                        </div>
                    </a>
                    <a href="#" className="rb-item">
                        <div className="rb-pic">
                            <Image src="/images/blog/recent-2.jpg" width={80} height={80} alt="" />
                        </div>
                        <div className="rb-text">
                            <h6>The Personality Trait That Makes...</h6>
                            <p>Fashion <span>- May 19, 2019</span></p>
                        </div>
                    </a>
                    <a href="#" className="rb-item">
                        <div className="rb-pic">
                            <Image src="/images/blog/recent-3.jpg" width={80} height={80} alt="" />
                        </div>
                        <div className="rb-text">
                            <h6>The Personality Trait That Makes...</h6>
                            <p>Fashion <span>- May 19, 2019</span></p>
                        </div>
                    </a>
                    <a href="#" className="rb-item">
                        <div className="rb-pic">
                            <Image src="/images/blog/recent-4.jpg" width={80} height={80} alt="" />
                        </div>
                        <div className="rb-text">
                            <h6>The Personality Trait That Makes...</h6>
                            <p>Fashion <span>- May 19, 2019</span></p>
                        </div>
                    </a>
                </div>
            </div>
            <div className="blog-tags">
                <h4>Product Tags</h4>
                <div className="tag-item">
                    <a href="#">Towel</a>
                    <a href="#">Shoes</a>
                    <a href="#">Coat</a>
                    <a href="#">Dresses</a>
                    <a href="#">Trousers</a>
                    <a href="#">Men&apos;s hats</a>
                    <a href="#">Backpack</a>
                </div>
            </div>
        </div>
        </>
    );
}