import Link from "next/link"

export default function Breadcrumb({list=[]}) {
    if(!list.length) {
        return <></>
    }
    return (
        <div className="breacrumb-section">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="breadcrumb-text">
                             { list.map((l,li) => {
                                 const cls = l.icon == 'HOME' ? 'fa fa-home' : ''
                                 return l.hasLink ? 
                                     <Link key={li} href={l.path}><a><i className={cls}></i> {l.label}</a></Link> :
                                     <span key={li}>{l.label}</span>
                             } ) }
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}


// import Link from "next/link"

// export default function Breadcrumb({list}) {
//     return (
//         <div className="breacrumb-section">
//             <div className="container">
//                 <div className="row">
//                     <div className="col-lg-12">
//                         <div className="breadcrumb-text">
//                             { list.map((l,li) => {
//                                 const cls = l.icon == 'HOME' ? 'fa fa-home' : ''
//                                 return l.hasLink ? 
//                                     <Link key={li} href={l.path}><a><i className={cls}></i> {l.label}</a></Link> :
//                                     <span key={li}>{l.label}</span>
//                             } ) }
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     );
// }