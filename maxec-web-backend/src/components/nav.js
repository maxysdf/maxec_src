import { useRouter } from "next/dist/client/router";
import styles from "./nav.module.css"


export default function NavBar() {
    const trcls = (cls) => cls.split(' ').map(m=>styles[m]).join(' ');
    const router = useRouter();

    const logoutClick = e => {
        router.replace('/login');
    };
    
    return (
        <nav className={trcls('navbar navbar-expand-lg')} color-on-scroll="500">
        <div className={trcls('container-fluid')}>
            <a className={trcls('navbar-brand')} href="#pablo"> Dashboard </a>
            <button href="" className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span className={trcls('navbar-toggler-bar burger-lines')}></span>
                <span className={trcls('navbar-toggler-bar burger-lines')}></span>
                <span className={trcls('navbar-toggler-bar burger-lines')}></span>
            </button>
            <div className={ trcls('collapse navbar-collapse justify-content-end')} id="navigation">
                <ul className={trcls('nav navbar-nav mr-auto')}>
                    <li className={trcls('nav-item')}>
                        <a href="#" className={trcls('nav-link')} data-toggle="dropdown">
                            <i className={trcls('nc-icon nc-palette')}></i>
                            <span className={trcls('d-lg-none')}>Dashboard</span>
                        </a>
                    </li>
                    <li className={trcls('dropdown nav-item')}>
                        <a href="#" className={trcls('dropdown-toggle nav-link')} data-toggle="dropdown">
                            <i className={trcls('nc-icon nc-planet')}></i>
                            <span className={trcls('notification')}>5</span>
                            <span className={trcls('d-lg-none')}>Notification</span>
                        </a>
                        <ul className={trcls('dropdown-menu')}>
                            <a className={trcls('dropdown-item')} href="#">Notification 1</a>
                            <a className={trcls('dropdown-item')} href="#">Notification 2</a>
                            <a className={trcls('dropdown-item')} href="#">Notification 3</a>
                            <a className={trcls('dropdown-item')} href="#">Notification 4</a>
                            <a className={trcls('dropdown-item')} href="#">Another notification</a>
                        </ul>
                    </li>
                    <li className={trcls('nav-item')}>
                        <a href="#" className={trcls('nav-link')}>
                            <i className={trcls('nc-icon nc-zoom-split')}></i>
                            <span className={trcls('d-lg-block')}>&nbsp;Search</span>
                        </a>
                    </li>
                </ul>
                <ul className={trcls('navbar-nav ml-auto')}>
                    <li className={trcls('nav-item')}>
                        <a className={trcls('nav-link')} href="#pablo">
                            <span className={trcls('no-icon')}>Account</span>
                        </a>
                    </li>
                    <li className={trcls('nav-item dropdown')}>
                        <a className={trcls('nav-link dropdown-toggle')} href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span className={trcls('no-icon')}>Dropdown</span>
                        </a>
                        <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a className={trcls('dropdown-item')} href="#">Action</a>
                            <a className={trcls('dropdown-item')} href="#">Another action</a>
                            <a className={trcls('dropdown-item')} href="#">Something</a>
                            <a className={trcls('dropdown-item')} href="#">Something else here</a>
                            <div className={trcls('divider')}></div>
                            <a className={trcls('dropdown-item')} href="#">Separated link</a>
                        </div>
                    </li>
                    <li className={trcls('nav-item')}>
                        <a className={trcls('nav-link')} onClick={logoutClick}>
                            <span className={trcls('no-icon')}>Log out</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    );
}