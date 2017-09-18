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
public class ResultHandlingTest extends GenericSandboxExecutionTest {

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
