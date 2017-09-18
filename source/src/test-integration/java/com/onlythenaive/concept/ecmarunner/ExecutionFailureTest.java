package com.onlythenaive.concept.ecmarunner;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class ExecutionFailureTest extends GenericIntegrationTest {

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
