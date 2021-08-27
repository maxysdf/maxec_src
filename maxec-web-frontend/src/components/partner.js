import Image from "next/image"

export default function Partner() {
    return (
    <div className="partner-logo">
        <div className="container">
            <div className="logo-carousel owl-carousel">
                <div className="logo-item">
                    <div className="tablecell-inner">
                        <Image src="/images/logo-carousel/logo-1.png" width={159} height={38} alt=""/>
                    </div>
                </div>
                <div className="logo-item">
                    <div className="tablecell-inner">
                        <Image src="/images/logo-carousel/logo-2.png" width={135} height={35} alt=""/>
                    </div>
                </div>
                <div className="logo-item">
                    <div className="tablecell-inner">
                        <Image src="/images/logo-carousel/logo-3.png" width={155} height={30} alt=""/>
                    </div>
                </div>
                <div className="logo-item">
                    <div className="tablecell-inner">
                        <Image src="/images/logo-carousel/logo-4.png" width={146} height={38} alt=""/>
                    </div>
                </div>
                <div className="logo-item">
                    <div className="tablecell-inner">
                        <Image src="/images/logo-carousel/logo-5.png" width={137} height={44} alt=""/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    );
}