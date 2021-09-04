import Link from "next/link"

import LayoutSimple from "../components/layout_simple";

export default function RegisterPage() {
    const cont = (
        <>
        <div className="register-login-section spad">
            <div className="container">
                <div className="row">
                    <div className="col-lg-6 offset-lg-3">
                        <div className="register-form">
                            <h2>註冊帳號</h2>
                            <form action="#">
                                <div className="group-input">
                                    <label htmlFor="username">使用者名稱 *</label>
                                    <input type="text" id="username"/>
                                </div>
                                <div className="group-input">
                                    <label htmlFor="email">Email *</label>
                                    <input type="text" id="email"/>
                                </div>
                                <div className="group-input">
                                    <label htmlFor="pass">密碼 *</label>
                                    <input type="text" id="pass"/>
                                </div>
                                <div className="group-input">
                                    <label htmlFor="con-pass">再次確認密碼 *</label>
                                    <input type="text" id="con-pass"/>
                                </div>
                                <button type="submit" className="site-btn register-btn">註冊</button>
                            </form>
                            <div className="switch-login">
                                <Link href="/login"><a className="or-login">登入</a></Link>
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