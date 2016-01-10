
package com.percyvega.cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "com.percyvega.cxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

