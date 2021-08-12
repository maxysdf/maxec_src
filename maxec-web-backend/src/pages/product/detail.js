import axios from "axios";
import router, { useRouter } from "next/dist/client/router";
import { route } from "next/dist/next-server/server/router";
import { useEffect, useRef, useState } from "react";
import { useForm } from "react-hook-form";
import { utload } from "../../components/util"

export default function ProductDetail({product}) {
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

    return (
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
    );
}

export async function getServerSideProps(context) {
    const {productId} = context.query;
    const data = await utload(`/product/${productId}`);
    const product = data && data.product || {};

    return {props: { product: product }};
}
