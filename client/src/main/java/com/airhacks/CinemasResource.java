package com.airhacks;

import com.airhacks.porcupine.execution.boundary.Dedicated;
import com.airhacks.porcupine.execution.entity.Statistics;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("cinemas")
public class CinemasResource {

    @Inject
    WebTarget target;

    @Inject
    @Dedicated
    ExecutorService moviesThreadPool;

    @Inject
    Instance<List<Statistics>> stats;

    @GET
    public void all(@Suspended AsyncResponse response) {
        CompletableFuture.supplyAsync(this::getMovies, moviesThreadPool).
                thenAccept(response::resume).exceptionally((t) -> {
                    Response error = Response.status(500).
                    header("x-error", "Dear user, try tomorrow").
                    header("x-detail", t.toString()).
                    build();
                    response.resume(error);
                    return null;
                });
    }

    String getMovies() {
        return "bio 4" + target.request().get(String.class) + stats.get();
    }

}
