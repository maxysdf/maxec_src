package idv.maxy.maxec.app.api.apiclient;

import org.springframework.cloud.openfeign.FeignClient;

import idv.maxy.maxec.biz.customer.restapi.CustomerRestApi;

@FeignClient(name="customer", url="${app.api.customer.endpoint}")
public interface CustomerApiClient extends CustomerRestApi {

}
