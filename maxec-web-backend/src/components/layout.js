import Footer from "./footer";
import Menu from "./menu";
import NavBar from "./nav";

import styles from "../styles/Layout.module.css"

export default function Layout({children}) {
    return (
        <div className={styles.wrapper}>
            <Menu></Menu>
            <div className={styles['main-panel']}>
                <NavBar></NavBar>
                <div className={styles.content}>
                    <div className={styles['container-fluid']}>
                        {children}
                    </div>
                </div>
                <Footer></Footer>
            </div>

            { /* }
            <NavBar></NavBar>
            <main>
                <div className="container">
                    <div className="row">
                        <div className="col-md-2">
                            <Menu></Menu>
                        </div>
                        <div className="col-md-10">
                            {children}
                        </div>
                    </div>
                </div>
            </main>
            <Footer></Footer>
            { */ }
        
        </div>


 
    )
}