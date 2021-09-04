package idv.maxy.maxec.app.backend.apiclient;

import org.springframework.cloud.openfeign.FeignClient;

import idv.maxy.maxec.biz.content.restapi.ContentRestAPI;

@FeignClient(name="content", url="${app.api.content.endpoint}")
public interface ContentApiClient extends ContentRestAPI {

}
