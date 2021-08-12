const frontendEndpoint = process.env.FRONTEND_ENDPOINT;


async function utload(path, params) {
    var paramarr = [];
    if(params && typeof params === 'object') {
        for(const i in params) { paramarr.push(`${i}=${params[i]}`); }
    }
    const paramstr = paramarr.length == 0 ? '' : '?' + paramarr.join('&');

    const res = await fetch(`${frontendEndpoint}${path}${paramstr}`);
    const data = await res.json();
    return data;
}

export { utload };