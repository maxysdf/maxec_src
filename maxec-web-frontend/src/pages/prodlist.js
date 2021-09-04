import Link from "next/link"
import Product from "../components/product"
import { utload } from "../components/util";

export default function ProductList({products}) {
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-3">
                    left
                </div>
                <div className="col-md-9">
                    <div className="container">
                        <div className="row">
                            {products.map((product) => (
                                    <Product key={product.id}
                                        name={product.name}
                                        alias={product.alias} />
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export async function getServerSideProps() {
    const products = await utload('/product');

    return {props: { products: products }};
}