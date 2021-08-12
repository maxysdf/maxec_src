import Footer from "./footer";
import Menu from "./menu";
import NavBar from "./nav";


export default function Layout({children}) {
    return (
        <>
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
        </>
    )
}