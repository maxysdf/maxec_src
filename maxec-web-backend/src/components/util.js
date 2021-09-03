import { GraphQLClient, request, gql } from "graphql-request"

const _glclient = new GraphQLClient(`/api/graphql`);

export function utGQL(q,p,cb) {
    const query = gql`${q}`;
    _glclient.request(gql`${q}`, p).then(cb);
}

export const GQL_RESP = 'response {result code errorMessage}';
export const GQL_PAGE_FLDS = 'totalPages totalElements number size numberOfElements hasContent first last hasNext hasPrevious';

export function utNumber(nStr, hasCurrSign) {
    if(nStr == null) return '';
    nStr += '';
    if(!nStr) return '';
    var srgx = /(-?)(\d+)/;
    var sgn = hasCurrSign ? '$$' : '';
    nStr = nStr.replace(srgx, '$1' + sgn + '$2');

    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(nStr)) nStr = nStr.replace(rgx, '$1' + ',' + '$2');
    return nStr;
}
