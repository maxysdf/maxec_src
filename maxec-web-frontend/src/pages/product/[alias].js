import { utload } from '../../components/util'

export default function ProductDetail({product}) {
    return (
        <div>
            product detail, {product.name}
        </div>
    );
}

export async function getServerSideProps(context) {
    const params = context.params;
    const alias = params.alias;
    const data = await utload('/product/alias', {alias: alias});

    const product = data.product;
    if (!product) {
        return {
          notFound: true,
        }
      }

    // const products = [
    //     {id: '1', name: "test"},
    //     {id: '2', name: "test1"},
    //     {id: '3', name: "test2"},
    //     {id: '4', name: "test3"},
    // ]

    return {props: { product: product }};
}