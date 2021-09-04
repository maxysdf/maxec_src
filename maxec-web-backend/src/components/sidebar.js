import Image from "next/image"
import Link from "next/link"
import { useState } from "react";

export default function SideBar() {
    const menuData = { type:'root', items: [
        { label: '儀表板', iconClass:"fas fa-tachometer-alt", type: 'item', link:"/dashboard" },
        { label: '商品資料管理', iconClass:"fas fa-cubes", type: 'menu', iconClass:"fas fa-cubes", items: [
            { label: '商品管理', iconClass:"fas fa-cubes", type: 'item', link:"/product/product_list" },
            { label: '標籤管理', iconClass:"fas fa-tags", type: 'item', link:"/product/tag_list" },
            { label: '分類管理', iconClass:"fas fa-clone", type: 'item', link:"/product/category_list" },
            { label: '品牌管理', iconClass:"fas fa-copyright", type: 'item', link:"/product/brand_list" }
        ] }
    ]};

    return ( 
        <aside className="main-sidebar sidebar-dark-primary elevation-4">

        <Link href="/dashboard">
            <a className="brand-link">
                <Image src="/images/logo.png" width={33} height={33} alt="MaxEC LOGO" className="brand-image img-circle elevation-3" />
                <span className="brand-text font-weight-light ml-3 position-absolute" >Max EC</span>
            </a>
        </Link>
    
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
                    <SideBarMenu tree={menuData} />
                </ul>
            </nav>
        </div>
      </aside>
    );
}


function SideBarMenu({tree,lv=0}) {

    const renderChildren = items => items.map( (ti,tii) => (
        <SideBarMenu key={tii} tree={ti} lv={lv+1} />
    ));

    const padClass = 
        lv == 1 ? 'ml-3' :
        lv == 2 ? 'ml-6' : '';
        

    return (
        <>
            {tree.type == 'menu' && 
                <li className="nav-item">
                    <a className="nav-link">
                        <i className={`nav-icon ${tree.iconClass}`}></i><p>{tree.label}<i className="fas fa-angle-left right"></i></p>
                    </a>
                    <ul className={`nav nav-treeview ${padClass}`}>{ renderChildren(tree.items) }</ul>
                </li>
            }

            {tree.type == 'item' && 
                <li className="nav-item">
                    <Link href={tree.link}>
                        <a className="nav-link">
                            <i className={`nav-icon ${tree.iconClass}`}></i><p>{tree.label}</p>
                        </a>
                    </Link>
                </li>
            }

            {tree.type == 'root' && renderChildren(tree.items) }
        </>
    );
} 