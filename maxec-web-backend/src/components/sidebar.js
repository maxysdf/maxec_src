import Image from "next/image"
import Link from "next/link"

export default function SideBar() {
    return ( 
        <aside className="main-sidebar sidebar-dark-primary elevation-4">

        <a href="index3.html" className="brand-link">
          <Image src="/images/logo.png" width={33} height={33} alt="MaxEC LOGO" className="brand-image img-circle elevation-3 alpha80" />
          <span className="brand-text font-weight-light ml-3 position-absolute" >Max EC</span>
        </a>
    
        <div className="sidebar">
            {/* user panel */}
            <div className="user-panel mt-3 pb-3 mb-3 d-flex">
                <div className="image">
                    <Image src="/images/maxchen.jpg" className="img-circle elevation-2" alt="User Image" width={33} height={33} />
                </div>
                <div className="info">
                <a href="#" className="d-block">Max Chen</a>
                </div>
            </div>

            {/* search */}
            <div className="form-inline">
                <div className="input-group" data-widget="sidebar-search">
                    <input className="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search" />
                    <div className="input-group-append">
                        <button className="btn btn-sidebar">
                            <i className="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            {/* menu */}
            <nav className="mt-2">
                <ul className="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li className="nav-item">
                        <Link href="/dashboard">
                            <a className="nav-link">
                                <i className="nav-icon fas fa-tachometer-alt"></i><p>儀表板</p>
                            </a>
                        </Link>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link">
                            <i className="nav-icon fas fa-edit"></i><p>商品管理<i className="fas fa-angle-left right"></i></p>
                        </a>
                        <ul className="nav nav-treeview">
                            <li className="nav-item">
                                <Link href="/product/product_list">
                                    <a className="nav-link"><i className="fas fa-angle-right nav-icon"></i><p>商品管理</p></a>
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link href="/product/tag_list">
                                    <a className="nav-link"><i className="far fa-circle nav-icon"></i><p>標籤管理</p></a>
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link href="/product/category_list">
                                    <a className="nav-link"><i className="far fa-circle nav-icon"></i><p>分類管理</p></a>
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link href="/product/brand_list">
                                    <a className="nav-link"><i className="far fa-circle nav-icon"></i><p>品牌管理</p></a>
                                </Link>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
      </aside>
    );
}