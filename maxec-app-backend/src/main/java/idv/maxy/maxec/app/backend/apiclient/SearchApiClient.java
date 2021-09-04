package idv.maxy.maxec.app.backend.apiclient;

import org.springframework.cloud.openfeign.FeignClient;

import idv.maxy.maxec.biz.search.restapi.SearchRestAPI;

@FeignClient(name="search", url="${app.api.search.endpoint}")
public interface SearchApiClient extends SearchRestAPI {

}
