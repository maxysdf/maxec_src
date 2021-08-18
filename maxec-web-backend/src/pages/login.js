import { useRouter } from "next/dist/client/router";
import { useEffect, useRef, useState } from "react";

import LoginLayout from "../components/layout_login";
import Login from "../components/login";

export default function LoginPage() {
    const username = useRef();
    const router = useRouter();
    const [loaded,setLoaded] = useState(false);

    const submit = evt => {
        evt.preventDefault();
        console.log(username.current.value);
        username.current.value = 'yes';
        router.replace('/product/list');
    };

    useEffect(() => {
        document.getElementById('__next').classList.add('login');
        setLoaded(true);
    }, []);

    if(!loaded) { return <p>loading...</p> }

    return (
        <Login></Login>
    );

/*
        <form autoComplete="off" >
            <div>
                <label htmlFor="username">username:</label> 
                <input id="username" type="text" ref={username} /> <br />
                
                <label htmlFor="password">password:</label> 
                <input id="password" type="password" /> <br />
            </div>
            <input type="submit" value="submit" onClick={submit} />
        </form>
*/

}

LoginPage.getLayout = function getLayout(page) {
    console.log(page);

    return <LoginLayout><LoginPage /></LoginLayout>;
}
