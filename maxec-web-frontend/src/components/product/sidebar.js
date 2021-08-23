import Link from "next/link";
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";

export default function ProductSidebar({categories, brands, tagTypes, onFilter = f => f }) {
    const minPrice = 0;
    const maxPrice = 5000;
    const [fBrands,setFBrands] = useState({});
    const [fMinPrice,setFMinPrice] = useState(0);
    const [fMaxPrice,setFMaxPrice] = useState(5000);
    const [fTags,setFTags] = useState({});

    const changeBrand = (e,id) => {
        const checked = e.target.checked;
        if( checked) fBrands[id]=true;
        if(!checked) delete fBrands[id];
        setFBrands(fBrands);
    };

    const changeTag = (e,id,checked) => {
        alert(id + ' ' + checked);
        if( checked) fTags[id]=true;
        if(!checked) delete fTags[id];
        setFTags(fTags);
    };

    const doFilter = () => {
        const data = {
            brands: Object.keys(fBrands),
            priceRange: [fMinPrice,fMaxPrice],
            tags: fTags
        };
        onFilter(data);
    };

    useEffect(() => {
        /*-------------------
		    Range Slider
        --------------------- */
        var rangeSlider = $(".price-range"),
            minamount = $("#minamount"),
            maxamount = $("#maxamount"),
            minPrice = rangeSlider.data('min'),
            maxPrice = rangeSlider.data('max');

        rangeSlider.slider({
            range: true,
            min: minPrice,
            max: maxPrice,
            values: [minPrice, maxPrice],
            slide: function (event, ui) {
                minamount.val('$' + ui.values[0]);
                maxamount.val('$' + ui.values[1]);
                setFMinPrice(ui.values[0]);
                setFMaxPrice(ui.values[1]);
            }
        });
        minamount.val('$' + rangeSlider.slider("values", 0));
        maxamount.val('$' + rangeSlider.slider("values", 1));

        /*-------------------
            Radio Btn
        --------------------- */
        const refreshTags = () => {
            const arr = [
                ...$('.fw-color-choose label.active').siblings('input').map((i,e)=>e.value).get(),
                ...$('.fw-size-choose label.active').siblings('input').map((i,e)=>e.value).get(),
                ...$('.fw-tag-choose label.active').siblings('input').map((i,e)=>e.value).get(),
            ];
            setFTags(arr);
        };

        $(".fw-color-choose .cs-item label, .pd-color-choose .sc-item label").on('click', function (evt) {
            $(".fw-color-choose .cs-item label").removeClass('active');
            $(this).addClass('active');
            refreshTags();
        });

        $(".fw-size-choose .sc-item label, .pd-size-choose .sc-item label").on('click', function (evt) {
            $(".fw-size-choose .sc-item label, .pd-size-choose .sc-item label").removeClass('active');
            $(this).addClass('active');
            refreshTags();
        });

        $(".fw-tag-choose .sc-item label, .pd-tag-choose .sc-item label").on('click', function (evt) {
            //$(".fw-tag-choose .sc-item label, .pd-tag-choose .sc-item label").removeClass('active');
            $(this).toggleClass('active');
            refreshTags();
        });

    }, []);

    return (
        <div className="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
            <div className="filter-widget">
                <h4 className="fw-title">目錄</h4>
                <ul className="filter-catagories">
                    { categories.map( (c,ci) => (
                        <li key={ci}><a href="#">{c.name}</a></li>
                    ) ) }
                </ul>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">品牌</h4>
                <div className="fw-brand-check">
                    { brands.map( (c,ci) => (
                        <div key={ci} className="bc-item">
                            <label htmlFor={`bc-calvin${ci}`}>
                                {c.name}
                                <input type="checkbox" 
                                    id={`bc-calvin${ci}`} 
                                    value={c.id} 
                                    name="brand"
                                    defaultChecked={!!fBrands[c.id]}
                                    onChange={e=>changeBrand(e,c.id)} />
                                <span className="checkmark"></span>
                            </label>
                        </div>
                    ) ) }
                </div>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">價格</h4>
                <div className="filter-range-wrap">
                    <div className="range-slider">
                        <div className="price-input">
                            <input type="text" id="minamount" readOnly/>
                            <input type="text" id="maxamount" readOnly/>
                        </div>
                    </div>
                    <div className="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                        data-min={minPrice} data-max={maxPrice}>
                        <div className="ui-slider-range ui-corner-all ui-widget-header"></div>
                        <span tabIndex="0" className="ui-slider-handle ui-corner-all ui-state-default"></span>
                        <span tabIndex="0" className="ui-slider-handle ui-corner-all ui-state-default"></span>
                    </div>
                </div>
                <a onClick={e=>doFilter()} className="filter-btn" style={{cursor:"pointer"}}>過濾</a>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">顏色</h4>
                <div className="fw-color-choose">
                    { tagTypes.filter(t=>t.type=='COLOR').flatMap(t=>t.tags).map( (t,ti) => (
                        <div key={ti} className="cs-item">
                            <input type="radio" id={`cs-${t.code}`} value={`COLOR::${t.code}`}/>
                            <label className="cs-custom" htmlFor={`cs-${t.code}`} style={{'--cs-color-bg':t.value}}>{t.name}</label>
                        </div>
                    )) }
                    <div style={{clear:'both'}}></div>
                </div>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">尺吋</h4>
                <div className="fw-size-choose">
                    { tagTypes.filter(t=>t.type=='SIZE').flatMap(t=>t.tags).map( (t,ti) => (
                        <div key={ti} className="sc-item">
                            <input type="radio" id={`${t.code}-size`} name="size" value={`SIZE::${t.code}`}/>
                            <label htmlFor={`${t.code}-size`}>{t.name}</label>
                        </div>
                    ))}
                </div>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">標籤</h4>
                <div className="fw-tag-choose">
                    { tagTypes.filter(t=>t.type=='TAG').flatMap(t=>t.tags).map( (t,ti) => (
                        <div key={ti} className="sc-item">
                            <input type="radio" id={`${t.code}-tag`} name="tag" value={`TAG::${t.code}`} />
                            <label htmlFor={`${t.code}-tag`}>{t.name}</label>
                        </div>
                    )) }
                </div>
            </div>
        </div>
    );


}