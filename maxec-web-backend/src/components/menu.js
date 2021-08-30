import ProductListPage from "../pages/product/list";
import styles from "./menu.module.css"

import getPathname from "../pages/product/list";
import withRouter from "next/dist/client/with-router";
import { useRouter } from "next/dist/client/router";
import Router from "next/dist/next-server/server/router";

export default function Menu() {
    const router = useRouter();

    const menuData = [
        { name: 'Dashboard', path: '/dashboard', icon: 'nc-chart-pie-35' },
        { name: '商品管理', path: '/product/list', icon: 'nc-tv-2' },
    ];

    return (
        <div className={styles.sidebar} data-color="purple" data-image="/images/sidebar-5.jpg">
        <div className={styles['sidebar-wrapper']}>
            <div className={styles.logo}>
                <a href="http://maxec.idv.tw" className={styles['simple-text']}>
                    Max EC
                </a>
            </div>
            <ul className={styles.nav}>
                { menuData.map( (md,i) => (
                    <li key={i} className={`${styles['nav-item']}`}>
                        <a className={styles['nav-link']} href="#" onClick={e=>router.push(md.path)}>
                            <i className={`${styles['nc-icon']} ${styles[md.icon]}`}></i>
                            <p>{md.name}</p>
                        </a>
                    </li>
                )) }

                { /* }
                <li className={`${styles['nav-item']}`}>
                    <a className={styles['nav-link']} href="aa.html">
                        <i className={`${styles['nc-icon']} ${styles['nc-chart-pie-35']}`}></i>
                        <p>Product</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./user.html">
                        <i class="nc-icon nc-circle-09"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./table.html">
                        <i class="nc-icon nc-notes"></i>
                        <p>Table List</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./typography.html">
                        <i class="nc-icon nc-paper-2"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./icons.html">
                        <i class="nc-icon nc-atom"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./maps.html">
                        <i class="nc-icon nc-pin-3"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="./notifications.html">
                        <i class="nc-icon nc-bell-55"></i>
                        <p>Notifications</p>
                    </a>
                </li>
                <li class="nav-item active active-pro">
                    <a class="nav-link active" href="upgrade.html">
                        <i class="nc-icon nc-alien-33"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>

                { */ }
            </ul>
        </div>

        <div className={styles['sidebar-background']} ></div>

    </div>
    );
}