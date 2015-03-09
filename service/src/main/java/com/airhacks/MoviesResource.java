package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("movies")
public class MoviesResource {

    @GET
    public String movies() {
        return "matrix";
    }

}
