package com.airhacks;

import com.airhacks.porcupine.configuration.control.ExecutorConfigurator;
import com.airhacks.porcupine.execution.control.ExecutorConfiguration;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author airhacks.com
 */
@Specializes
public class CustomExecutorConfiguration extends ExecutorConfigurator {

    @Override
    public ExecutorConfiguration forPipeline(String name) {
        if ("moviesThreadPool".equals(name)) {
            return new ExecutorConfiguration.Builder().corePoolSize(1).maxPoolSize(1).queueCapacity(5).build();
        }
        return super.forPipeline(name);
    }

}
