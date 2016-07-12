package com.casumo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * Video store
 *
 */
public class App extends Application<VideoStoreConfiguration> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<VideoStoreConfiguration> b) {}

    @Override
    public void run(VideoStoreConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");
    }
}
