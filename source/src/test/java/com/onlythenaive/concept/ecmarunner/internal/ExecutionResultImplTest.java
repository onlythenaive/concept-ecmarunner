package com.onlythenaive.concept.ecmarunner.internal;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.api.ExecutionResultValueType;
import com.onlythenaive.concept.ecmarunner.api.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.facade.ServiceFacade;

public class ExecutionResultImplTest {

    private List<String> console;
    private ExecutionInvoice invoice;
    private ExecutionTerminationType terminationType;
    private Object value;
    private ExecutionResultValueType valueType;

    @Before
    public void beforeClass() {
        console = Arrays.asList("", "", "");
        invoice = ServiceFacade.invoiceBuilder().script("").build();
        terminationType = ExecutionTerminationType.SUCCESS;
        value = null;
        valueType = ExecutionResultValueType.NULL;
    }

    @Test
    public void createNewResult() {
        new ExecutionResultImpl(
                console,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullConsole() {
        new ExecutionResultImpl(
                null,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        new ExecutionResultImpl(
                console,
                null,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullTerminationType() {
        new ExecutionResultImpl(
                console,
                invoice,
                null,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullValueType() {
        new ExecutionResultImpl(
                console,
                invoice,
                terminationType,
                value,
                null
        );
    }
}
