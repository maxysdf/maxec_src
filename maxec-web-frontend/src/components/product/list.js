import { useEffect } from "react";


export default function ProductList({filterData}) {
    if(!filterData) { return <div></div>; }

    useEffect(() => {
        alert('list: ' + JSON.stringify(filterData));
    }, [filterData])

    return (
        <div className="col-lg-9 order-1 order-lg-2">
            <div className="product-show-option">
                <div className="row">
                    <div className="col-lg-7 col-md-7">
                        <div className="select-option">
                            <select className="sorting">
                                <option value="">Default Sorting</option>
                            </select>
                            <select className="p-show">
                                <option value="">Show:</option>
                            </select>
                        </div>
                    </div>
                    <div className="col-lg-5 col-md-5 text-right">
                        <p>Show 01- 09 Of 36 Product</p>
                    </div>
                </div>
            </div>
            <div className="product-list">
                <div className="row">
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-1.jpg" alt=""/>
                                <div className="sale pp-sale">Sale</div>
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
                                    $14.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-2.jpg" alt=""/>
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
                                    <h5>Guangzhou sweater</h5>
                                </a>
                                <div className="product-price">
                                    $13.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-3.jpg" alt=""/>
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
                                    $34.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-4.jpg" alt=""/>
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
                                    <h5>Microfiber Wool Scarf</h5>
                                </a>
                                <div className="product-price">
                                    $64.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-5.jpg" alt=""/>
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
                                    <h5>Men's Painted Hat</h5>
                                </a>
                                <div className="product-price">
                                    $44.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-6.jpg" alt=""/>
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
                                    <h5>Converse Shoes</h5>
                                </a>
                                <div className="product-price">
                                    $34.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-7.jpg" alt=""/>
                                <div className="sale pp-sale">Sale</div>
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
                                    $64.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-8.jpg" alt=""/>
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
                                    <h5>2 Layer Windbreaker</h5>
                                </a>
                                <div className="product-price">
                                    $44.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <img src="img/products/product-9.jpg" alt=""/>
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
                                    <h5>Converse Shoes</h5>
                                </a>
                                <div className="product-price">
                                    $34.00
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="loading-more">
                <i className="icon_loading"></i>
                <a href="#">
                    Loading More
                </a>
            </div>
        </div>
    );
}