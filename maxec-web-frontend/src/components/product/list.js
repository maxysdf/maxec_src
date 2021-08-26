import axios from "axios";
import { useEffect, useLayoutEffect, useState } from "react";
import Image from "next/image"
import Link from "next/link"
import { GraphQLClient, request, gql } from "graphql-request"
import { utGQL } from "../util";

const CUST_ID = 'max'; // FIXME!!!!!

export default function ProductList({filterData}) {
    if(!filterData) { return <div></div>; }

    const [page,setPage] = useState(null);
    const [show,setShow] = useState(9);
    const [sort,setSort] = useState('PRICE');

    const [openSort,setOpenSort] = useState(false);

    const addCart = (id,qty) => {
        const query = `mutation($customerId:ID, $productId:ID, $qty:Int) {
            addOrUpdateCartItem(customerId:$customerId, productId:$productId, qty:$qty) {
              cart {
                total subtotal shipFee
                items { name price subtotal}
              }
              response { result errorMessage }
            }
        }`;
        const customerId = CUST_ID;
        utGQL(query, {customerId:customerId, productId:id, qty:qty}, (res) => {
            const { addOrUpdateCartItem } = res;
            if(addOrUpdateCartItem.response.result) { alert('已加入'); }
            if(!addOrUpdateCartItem.response.result) { alert(addOrUpdateCartItem.response.errorMessage); }
        })
    }

    useEffect(() => {
        const brandTags = filterData.brands && filterData.brands.map(b=> ({type:'BRAND', id:b}) ) || [];
        const sizeTags = filterData.sizes && filterData.sizes.map(b=> ({type:'SIZE', id:b}) ) || [];
        const colorTags = filterData.colors && filterData.colors.map(b=> ({type:'COLOR', id:b}) ) || [];
        const tagTags = filterData.tags && Object.keys(filterData.tags).map(b=> ({type:'TAG', id:b}) ) || [];
        const tags = [
            ...brandTags, ...sizeTags,
            ...colorTags, ...tagTags
        ];

        const searchData = {
            category: filterData.cat,
            minPrice: filterData.priceRange && filterData.priceRange[0] || null,
            maxPrice: filterData.priceRange && filterData.priceRange[1] || null,
            sort: sort.split('_')[0],
            sortAsc: sort.endsWith('_ASC'),
            pageNo: 1,
            pageSize: show == 'ALL' ? 9999 : show,
            tags: tags
        };

        const query = `query ($param: SearchProductParam) {
            searchProduct(param:$param) {
                page {
                    totalPages totalElements number numberOfElements size  hasContent
                    content: searchProductResult {
                        id name price alias
                    }
                }
                response { errorMessage result code }
            }
        }`;

        const customerId = CUST_ID;
        utGQL(query, {param:searchData}, (res) => {
            const { searchProduct } = res;
            const { page } = searchProduct;
            setPage(page);
        })
        
    }, [filterData, show, sort])

    return (
        <div className="col-lg-9 order-1 order-lg-2 productListZone">
            { (!page || !page.hasContent) &&
            <div className="loading-more">
                <a href="#">
                    無符合商品
                </a>
            </div>
            }

            { page && page.hasContent &&
            <>
            <div className="product-show-option">
                <div className="row">
                    <div className="col-lg-7 col-md-7">

                        <div className="select-option">

                            <select className="sorting" onChange={e=>setSort(e.target.value)}>
                                <option value="RELATIVE">關連性</option>
                                <option value="SALE_DESC">銷售量</option>
                                <option value="DATE_DESC">發售時間新至舊</option>
                                <option value="DATE_DESC">發售時間舊至新</option>
                                <option value="PRICE_ASC">價格低至高</option>
                                <option value="PRICE_DESC">價格高至低</option>
                            </select>
                            <select className="p-show" onChange={e=>setShow(e.target.value)}>
                                <option value="9">9</option>
                                <option value="18">18</option>
                                <option value="ALL">全部</option>
                            </select>
                        </div>
                    </div>
                    <div className="col-lg-5 col-md-5 text-right">
                        <p>顯示第{(page.number-1) * page.size + 1}至{page.number * page.size + page.numberOfElements}筆, 共{page.totalElements}筆商品</p>
                    </div>
                </div>
            </div>
            <div className="product-list">
                <div className="row">

                    { page.content.map((p,pi) => (
                    <div key={pi} className="col-lg-4 col-sm-6">
                        <div className="product-item">
                            <div className="pi-pic">
                                <Image src="/images/products/man-1.jpg" height={294} width={262} layout="fixed" />
                                <img src="img/products/product-1.jpg" alt=""/>
                                <div className="sale pp-sale">Sale</div>
                                <div className="icon">
                                    <i className="icon_heart_alt"></i>
                                </div>
                                <ul>
                                    <li className="w-icon active"><a onClick={e=>addCart(p.id, 1)}><i className="icon_bag_alt"></i></a></li>
                                    <li className="quick-view"><Link href={`/product/${p.alias}`}><a>+ Quick View</a></Link></li>
                                    <li className="w-icon"><a href="#"><i className="fa fa-random"></i></a></li>
                                </ul>
                            </div>
                            <div className="pi-text">
                                <div className="catagory-name">Towel</div>
                                <a href="#">
                                    <h5>{p.name}</h5>
                                </a>
                                <div className="product-price">
                                    ${p.price}
                                    <span>$35.00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    ) ) }

                    {/*
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
                    */ }
                </div>
            </div>
            </>
            }
            <div className="loading-more">
                <i className="icon_loading"></i>
                <a href="#">
                    Loading More
                </a>
            </div>
        </div>
    );
}