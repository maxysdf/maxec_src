

export default function Pager({page, onPage = f=>f}) {
    return (
        <>
        {page &&
            <ul className="pagination pagination-sm float-right ml-3">
                { page.number > 0 && <li className="page-item"><a className="page-link" onClick={e=>onPage(page.number-1)}>«</a></li> }
                { [... Array(page.totalPages)].map( (_,i) => {
                    return (page.number == i) ?
                        <li key={i} className="page-item"><a className="page-link font-weight-bold" >{i+1}</a></li> :
                        <li key={i} className="page-item"><a className="page-link" href="#" onClick={e=>onPage(i)}>{i+1}</a></li>
                } ) }
                { page.number < page.totalPages-1 && <li className="page-item"><a className="page-link" href="#" onClick={e=>onPage(page.number+1)}>»</a></li> }
            </ul>
        }
        </>
    );
}