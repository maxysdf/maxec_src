import Link from "next/link"
import Image from "next/image"

import LayoutSimple from "../components/layout_simple";

export default function CartPage() {

    const cont = (
        <section className="shopping-cart spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="cart-table">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Image</th>
                                        <th className="p-name">Product Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th><i className="ti-close"></i></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td className="cart-pic first-row"><Image src="/images/cart-page/product-1.jpg" width={170} height={170} alt=""/></td>
                                        <td className="cart-title first-row">
                                            <h5>Pure Pineapple</h5>
                                        </td>
                                        <td className="p-price first-row">$60.00</td>
                                        <td className="qua-col first-row">
                                            <div className="quantity">
                                                <div className="pro-qty">
                                                    <input type="text" defaultValue="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="total-price first-row">$60.00</td>
                                        <td className="close-td first-row"><i className="ti-close"></i></td>
                                    </tr>
                                    <tr>
                                        <td className="cart-pic"><Image src="/images/cart-page/product-2.jpg" width={170} height={170} alt=""/></td>
                                        <td className="cart-title">
                                            <h5>American lobster</h5>
                                        </td>
                                        <td className="p-price">$60.00</td>
                                        <td className="qua-col">
                                            <div className="quantity">
                                                <div className="pro-qty">
                                                    <input type="text" defaultValue="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="total-price">$60.00</td>
                                        <td className="close-td"><i className="ti-close"></i></td>
                                    </tr>
                                    <tr>
                                        <td className="cart-pic"><Image src="/images/cart-page/product-3.jpg" width={170} height={170} alt=""/></td>
                                        <td className="cart-title">
                                            <h5>Guangzhou sweater</h5>
                                        </td>
                                        <td className="p-price">$60.00</td>
                                        <td className="qua-col">
                                            <div className="quantity">
                                                <div className="pro-qty">
                                                    <input type="text" defaultValue="1"/>
                                                </div>
                                            </div>
                                        </td>
                                        <td className="total-price">$60.00</td>
                                        <td className="close-td"><i className="ti-close"></i></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div className="row">
                            <div className="col-lg-4">
                                <div className="cart-buttons">
                                    <a href="#" className="primary-btn continue-shop">Continue shopping</a>
                                    <a href="#" className="primary-btn up-cart">Update cart</a>
                                </div>
                                <div className="discount-coupon">
                                    <h6>Discount Codes</h6>
                                    <form action="#" className="coupon-form">
                                        <input type="text" placeholder="Enter your codes"/>
                                        <button type="submit" className="site-btn coupon-btn">Apply</button>
                                    </form>
                                </div>
                            </div>
                            <div className="col-lg-4 offset-lg-4">
                                <div className="proceed-checkout">
                                    <ul>
                                        <li className="subtotal">Subtotal <span>$240.00</span></li>
                                        <li className="cart-total">Total <span>$240.00</span></li>
                                    </ul>
                                    <Link href="/checkout"><a className="proceed-btn">繼續結帳</a></Link>
                                </div>
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
                {label:`購物車`, path: `/cart`, hasLink: false}
            ]}
            title="購物車"
        ></LayoutSimple>
    );
}


// import { useEffect, useState } from "react";
// import Image from "next/image"
// import Link from "next/link"

// import Head from "next/head"
// import Breadcrumb from "../components/breadcrumb";
// import Partner from "../components/partner";
// import Footer from "../components/footer";

// import { utGQL, utNumber } from "../components/util"

// const CUST_ID = 'max'; // FIXME!!!!!

// export default function CartPage() {
//     const [cart,setCart] = useState(null);

//     const updateItem = (id,qty) => {
//         const query = `mutation($customerId:ID, $productId:ID, $qty:Int) {
//             addOrUpdateCartItem(customerId:$customerId, productId:$productId, qty:$qty) {
//               cart {
//                 total subtotal shipFee
//                 items { name price subtotal}
//               }
//             }
//         }`;
//         const customerId = CUST_ID;
//         utGQL(query, {customerId:customerId, productId:id, qty:qty}, (res) => {
//             const { addOrUpdateCartItem } = res;
//             const { cart } = addOrUpdateCartItem;
//             setCart(cart);
//         })
//     }

//     const removeItem = (id) => {
//         if(!confirm('確定要刪除嗎?')) { return; }

