package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by Adrian.Calancea on 7/5/16.
 */

    public class HelloWorldExtend {

        public HelloWorldExtend() {
        }

        public void extendSayHello(){
            HelloWorld helloWorld = new HelloWorld();
            helloWorld.sayHello();
            System.out.println("The new Hello World");
        }

    }


