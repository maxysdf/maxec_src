import Link from "next/link";

export default function Product({name, alias}) {
    return (
        <div className="col-md-3">
            <Link href={`/product/${alias}`}>
            <a>product {name}</a>
            </Link>
        </div>
    );
}