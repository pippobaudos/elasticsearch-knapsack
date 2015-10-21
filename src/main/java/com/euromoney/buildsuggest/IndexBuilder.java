package com.euromoney.buildsuggest;

import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by niccolo.becchi on 20/10/2015.
 */
public class IndexBuilder {

    public static void main(String[] args) throws UnknownHostException {

        String CLUSTER_NAME = "EU01-ES-DEV-01";
        String HOST = "eu01-es-dev-01.global.root";
        //String CLUSTER_NAME = "europluto_elio";
        //String HOST = "127.0.0.1";

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", CLUSTER_NAME).build();
        TransportClient client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), 9300));

        CountResponse response = client.prepareCount("test")
                .setQuery(termQuery("_type", "type1"))
                .execute()
                .actionGet();

        System.out.println(response);

        client.close();
    }


}
