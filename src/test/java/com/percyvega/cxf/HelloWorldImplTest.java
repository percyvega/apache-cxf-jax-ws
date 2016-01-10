
package com.percyvega.cxf;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldImplTest {

    @Test
	public void testSayHi() {
        HelloWorldImpl helloWorldImpl = new HelloWorldImpl();            	
        String response = helloWorldImpl.sayHi("Sam");

        System.out.println(response);

        assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam", response);
    }
}
