import { useRouter } from "next/dist/client/router";
import { useEffect, useState } from "react";
import LayoutAdmin from "../../components/layout_admin";
import Pager from "../../components/pager";

import { utGQL, GQL_PAGE_FLDS, GQL_RESP, utNumber } from "../../components/util";

export default function BrandListPage() {
    const [page,setPage] = useState(null);
    const [pageNo, setPageNo] = useState(0);
    const [keyword,setKeyword] = useState(null);
    const [loading, setLoading] = useState(false);
    const [reload, setReload] = useState(0);
    const router = useRouter();

    useEffect(() => {
        const qry = `query ($param:ProductBrandPageParam) {
            pageBrand(param: $param) { ${GQL_RESP}
              page { ${GQL_PAGE_FLDS}
                result:pageBrandResult { 
                    id name 
                }
              }
            }
        }`;
        
        const keywords = keyword && [keyword] || [];
        setLoading(true);
        utGQL(qry, {param:{pageSize:10,pageNo:pageNo,keywords:keywords}}, (data) => {
            setLoading(false);
            setPage(data.pageBrand.page);
        });
    }, [pageNo, reload, keyword]);

    const keywordClick = () => {
        setPageNo(0);
        setReload(new Date().getTime());
    };

    const comp = (
        <div className="row">
            <div className="col-12">
                <div className="card">
                    <div className="card-header">
                        <h3 className="card-title">商品清單</h3>
                        <div className="card-tools">
                            <div className="float-right toolbtn ml-3">
                                <button type="button" className="btn btn-block btn-success btn-sm ">新增</button>
                            </div>
                            
                            <Pager page={page} onPage={p=>setPageNo(p)} />

                            <div className="input-group input-group-sm" style={{width:'150px'}}>
                                <input type="text" name="table_search" className="form-control float-right" placeholder="Search"
                                    defaultValue={keyword} onChange={e=>setKeyword(e.target.value)} />
                                <div className="input-group-append">
                                    <button type="button" className="btn btn-default" 
                                        onClick={e=> keywordClick()}>
                                        <i className="fas fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
              
                    <div className="card-body table-responsive p-0">
                        {loading && 
                        <div className="overlay tableoverlay">
                            <i className="fas fa-3x fa-sync-alt fa-spin"></i>
                            <div className="text-bold pt-2">Loading...</div>
                        </div>
                        }
                        <table className="table table-hover text-nowrap">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>名稱</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            { page && page.result &&
                            <tbody>
                                { page.result.map((p,pi) => (
                                <tr key={pi}>
                                    <td>{(page.number)*page.size + pi + 1 }</td>
                                    <td>{p.name}</td>
                                    <td>
                                        <button type="button" className="btn btn-warning btn-sm mr-1" onClick={e=>editClick(p.id)}>修改</button>
                                        <button type="button" className="btn btn-danger btn-sm " onClick={e=>deleteClick(p.id)}>刪除</button>
                                    </td>
                                </tr>
                                )) }
                            </tbody>
                            }
                            { !page && 
                            <tbody>
                                <tr><td colSpan="5">無資料</td></tr>
                            </tbody>
                            }
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );

    return (<LayoutAdmin components={comp} title="品牌管理"></LayoutAdmin>);
}