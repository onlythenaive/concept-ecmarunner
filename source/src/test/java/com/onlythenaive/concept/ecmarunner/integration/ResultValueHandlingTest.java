package com.onlythenaive.concept.ecmarunner.integration;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactoryProvider;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.convention.Integration;

@Integration
@RunWith(JUnit4.class)
public class ResultValueHandlingTest {

    private static SandboxFactory FACTORY;

    private Result result;
    private Sandbox sandbox;

    @BeforeClass
    public static void prepareFactory() {
        final SandboxConfiguration config = SandboxFactoryProvider.configurationBuilder().build();
        FACTORY = SandboxFactoryProvider.factory(config);
    }

    @Before
    public void prepareSandbox() {
        this.sandbox = FACTORY.create();
    }

    @Test
    public void handleArray() {
        runSimpleScript("var result = [1, 2, 3]; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueSize(3);
        assertValueType(ResultValueType.ARRAY);
    }

    @Test
    public void handleBoolean() {
        runSimpleScript("var result = 1 > 2; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(false);
        assertValueType(ResultValueType.BOOLEAN);
    }

    @Test
    public void handleFunction() {
        runSimpleScript("var result = function () {}; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueLike("function \\(\\) \\{.*\\}");
        assertValueType(ResultValueType.FUNCTION);
    }

    @Test
    public void handleNumber() {
        runSimpleScript("var result = 1 + 2 * 5; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(11.0);
        assertValueType(ResultValueType.NUMBER);
    }

    @Test
    public void handleNull() {
        runSimpleScript("var result = null; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(null);
        assertValueType(ResultValueType.NULL);
    }

    @Test
    public void handleObject() {
        runSimpleScript("var result = {a: 1, b: 2}; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.OBJECT);
    }

    @Test
    public void handleString() {
        runSimpleScript("var result = ['Hello', 'World!'].join(' '); result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue("Hello World!");
        assertValueType(ResultValueType.STRING);
    }

    @Test
    public void handleUndefined() {
        runSimpleScript("var result; result");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValue(null);
        assertValueType(ResultValueType.UNDEFINED);
    }

    private void assertLogEmpty() {
        Assert.assertTrue(result.getLogRecords().isEmpty());
    }

    private void assertTerminationSuccess() {
        Assert.assertEquals(TerminationType.SUCCESS, this.result.getTerminationType());
    }

    private void assertValue(final Object value) {
        Assert.assertEquals(value, this.result.getValue());
    }

    private void assertValueLike(final String pattern) {
        final String value = this.result.getValueAsString();
        Assert.assertTrue(value, Pattern.matches(pattern, value));
    }

    private void assertValueSize(final int size) {
        Assert.assertEquals(size, this.result.getValueAsList().size());
    }

    private void assertValueNotNull() {
        Assert.assertNotNull(this.result.getValue());
    }

    private void assertValueType(final ResultValueType type) {
        Assert.assertEquals(type, this.result.getValueType());
    }

    private void runSimpleScript(final String script) {
        final Invoice invoice = this.sandbox.invoiceBuilder().script(script).build();
        this.result = this.sandbox.execute(invoice);
        Assert.assertEquals(invoice, this.result.getInvoice());
    }
}
