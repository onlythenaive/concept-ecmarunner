package com.onlythenaive.concept.ecmarunner.api;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResultTest {

    private List<String> console;
    private Invoice invoice;
    private TerminationType terminationType;
    private Object value;
    private ResultValueType valueType;

    @Before
    public void beforeClass() {
        console = Arrays.asList("", "", "");
        invoice = new InvoiceBuilder().script("").build();
        terminationType = TerminationType.SUCCESS;
        value = null;
        valueType = ResultValueType.NULL;
    }

    @Test
    public void createNewResult() {
        new Result(
                console,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullConsole() {
        new Result(
                null,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        new Result(
                console,
                null,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullTerminationType() {
        new Result(
                console,
                invoice,
                null,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullValueType() {
        new Result(
                console,
                invoice,
                terminationType,
                value,
                null
        );
    }
}
