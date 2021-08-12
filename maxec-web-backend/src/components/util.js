import axios from "axios";

export async function utload(path, params) {
    var paramarr = [];
    if(params && typeof params === 'object') {
        for(const i in params) { paramarr.push(`${i}=${params[i]}`); }
    }
    const paramstr = paramarr.length == 0 ? '' : '?' + paramarr.join('&');

    const res = await axios.get(`http://${process.env.APP_SERVER}:${process.env.APP_PORT}${path}${paramstr}`);
    const { data } = res;
    //const res = await fetch(`${path}${paramstr}`);
    //const data = await res.json();
    return data;
}


export const utLocalSet = (k,d) => localStorage.setItem(k,JSON.stringify(d));
export const utLocalGet = k => k && localStorage.getItem(k);
export const utSessionSet = (k,d) => sessionStorage.setItem(k,JSON.stringify(d));
export const utSessionGet = k => k && sessionStorage.getItem(k);