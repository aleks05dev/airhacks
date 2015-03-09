package com.airhacks;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientProperties;

/**
 *
 * @author airhacks.com
 */
public class MovieConnector {

    private Client client;

    @PostConstruct
    public void init() {
        this.client = ClientBuilder.newClient();
        client.property(ClientProperties.CONNECT_TIMEOUT, 100);
        client.property(ClientProperties.READ_TIMEOUT, 1000);

    }

    @Produces
    public WebTarget expose() {
        return this.client.target("http://localhost:8080/service/resources/movies");
    }

}
