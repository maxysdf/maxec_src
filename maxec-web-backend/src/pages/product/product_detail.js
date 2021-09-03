import { useEffect, useState } from "react";

import { utGQL, GQL_RESP } from "../../components/util";
import LayoutAdmin from "../../components/layout_admin";
import { useRouter } from "next/dist/client/router";

export default function ProductDetailPage() {
    const [product,setProduct] = useState(null);
    const [formData,setFormData] = useState(null);
    const router = useRouter();

    useEffect(() => {
        const id = window.sessionStorage.getItem('PRODUCT_DETAIL::ID');

        const qry = `query ($id:ID) {
            findProductById(id:$id) {
                ${GQL_RESP}
                product { id name price alias sku }
            }
        }`;

        utGQL(qry, {id:id}, (data) => {
            const product = data.findProductById.product;
            setFormData({
                id: product.id,
                name: product.name,
                price: product.price,
                alias: product.alias,
                sku: product.sku,
            });
            setProduct(product);
        });
    }, []);

    const updateFormData = (fld, val) => { const f = {...formData}; f[fld] = val; setFormData(f); }


    const updateClick = () => {
        const qry = `mutation($input:ProductInput) {
            saveProduct(product:$input) { ${GQL_RESP} }
        }`;

        utGQL(qry, {input:formData}, (data) => {
            const resp = data.saveProduct.response;
            if(!resp.result) {
                alert('儲存失敗: ' + resp.errorMessage);
                return;
            }
            alert('儲存成功');
        });
    };


    const comp = (
        <>
        { JSON.stringify(formData) }
        { product && 
        <div className="row">
            <div className="col-md-12">
                <div className="card card-primary">
                    <div className="card-header">
                        <h3 className="card-title">編輯商品 - {product.name}</h3>
                    </div>
                    <form autoComplete="false">
                        <div className="card-body">
                            <div className="form-group">
                                <label htmlFor="name">商品名稱</label>
                                <input type="text" className="form-control" id="name" placeholder="名稱" 
                                    defaultValue={formData.name} onChange={e=>updateFormData('name', e.target.value)} />
                            </div>
                            <div className="row">
                                <div className="col-sm-4">
                                    <div className="form-group">
                                        <label htmlFor="sku">SKU</label>
                                        <input type="text" className="form-control" id="sku" placeholder="SKU"
                                            defaultValue={formData.sku} onChange={e=>updateFormData('sku', e.target.value)}/>
                                    </div>
                                </div>
                                <div className="col-sm-4">
                                    <div className="form-group">
                                        <label htmlFor="price">價格</label>
                                        <input type="number" className="form-control" id="price" placeholder="價格" 
                                            defaultValue={formData.price} onChange={e=>updateFormData('price', e.target.value)}/>
                                    </div>
                                </div>
                                <div className="col-sm-4">
                                    <div className="form-group">
                                        <label htmlFor="alias">別名 (alias)</label>
                                        <input type="text" className="form-control" id="alias" placeholder="別名"
                                            defaultValue={formData.alias} onChange={e=>updateFormData('alias', e.target.value)}/>
                                    </div>
                                </div>
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputFile">File input</label>
                                <div className="input-group">
                                    <div className="custom-file">
                                        <input type="file" className="custom-file-input" id="exampleInputFile"/>
                                        <label className="custom-file-label" htmlFor="exampleInputFile">Choose file</label>
                                    </div>
                                    <div className="input-group-append">
                                        <span className="input-group-text">Upload</span>
                                    </div>
                                </div>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                <label className="form-check-label" htmlFor="exampleCheck1">Check me out</label>
                            </div>
                        </div>

                        <div className="card-footer">
                            <button type="button" className="btn btn-secondary mr-1" onClick={e=>router.replace('/product/product_list')}>回列表</button>
                            <button type="button" className="btn btn-primary" onClick={e=>updateClick()}>儲存</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        }
        </>
    );

    return (<LayoutAdmin components={comp} title="商品編輯"></LayoutAdmin>);
}