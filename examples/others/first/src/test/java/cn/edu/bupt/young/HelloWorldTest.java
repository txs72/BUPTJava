package cn.edu.bupt.young;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest{
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("Hello Maven", result);
    }
}

