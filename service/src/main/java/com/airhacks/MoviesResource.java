package com.airhacks;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MoviesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "matrix";
    }

}
