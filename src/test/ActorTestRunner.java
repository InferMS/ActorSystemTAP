package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ActorTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ActorTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("TEST ACTORS OK? " + result.wasSuccessful());
    }
}