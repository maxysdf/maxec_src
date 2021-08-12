import { useRouter } from "next/dist/client/router";
import { useRef, useState } from "react";

export default function Login() {
    const username = useRef();
    const router = useRouter();

    const submit = evt => {
        evt.preventDefault();
        console.log(username.current.value);
        username.current.value = 'yes';
        router.replace('/product/list');
    };

    return (
        <form autoComplete="off" >
            <div>
                <label htmlFor="username">username:</label> 
                <input id="username" type="text" ref={username} /> <br />
                
                <label htmlFor="password">password:</label> 
                <input id="password" type="password" /> <br />
            </div>
            <input type="submit" value="submit" onClick={submit} />
        </form>
        
    );
}
