import ProductSidebar from "../../components/product/sidebar";
import Head from "next/head"
import ProductList from "../../components/product/list";
import { useEffect, useState } from "react";
import Footer from "../../components/footer";
import Partner from "../../components/partner"
import Breadcrumb from "../../components/breadcrumb"

import { GraphQLClient, request, gql } from "graphql-request"

export default function CategoryPage(props) {
    const [filterData,setFilterData] = useState({cat:props.cat});

    const filter = (data) => {
        setFilterData({...data, cat:props.cat});
    };

    useEffect(() => {
        window.scrollTo(
            {top: $('.productListZone').offset().top,
            behavior: "smooth" }
        );
    }, [filterData]);

    return (
        <>
        <Head>
            <title>列表頁</title>
            <script type="text/javascript" async src="/js/jquery.min.js"></script>
            <script type="text/javascript" async src="/js/jquery-ui.min.js"></script>
            <script type="text/javascript" async src="/js/jquery.nice-select.min.js"></script>
        </Head>
        <Breadcrumb list={[
            {label:'首頁', path:'/', hasLink: true, icon: 'HOME' },
            {label:`列表頁`, path: `/${props.cat}`, hasLink: false}
        ]} />

        {/* photo shop */}
        <section className="product-shop spad">
            <div className="container">
                <div className="row">
                    <ProductSidebar 
                        categories={props.categories}
                        brands={props.brands}
                        tagTypes={props.tagTypes}
                        onFilter={filter}>
                    </ProductSidebar>
                    <ProductList
                        filterData={filterData}>
                    </ProductList>
                </div>
            </div>
        </section>
        
        {/* partner */}
        <Partner />
        
        {/* footer */}
        <Footer></Footer>
        </>
    );
}

export async function getServerSideProps(context) {
    const cat = context.params?.cat;

    const client = new GraphQLClient(
        `http://${process.env.APP_SERVER}:${process.env.APP_PORT}/graphql`
    );

    const query = gql`{
        listBrands { brands { id name }}
        listCategories { categories { id name }}
        listTagGroupByTypes(types:["COLOR","SIZE","TAG"]) {
            tagGroups { type tags { type id code name value } }
        }
    }`;

    const { listBrands, listCategories, listTagGroupByTypes } = await client.request(query);
    const { categories } = listCategories;
    const { brands } = listBrands;

    //const tagTypes = [];
    const { tagGroups:tagTypes } = listTagGroupByTypes;

    return {props: { cat:cat, categories:categories, brands:brands, tagTypes:tagTypes }};
}