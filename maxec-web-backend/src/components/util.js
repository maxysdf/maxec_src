import axios from "axios";
import { GraphQLClient, request, gql } from "graphql-request"

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

const _glclient = new GraphQLClient(`/api/graphql`);

export function utGQL(q,p,cb) {
    const query = gql`${q}`;
    _glclient.request(gql`${q}`, p).then(cb);
}

export function utNumber(nStr, hasCurrSign) {
    if(nStr == null) return '';
    nStr += '';
    if(!nStr) return '';
    var srgx = /(-?)(\d+)/;
    var sgn = hasCurrSign ? '$$' : '';
    nStr = nStr.replace(srgx, '$1' + sgn + '$2');

    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(nStr)) nStr = nStr.replace(rgx, '$1' + ',' + '$2');
    return nStr;
}

export const utLocalSet = (k,d) => localStorage.setItem(k,JSON.stringify(d));
export const utLocalGet = k => k && localStorage.getItem(k);
export const utSessionSet = (k,d) => sessionStorage.setItem(k,JSON.stringify(d));
export const utSessionGet = k => k && sessionStorage.getItem(k);