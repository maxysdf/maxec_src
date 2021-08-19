import { useRouter } from "next/dist/client/router";
import { useEffect, useState } from "react"

import styles from "../styles/Common.module.css"

export default function DashboardPage() {
    const router = useRouter();
    const [mounted,setMounted] = useState(false);
    const [pageNo,setPageNo] = useState(0);
    useEffect(() => {
        setMounted(true);
    }, []);

    const trcls = (cls) => cls.split(' ').map(m=>styles[m]).join(' ');

    return (
        <div className={trcls('row')}>
            <div className={trcls('col-md-12')}>
                <div className={trcls('card strpied-tabled-with-hover')}>
                    <div className={trcls('card-header ')}>
                        <h4 className={trcls('card-title')}>Dashboard</h4>
                        {/* <p className={trcls('card-category')}>Here is a subtitle for this table</p> */}
                    </div>
                    <div className="card-footer text-muted">
                        
                    </div>
                    
                </div>

            </div>
        </div>
    )
}