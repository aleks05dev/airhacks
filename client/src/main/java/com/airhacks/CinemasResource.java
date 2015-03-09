package com.airhacks;

import javax.ejb.Stateless;
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

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.resume("bios 2! " + target.request().get(String.class));
    }

}
