package idv.maxy.maxec.app.backend.apiclient;

import org.springframework.cloud.openfeign.FeignClient;

import idv.maxy.maxec.biz.shopping.restapi.ShoppingRestApi;

@FeignClient(name="shopping", url="${app.api.shopping.endpoint}")
public interface ShoppingApiClient extends ShoppingRestApi {

}
