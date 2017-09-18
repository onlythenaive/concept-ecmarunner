package com.onlythenaive.concept.ecmarunner;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class ConsecutiveExecutionTest extends GenericIntegrationTest {

    @Before
    public void prepare() {
        resetSandbox();
    }

    @Test
    public void executeConsecutiveDependantInvoices() {
        execute("var a = 2");
        execute("var b = 40");
        execute("a + b");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(42.0);
        assertValueType(ResultValueType.NUMBER);
    }
}
