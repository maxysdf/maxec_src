package idv.maxy.maxec.biz.search.conf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import idv.maxy.maxec.core.util.StringUtil;

@Configuration
public class ESConfiguration extends AbstractElasticsearchConfiguration {
	
	@Value("${app.es.hosts}")
	private String[] eshosts;
	
	@Override
	public RestHighLevelClient elasticsearchClient() {
		HttpHost[] hosts = Arrays.stream(eshosts).map(h -> {
			String[] harr = StringUtil.parseArray(h, ":");
			if(harr == null || harr.length < 2) { return null; }
			String host = harr[0];
			Integer port = StringUtil.parseInt(harr[1]);
			if(host == null || port == null) { return null; }
			return new HttpHost(host, port);
		}).filter(hh -> hh != null).toArray(HttpHost[]::new);
		
		
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(hosts));

		return client;
	}
}
