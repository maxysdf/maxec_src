import Link from "next/link"
import Image from "next/image"
import { useEffect } from "react";

import LayoutProduct from "../../components/layout_product";

export default function CategoryPage() {
    useEffect(() => {
        /*-------------------
            Nice Select
        --------------------- */
        $('.sorting, .p-show').niceSelect();
    }, []);

    const cont = (
        <>
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
                            <Image src="/images/products/product-1.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-2.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-3.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-4.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-5.jpg" width={262} height={294} alt="" />
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
                                <h5>Men&apos;s Painted Hat</h5>
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
                            <Image src="/images/products/product-6.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-7.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-8.jpg" width={262} height={294} alt="" />
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
                            <Image src="/images/products/product-9.jpg" width={262} height={294} alt="" />
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
        </>
    )

    return (
        <LayoutProduct components={cont}></LayoutProduct>
    );
}



// import ProductSidebar from "../../components/product/sidebar";
// import Head from "next/head"
// import ProductList from "../../components/product/list";
// import { useEffect, useState } from "react";
// import Footer from "../../components/footer";
// import Partner from "../../components/partner"
// import Breadcrumb from "../../components/breadcrumb"

// import { GraphQLClient, request, gql } from "graphql-request"

// export default function CategoryPage(props) {
//     const [filterData,setFilterData] = useState({cat:props.cat});

//     const filter = (data) => {
//         setFilterData({...data, cat:props.cat});
//     };

//     useEffect(() => {
//         window.scrollTo(
//             {top: $('.productListZone').offset().top,
//             behavior: "smooth" }
//         );
//     }, [filterData]);

//     return (
//         <>
//         <Head>
//             <title>列表頁</title>
//             <script type="text/javascript" async src="/js/jquery.min.js"></script>
//             <script type="text/javascript" async src="/js/jquery-ui.min.js"></script>
//             <script type="text/javascript" async src="/js/jquery.nice-select.min.js"></script>
//         </Head>
//         <Breadcrumb list={[
//             {label:'首頁', path:'/', hasLink: true, icon: 'HOME' },
//             {label:`列表頁`, path: `/${props.cat}`, hasLink: false}
//         ]} />

//         {/* photo shop */}
//         <section className="product-shop spad">
//             <div className="container">
//                 <div className="row">
//                     <ProductSidebar 
//                         categories={props.categories}
//                         brands={props.brands}
//                         tagTypes={props.tagTypes}
//                         onFilter={filter}>
//                     </ProductSidebar>
//                     <ProductList
//                         filterData={filterData}>
//                     </ProductList>
//                 </div>
//             </div>
//         </section>
        
//         {/* partner */}
//         <Partner />
        
//         {/* footer */}
//         <Footer></Footer>
//         </>
//     );
// }

// export async function getServerSideProps(context) {
//     const cat = context.params?.cat;

//     const client = new GraphQLClient(
//         `http://${process.env.APP_SERVER}:${process.env.APP_PORT}/graphql`
//     );

//     const query = gql`{
//         listBrands { brands { id name }}
//         listCategories { categories { id name }}
//         listTagGroupByTypes(types:["COLOR","SIZE","TAG"]) {
//             tagGroups { type tags { type id code name value } }
//         }
//     }`;

//     const { listBrands, listCategories, listTagGroupByTypes } = await client.request(query);
//     const { categories } = listCategories;
//     const { brands } = listBrands;

//     //const tagTypes = [];
//     const { tagGroups:tagTypes } = listTagGroupByTypes;

//     return {props: { cat:cat, categories:categories, brands:brands, tagTypes:tagTypes }};
// }