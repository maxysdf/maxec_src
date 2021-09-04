package idv.maxy.maxec.app.backend.apiclient;

import org.springframework.cloud.openfeign.FeignClient;

import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;

@FeignClient(name="product", url="${app.api.product.endpoint}")
public interface ProductApiClient extends ProductRestAPI {

}
