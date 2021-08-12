import { useRouter } from "next/dist/client/router";
import { useEffect, useState } from "react"
import useSWR from 'swr'
import getConfig from 'next/config'

export default function ProductList() {
    const router = useRouter();
    const [mounted,setMounted] = useState(false);
    const [pageNo,setPageNo] = useState(0);
    useEffect(() => {
        setMounted(true);
    }, []);

    const fetcher = url => fetch(url).then(r => r.json()).then(json => json.page);
    const { data:page, error:pageErr } = useSWR(mounted ? '/api/product?ps=10&pn=' + pageNo : null, fetcher);

    const newClick = e => {
        e.preventDefault();
        router.push('/product/detail');
    };

    return (
        <div>
            ProductList: page {pageNo+1}
            
            {getConfig().publicRuntimeConfig?.apiEndpoint }

            <input type="button" onClick={newClick} value="new" />
            <hr />

            { page && 
                <>
                <div>
                    { [... Array(page.totalPages)].map( (_,i) => (
                        <a key={i} className="link" onClick={e => setPageNo(i)}>{i+1}</a>
                    ) ) }
                </div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>name</th>
                            <th>price</th>
                            <th>alias</th>
                            <th>action</th>
                        </tr>
                    </thead>
                    <tbody>
                        { page.content.map( (p,i) => (
                            <tr key={i}>
                                <td>{page.number * page.size + i + 1}</td>
                                <td>{p.name}</td>
                                <td>{p.price}</td>
                                <td>{p.alias}</td>
                                <td>
                                    <input type="button" onClick={(e) => router.push(`/product/detail?productId=${p.id}`)} value="update" />
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                </>
            }
        </div>
    )
}