package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import org.swistowski.agata.jokelibrary.JokeTeller;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi bas, " + name);

        return response;
    }

    @ApiMethod(name = "tellJoke", httpMethod= ApiMethod.HttpMethod.GET)
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        JokeTeller jokeTeller = new JokeTeller();
        response.setData(jokeTeller.tellMeAJoke());

        return response;
    }
}
