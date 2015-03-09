package com.airhacks;

import com.airhacks.porcupine.execution.entity.Rejection;
import javax.enterprise.event.Observes;

/**
 *
 * @author airhacks.com
 */
public class RejectionTaskHandler {

    public void onOverload(@Observes Rejection rejection) {
        System.out.println("rejection = " + rejection);
    }

}
