package com.phonet.project.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by yuri on 05.09.17.
 */
@Component
@ApplicationPath("/project")
public class JerseyConfig extends ResourceConfig {

    private static final String GLOBAL_PACKAGE = "com.phonet.project";

    public JerseyConfig() {
        packages(GLOBAL_PACKAGE + ".resource",
                GLOBAL_PACKAGE + ".exception.handling");
    }
}
