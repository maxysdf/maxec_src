import Link from "next/link";
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";

export default function ProductSidebar({categories, brands, colors}) {
    const minPrice = 0;
    const maxPrice = 5000;
    const [fBrands,setFBrands] = useState({});
    const [fMinPrice,setFMinPrice] = useState(0);
    const [fMaxPrice,setFMaxPrice] = useState(5000);

    const changeBrand = (e,id) => {
        const checked = e.target.checked;
        if( checked) fBrands[id]=true;
        if(!checked) delete fBrands[id];
        setFBrands(fBrands);
    };

    const doFilter = () => {
        alert(fMinPrice);
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
            }
        });
        minamount.val('$' + rangeSlider.slider("values", 0));
        maxamount.val('$' + rangeSlider.slider("values", 1));

        /*-------------------
            Radio Btn
        --------------------- */
        $(".fw-size-choose .sc-item label, .pd-size-choose .sc-item label").on('click', function () {
            $(".fw-size-choose .sc-item label, .pd-size-choose .sc-item label").removeClass('active');
            $(this).addClass('active');
        });

        $(".fw-tag-choose .sc-item label, .pd-tag-choose .sc-item label").on('click', function () {
            //$(".fw-tag-choose .sc-item label, .pd-tag-choose .sc-item label").removeClass('active');
            $(this).toggleClass('active');
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
                    <div className="cs-item">
                        <input type="radio" id="cs-black"/>
                        <label className="cs-black" htmlFor="cs-black">Black</label>
                    </div>
                    <div className="cs-item">
                        <input type="radio" id="cs-violet"/>
                        <label className="cs-violet" htmlFor="cs-violet">Violet</label>
                    </div>
                    <div className="cs-item">
                        <input type="radio" id="cs-blue"/>
                        <label className="cs-blue" htmlFor="cs-blue">Blue</label>
                    </div>
                    <div className="cs-item">
                        <input type="radio" id="cs-yellow"/>
                        <label className="cs-yellow" htmlFor="cs-yellow">Yellow</label>
                    </div>
                    <div className="cs-item">
                        <input type="radio" id="cs-red"/>
                        <label className="cs-red" htmlFor="cs-red">Red</label>
                    </div>
                    <div className="cs-item">
                        <input type="radio" id="cs-green"/>
                        <label className="cs-green" htmlFor="cs-green">Green</label>
                    </div>
                </div>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">尺吋</h4>
                <div className="fw-size-choose">
                    <div className="sc-item">
                        <input type="radio" id="s-size" name="size"/>
                        <label htmlFor="s-size">s</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="m-size" name="size"/>
                        <label htmlFor="m-size">m</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="l-size" name="size"/>
                        <label htmlFor="l-size">l</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="xs-size" name="size"/>
                        <label htmlFor="xs-size">xs</label>
                    </div>
                </div>
            </div>
            <div className="filter-widget">
                <h4 className="fw-title">標籤</h4>
                <div className="fw-tag-choose">
                    <div className="sc-item">
                        <input type="radio" id="s-size" name="size"/>
                        <label htmlFor="s-size">s</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="m-size" name="size"/>
                        <label htmlFor="m-size">m</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="l-size" name="size"/>
                        <label htmlFor="l-size">l</label>
                    </div>
                    <div className="sc-item">
                        <input type="radio" id="xs-size" name="size"/>
                        <label htmlFor="xs-size">xs</label>
                    </div>
                </div>
            </div>
        </div>
    );


}