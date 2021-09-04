import Script from "next/script"
import Link from "next/link"
import Image from "next/image"

export default function IndexIG() {
    return (
        <>
        <div className="instagram-photo">
            <div className="insta-item set-bg" data-setbg="/images/insta-1.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
            <div className="insta-item set-bg" data-setbg="/images/insta-2.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
            <div className="insta-item set-bg" data-setbg="/images/insta-3.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
            <div className="insta-item set-bg" data-setbg="/images/insta-4.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
            <div className="insta-item set-bg" data-setbg="/images/insta-5.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
            <div className="insta-item set-bg" data-setbg="/images/insta-6.jpg">
                <div className="inside-text">
                    <i className="ti-instagram"></i>
                    <h5><a href="#">colorlib_Collection</a></h5>
                </div>
            </div>
        </div>
        </>
    );
}