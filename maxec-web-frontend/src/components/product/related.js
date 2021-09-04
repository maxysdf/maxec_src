import Image from 'next/image'

export default function ProductRelated() {
    return (
        <>
        <div className="related-products spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="section-title">
                            <h2>Related Products</h2>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-lg-3 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <Image src="img/products/women-1.jpg" width={262} height={320} alt=""/>
                                <div className="sale">Sale</div>
                                <div className="icon">
                                    <i className="icon_heart_alt"></i>
                                </div>
                                <ul>
                                    <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                    <li className="quick-view"><a href="#">+ Quick View</a></li>
                                    <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                </ul>
                            </div>
                            <div className="pi-text">
                                <div className="catagory-name">Coat</div>
                                <a href="#">
                                    <h5>Pure Pineapple</h5>
                                </a>
                                <div className="product-price">
                                    $14.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-3 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <Image src="img/products/women-2.jpg" width={262} height={320} alt=""/>
                                <div className="icon">
                                    <i className="icon_heart_alt"></i>
                                </div>
                                <ul>
                                    <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                    <li className="quick-view"><a href="#">+ Quick View</a></li>
                                    <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                </ul>
                            </div>
                            <div className="pi-text">
                                <div className="catagory-name">Shoes</div>
                                <a href="#">
                                    <h5>Guangzhou sweater</h5>
                                </a>
                                <div className="product-price">
                                    $13.00
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-3 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <Image src="img/products/women-3.jpg" width={262} height={320} alt=""/>
                                <div className="icon">
                                    <i className="icon_heart_alt"></i>
                                </div>
                                <ul>
                                    <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                    <li className="quick-view"><a href="#">+ Quick View</a></li>
                                    <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                </ul>
                            </div>
                            <div className="pi-text">
                                <div className="catagory-name">Towel</div>
                                <a href="#">
                                    <h5>Pure Pineapple</h5>
                                </a>
                                <div className="product-price">
                                    $34.00
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-3 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <Image src="img/products/women-4.jpg" width={262} height={320} alt=""/>
                                <div className="icon">
                                    <i className="icon_heart_alt"></i>
                                </div>
                                <ul>
                                    <li className="w-icon active"><a href="#"><i className="icon_bag_alt"></i></a></li>
                                    <li className="quick-view"><a href="#">+ Quick View</a></li>
                                    <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                </ul>
                            </div>
                            <div className="pi-text">
                                <div className="catagory-name">Towel</div>
                                <a href="#">
                                    <h5>Converse Shoes</h5>
                                </a>
                                <div className="product-price">
                                    $34.00
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
}