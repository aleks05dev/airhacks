package com.airhacks;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.WebTarget;

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
    public String all() {
        return "bios! " + target.request().get(String.class);
    }

}
