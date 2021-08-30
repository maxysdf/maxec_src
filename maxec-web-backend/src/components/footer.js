import styles from "./footer.module.css"

export default function Footer() {

    const trcls = (cls) => cls.split(' ').map(m=>styles[m]).join(' ');

    return (
        <footer className={trcls('footer')}>
            <div className={trcls('container-fluid')}>
                <nav>
                    <ul className={trcls('footer-menu')}>
                        <li>
                            <a href="#">Home</a>
                        </li>
                        <li>
                            <a href="#">Company</a>
                        </li>
                        <li>
                            <a href="#">Portfolio</a>
                        </li>
                        <li>
                            <a href="#">Blog</a>
                        </li>
                    </ul>
                    <p className={trcls('copyright text-center')}>
                        ©2021
                        <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </nav>
            </div>
        </footer>
    );
}