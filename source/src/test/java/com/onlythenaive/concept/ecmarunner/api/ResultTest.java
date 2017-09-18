package com.onlythenaive.concept.ecmarunner.api;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResultTest {

    private Invoice invoice;
    private List<LogRecord> logRecords;
    private TerminationType terminationType;
    private Object value;
    private ResultValueType valueType;

    @Before
    public void beforeClass() {
        invoice = new InvoiceBuilder().script("").build();
        logRecords = Collections.emptyList();
        terminationType = TerminationType.SUCCESS;
        value = null;
        valueType = ResultValueType.NULL;
    }

    @Test
    public void createNewResult() {
        new Result(
                invoice,
                logRecords,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        new Result(
                null,
                logRecords,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullRecords() {
        new Result(
                invoice,
                null,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullTerminationType() {
        new Result(
                invoice,
                logRecords,
                null,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullValueType() {
        new Result(
                invoice,
                logRecords,
                terminationType,
                value,
                null
        );
    }
}