//         const query = `mutation($customerId:ID, $productId:ID) {
//             removeCartItem(customerId:$customerId, productId:$productId) {
//               cart {
//                 total subtotal shipFee
//                 items { name price subtotal}
//               }
//             }
//         }`;
//         const customerId = CUST_ID;
//         utGQL(query, {customerId:customerId, productId:id}, (res) => {
//             const { removeCartItem } = res;
//             const { cart } = removeCartItem;
//             setCart(cart);
//         })
//     }

//     useEffect(() => {
//         const query = `query($customerId:ID) {
//             getCart(customerId:$customerId) {
//               response { result errorMessage code }
//               cart {
//                 subtotal total shipFee
//                 items { productId name price qty subtotal }
//               }
//             }
//         }`;
//         const customerId = CUST_ID;
//         utGQL(query, {customerId:customerId}, (res) => {
//             const { getCart } = res;
//             const { cart } = getCart;
//             setCart(cart);
//         })
//     }, [cart])

//     return (
//         <>
//         <Head>
//             <title>購物車</title>
//             <script type="text/javascript" async src="/js/jquery.min.js"></script>
//             <script type="text/javascript" async src="/js/jquery-ui.min.js"></script>
//             <script type="text/javascript" async src="/js/jquery.nice-select.min.js"></script>
//         </Head>
//         <Breadcrumb list={[
//             {label:'首頁', path:'/', hasLink: true, icon: 'HOME' },
//             {label:`購物車`, path: `/cart`, hasLink: false}
//         ]} />
//         <section className="shopping-cart spad">
//             <div className="container">
//                 <div className="row">
//                     <div className="col-lg-12">
//                         { cart && cart.items &&
//                         <>
//                         <div className="cart-table">
//                             <table>
//                                 <thead>
//                                     <tr>
//                                         <th>商品圖</th>
//                                         <th className="p-name">品名</th>
//                                         <th>價格</th>
//                                         <th>數量</th>
//                                         <th>商品小計</th>
//                                         <th><i className="ti-close"></i></th>
//                                     </tr>
//                                 </thead>
//                                 <tbody>
//                                     { cart.items.map( (ci,cii) => (
//                                         <tr key={cii}>
//                                             <td className="cart-pic first-row"><Image src="/images/cart-page/product-1.jpg" width={170} height={170} alt=""/></td>
//                                             <td className="cart-title first-row">
//                                                 <h5>{ci.name}</h5>
//                                             </td>
//                                             <td className="p-price first-row">{utNumber(ci.price,true)}</td>
//                                             <td className="qua-col first-row">
//                                                 <div className="quantity">
//                                                     <div className="pro-qty">
//                                                         <input type="text" defaultdefaultValue={ci.qty} onChange={e=>updateItem(ci.productId, e.target.value)} />
//                                                     </div>
//                                                 </div>
//                                             </td>
//                                             <td className="total-price first-row">{utNumber(ci.subtotal,true)}</td>
//                                             <td className="close-td first-row"><i className="ti-close" onClick={e=>removeItem(ci.productId)}></i></td>
//                                         </tr>
//                                     ) ) }
//                                 </tbody>
//                             </table>
//                         </div>
//                         <div className="row">
//                             <div className="col-lg-4">
//                                 <div className="cart-buttons">
//                                     <a className="primary-btn continue-shop">繼續購物</a>
//                                     <a href="#" className="primary-btn up-cart">更新購物車</a>
//                                 </div>
//                                 <div className="discount-coupon">
//                                     <h6>折扣碼</h6>
//                                     <form action="#" className="coupon-form">
//                                         <input type="text" placeholder="輸入序號"/>
//                                         <button type="submit" className="site-btn coupon-btn">套用</button>
//                                     </form>
//                                 </div>
//                             </div>
//                             <div className="col-lg-4 offset-lg-4">
//                                 <div className="proceed-checkout">
//                                     <ul>
//                                         <li className="subtotal">小計 <span>{utNumber(cart.subtotal,true)}</span></li>
//                                         <li className="cart-total">總計 <span>{utNumber(cart.total,true)}</span></li>
//                                     </ul>
//                                     <Link href="/checkout"><a className="proceed-btn">結帳</a></Link>
//                                 </div>
//                             </div>
//                         </div>
//                         </>
//                         }
//                     </div>
//                 </div>
//             </div>
//         </section>

//         <Partner />

//         <Footer />
//         </>
//     );
// }