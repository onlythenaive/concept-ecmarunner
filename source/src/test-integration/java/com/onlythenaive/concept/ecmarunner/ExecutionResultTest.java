package com.onlythenaive.concept.ecmarunner;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class ExecutionResultTest extends GenericIntegrationTest {

    @Before
    public void prepareSandbox() {
        resetSandbox();
    }

    @Test
    public void handleArray() {
        execute("var result = [1, 2, 3]; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueSize(3);
        assertValueType(ResultValueType.ARRAY);
    }

    @Test
    public void handleBoolean() {
        execute("var result = 1 > 2; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(false);
        assertValueType(ResultValueType.BOOLEAN);
    }

    @Test
    public void handleFunction() {
        execute("var result = function () {}; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueLike("function \\(\\) \\{.*\\}");
        assertValueType(ResultValueType.FUNCTION);
    }

    @Test
    public void handleNumber() {
        execute("var result = 1 + 2 * 5; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(11.0);
        assertValueType(ResultValueType.NUMBER);
    }

    @Test
    public void handleNull() {
        execute("var result = null; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(null);
        assertValueType(ResultValueType.NULL);
    }

    @Test
    public void handleObject() {
        execute("var result = {a: 1, b: 2}; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.OBJECT);
    }

    @Test
    public void handleString() {
        execute("var result = ['Hello', 'World!'].join(' '); result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue("Hello World!");
        assertValueType(ResultValueType.STRING);
    }

    @Test
    public void handleUndefined() {
        execute("var result; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(null);
        assertValueType(ResultValueType.UNDEFINED);
    }
}
