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
public class TimeoutHandlingTest extends GenericSandboxExecutionTest {

    @Before
    public void prepare() {
        resetSandbox();
    }

    @Test
    public void handleExecutionTimeout() {
        execute("var a = []; for (var i = 0; i < 10000; i++) { a.push(i) }", false, 1);
        assertLogEmpty();
        assertTerminationTimeout();
        assertValue(null);
        assertValueType(ResultValueType.UNDEFINED);
    }
}
