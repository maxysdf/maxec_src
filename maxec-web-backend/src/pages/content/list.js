import { useRouter } from "next/dist/client/router";
import { useEffect, useState } from "react";
import { utSessionSet } from "../../components/util";


export default function ContentList() {
    const router = useRouter();

    const [data, setData] = useState('');

    const goDetail = evt => {
        setData('XXX');
        router.push('/content/detail');
    };

    useEffect(() => {
        if(!data) { return; }
        utSessionSet('PROD', data);
    }, [data]);

    return (
        <div>
            <input type="button" onClick={goDetail} value="detail" />
        </div>
    );
}