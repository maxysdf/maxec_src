import Breadcrumb  from "../components/breadcrumb"
import Partner from "../components/partner";
import Footer from "../components/footer";
import Link from "next/link";
import Head from "next/head";

import LayoutSimple from "../components/layout_simple";

export default function LoginPage() {
   
    const cont = (
        <>
        <div className="register-login-section spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-6 offset-lg-3">
                        <div className="login-form">
                            <h2>登入</h2>
                            <form action="#">
                                <div className="group-input">
                                    <label htmlFor="username">使用者名稱或Email *</label>
                                    <input type="text" id="username" />
                                </div>
                                <div className="group-input">
                                    <label htmlFor="pass">密碼 *</label>
                                    <input type="text" id="pass"/>
                                </div>
                                <div className="group-input gi-check">
                                    <div className="gi-more">
                                        <label htmlFor="save-pass">
                                            記得我
                                            <input type="checkbox" id="save-pass"/>
                                            <span className="checkmark"></span>
                                        </label>
                                        <a href="#" className="forget-pass">忘記密碼</a>
                                    </div>
                                </div>
                                <button type="submit" className="site-btn login-btn">登入</button>
                            </form>
                            <div className="switch-login">
                                <Link href="/register"><a className="or-login">建立帳號</a></Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
    
    return (
        <LayoutSimple components={cont}></LayoutSimple>
    );    
}