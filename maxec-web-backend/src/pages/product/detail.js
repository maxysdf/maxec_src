import axios from "axios";
import router, { useRouter } from "next/dist/client/router";
import { useEffect, useRef, useState } from "react";
import { useForm } from "react-hook-form";
import { utload } from "../../components/util"
import styles from "./detail.module.css"
import Head from "next/head"

import dynamic from "next/dynamic"

export default function ProductDetailPage({product}) {
    const router = useRouter();

    const { register, handleSubmit, getValues } = useForm({
        defaultValues: {
            product: product
        }
    });

    const backClick = evt => {
        router.push({
            pathname: "/product/list"
        });
    };

    const saveClick = data => {
        const isUpd = product.id != null;
        if(!confirm(isUpd ? 'update?' : 'save?')) { return; }

        axios({
            url: '/api/product',
            method: isUpd ? 'PUT' : 'POST',
            data: data.product,
            headers: {'Content-Type': 'application/json'},
        }).then(res => {
            const {data} = res;
            alert('success, id=' + data.id);
            console.log(res);
        }).catch(e => {
            alert(e);
        });

    };

    useEffect(() => {
        const jQuery = dynamic(() => import("jquery/dist/jquery"));
        dynamic(() => import("bootstrap-fileinput/js/locales/LANG"));
        dynamic(() => import("bootstrap-fileinput/js/fileinput"));

        console.log(jQuery);

    });


    const trcls = (cls) => cls.split(' ').map(m=>styles[m]).join(' ');

    return (
        <div className={trcls('row')}>
            <Head>
                <title>商品維護</title>
            </Head>
            <div className={trcls('col-md-12')}>
                <div className={trcls('card')}>
                    <div className={trcls('card-header')}>
                        <h4 className={trcls('card-title')}>商品維護</h4>
                    </div>
                    <div className={trcls('card-body')}>
                        <form>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-12 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>商品名稱</label>
                                        <input id="name" className={trcls('form-control')} placeholder="商品名稱" {...register("product.name")} type="text" />
                                    </div>
                                </div>
                            </div>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-6 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        <label htmlFor="price">商品價格</label>
                                        <input id="price" className={trcls('form-control')} placeholder="product price" {...register("product.price")} type="number" />
                                    </div>
                                </div>
                                <div className={trcls('col-md-6 pl-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>網址連結</label>
                                        <input id="alias" className={trcls('form-control')}  placeholder="alias" {...register("product.alias")} type="text" />
                                    </div>
                                </div>
                            </div>


                            <div className={trcls('row')}>
                                <div className={trcls('col-md-12 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        
                                        <input type="file" id="ffile" />
                                    </div>
                                </div>
                            </div>
                            
                            {/*
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-5 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>Company (disabled)</label>
                                        <input type="text" className={trcls('form-control')} disabled="" placeholder="Company" value="Creative Code Inc."/>
                                    </div>
                                </div>
                                <div className={trcls('col-md-3 px-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>Username</label>
                                        <input type="text" className={trcls('form-control')} placeholder="Username" value="michael23"/>
                                    </div>
                                </div>
                                <div className={trcls('col-md-4 pl-1')}>
                                    <div className={trcls('form-group')}>
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input type="email" className={trcls('form-control')} placeholder="Email"/>
                                    </div>
                                </div>
                            </div>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-6 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>First Name</label>
                                        <input type="text" className={trcls('form-control')} placeholder="Company" value="Mike"/>
                                    </div>
                                </div>
                                <div className={trcls('col-md-6 pl-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>Last Name</label>
                                        <input type="text" className={trcls('form-control')} placeholder="Last Name" value="Andrew"/>
                                    </div>
                                </div>
                            </div>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-12')}>
                                    <div className={trcls('form-group')}>
                                        <label>Address</label>
                                        <input type="text" className={trcls('form-control')} placeholder="Home Address" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09"/>
                                    </div>
                                </div>
                            </div>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-4 pr-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>City</label>
                                        <input type="text" className={trcls('form-control')} placeholder="City" value="Mike"/>
                                    </div>
                                </div>
                                <div className={trcls('col-md-4 px-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>Country</label>
                                        <input type="text" className={trcls('form-control')} placeholder="Country" value="Andrew"/>
                                    </div>
                                </div>
                                <div className={trcls('col-md-4 pl-1')}>
                                    <div className={trcls('form-group')}>
                                        <label>Postal Code</label>
                                        <input type="number" className={trcls('form-control')} placeholder="ZIP Code"/>
                                    </div>
                                </div>
                            </div>
                            <div className={trcls('row')}>
                                <div className={trcls('col-md-12')}>
                                    <div className={trcls('form-group')}>
                                        <label>About Me</label>
                                        <textarea rows="4" cols="80" className={trcls('form-control')} placeholder="Here can be your description" value="Mike">Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.</textarea>
                                    </div>
                                </div>
                            </div>
                            */}
                            <input type="button" 
                                    className={trcls('btn btn-info btn-fill pull-right ml-3')}
                                    onClick={handleSubmit(saveClick)} value="更新" />
                            <input type="button" 
                                    className={trcls('btn btn-info btn-fill pull-right')}
                                    onClick={backClick} value="回到列表" />

                            <div className={trcls('clearfix')}></div>
                        </form>
                    </div>
                </div>
            </div>

            { /*
        <div>
            Product detail: <span>{product.name} {product.alias}</span> <br />
            <form>
                <input {...register("product.id")} type="hidden" />

                <label htmlFor="name">name:</label>
                <input id="name" placeholder="product name" {...register("product.name")} type="text" />
                <br />

                <label htmlFor="price">price:</label>
                <input id="price" placeholder="product price" {...register("product.price")} type="number" />
                <br />

                <label htmlFor="alias">alias:</label>
                <input id="alias" placeholder="alias" {...register("product.alias")} type="text" />
                <br />

            </form>

            <hr />
            <input type="button"  onClick={backClick} value="back" />
            <input type="button"  onClick={handleSubmit(saveClick)} value="save" />

        </div>
            */}
        </div>

        
    );
}

export async function getServerSideProps(context) {
    const {productId} = context.query;
    const data = await utload(`/product/${productId}`);
    const product = data && data.product || {};

    return {props: { product: product }};
}
