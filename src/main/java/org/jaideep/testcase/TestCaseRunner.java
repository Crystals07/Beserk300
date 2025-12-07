package org.jaideep.testcase;

import org.jaideep.TestCase;
import org.jaideep.beserk300.CoinChangeProblem;

import java.util.*;

public class TestCaseRunner {

    private final Map<Integer, TestCase> testMap = new HashMap<>();
    private final Map<Integer, Object[]> inputMap = new HashMap<>();

    public TestCaseRunner() {
        // Register tests
        testMap.put(1, new CoinChangeProblem());
        //testMap.put(2, new SquareTest());

        // Provide inputs
        Object[] input1 = new Object[] {
                new int[]{1,2,3}, //coins
                6  //target
        };
        inputMap.put(1, input1); // Input for Coin change
    }

    public void run(int testCaseNumber) {
        TestCase test = testMap.get(testCaseNumber);

        if (test == null) {
            System.out.println("Invalid test case number!");
            return;
        }

        Object[] input = inputMap.get(testCaseNumber);
        System.out.println(test.runTest(input));
    }
}
