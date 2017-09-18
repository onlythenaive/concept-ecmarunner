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
public class ExceptionHandlingTest extends GenericSandboxExecutionTest {

    @Before
    public void prepare() {
        resetSandbox();
    }

    @Test
    public void handleScriptException() {
        execute("var test = 'not a function'; test()");
        assertLogEmpty();
        assertTerminationException();
        assertValue(null);
        assertValueType(ResultValueType.UNDEFINED);
    }
}
