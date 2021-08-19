import { useRouter } from "next/dist/client/router";
import { useEffect, useState } from "react"
import useSWR from 'swr'
import { utNumber } from "../../components/util"

import styles from "./list.module.css"

export default function ProductListPage() {
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

    const trcls = (cls) => cls.split(' ').map(m=>styles[m]).join(' ');

    return (
        <div className={trcls('row')}>
            <div className={trcls('col-md-12')}>
                <div className={trcls('card strpied-tabled-with-hover')}>
                    <div className={trcls('card-header ')}>
                        <h4 className={trcls('card-title')}>商品清單</h4>
                        {/* <p className={trcls('card-category')}>Here is a subtitle for this table</p> */}
                    </div>

                    { page && 
                    <>
                    <nav aria-label="Page navigation example ">
                        <ul className={trcls('pagination justify-content-end')}>
                            { !page.first && <li className={trcls('page-item')}><a className={trcls('page-link')} href="#">&lt;</a></li> }
                            { [... Array(page.totalPages)].map( (_,i) => (
                                <li key={i} className={trcls('page-item')}><a className={trcls('page-link')} key={i} href="#" onClick={e => setPageNo(i)}>{i+1}</a></li>
                            ) ) }
                            { !page.last && <li className={trcls('page-item')}><a className={trcls('page-link')} href="#">&gt;</a></li> }
                        </ul>
                    </nav>

                    <div className={trcls('card-body table-full-width table-responsive')}>
                        <table className={trcls('table table-hover table-striped')}>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>名稱</th>
                                    <th>售價</th>
                                    <th>連結</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                { page.content.map( (p,i) => (
                                    <tr key={i}>
                                        <td>{page.number * page.size + i + 1}</td>
                                        <td>{p.name}</td>
                                        <td>{utNumber(p.price, true)}</td>
                                        <td>{p.alias}</td>
                                        <td>
                                        <input type="button" onClick={(e) => router.push(`/product/detail?productId=${p.id}`)} value="修改" />
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                    </>
                    }
                    <div className="card-footer text-muted">
                        <input type="button" onClick={(e) => router.push(`/product/detail`)} value="新增" />
                    </div>
                    
                </div>

            </div>

            {/*
            ProductList: page {pageNo+1}
            
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

            */}
        </div>
    )
}