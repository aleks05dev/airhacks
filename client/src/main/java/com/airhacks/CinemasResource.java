package com.airhacks;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("cinemas")
public class CinemasResource {

    @Inject
    WebTarget target;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse response) {
        CompletableFuture.supplyAsync(this::getMovies, mes).
                thenAccept(response::resume);
    }

    String getMovies() {
        return "bio 3" + target.request().get(String.class);
    }

}
