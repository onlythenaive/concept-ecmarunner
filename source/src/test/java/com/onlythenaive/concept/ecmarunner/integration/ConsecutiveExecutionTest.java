package com.onlythenaive.concept.ecmarunner.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.convention.Integration;
import com.onlythenaive.concept.ecmarunner.integration.generic.GenericSandboxExecutionTest;

@Integration
@RunWith(JUnit4.class)
public class ConsecutiveExecutionTest extends GenericSandboxExecutionTest {

    @Before
    public void prepare() {
        sandboxWithCdnDependencies();
    }

    @Test
    public void executeConsecutiveDependantInvoices() {
        executeScript("var a = 2");
        executeScript("var b = 40");
        executeScript("a + b");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(42.0);
        assertValueType(ResultValueType.NUMBER);
    }
}
