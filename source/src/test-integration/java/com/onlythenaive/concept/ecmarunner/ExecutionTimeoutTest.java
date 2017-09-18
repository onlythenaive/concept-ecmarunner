package com.onlythenaive.concept.ecmarunner;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class ExecutionTimeoutTest extends GenericIntegrationTest {

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
