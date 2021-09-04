import Script from "next/script"
import Link from "next/link"
import Image from "next/image"

export default function IndexCategoryBanner() {
    return (
        <>
        <div className="banner-section spad">
            <div className="container-fluid">
                <div className="row">
                    <div className="col-lg-4">
                        <div className="single-banner">
                            <Image src="/images/banner-1.jpg" width={357} height={200} alt=""/>
                            <div className="inner-text">
                                <h4>Men’s</h4>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <div className="single-banner">
                            <Image src="/images/banner-2.jpg" width={357} height={200} alt=""/>
                            <div className="inner-text">
                                <h4>Women’s</h4>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4">
                        <div className="single-banner">
                            <Image src="/images/banner-3.jpg" width={357} height={200} alt=""/>
                            <div className="inner-text">
                                <h4>Kid’s</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
}