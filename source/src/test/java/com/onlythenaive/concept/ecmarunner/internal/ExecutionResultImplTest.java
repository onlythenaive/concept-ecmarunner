package com.onlythenaive.concept.ecmarunner.internal;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;

public class ExecutionResultImplTest {

    private ExecutionInvoice invoice;
    private List<String> outputs;
    private ExecutionTerminationType terminationType;

    @BeforeClass
    public void beforeClass() {
        invoice = null;
        outputs = Arrays.asList("", "", "");
        terminationType = ExecutionTerminationType.SUCCESS;
    }

    @Test
    public void createNewResult() {
        new ExecutionResultImpl(
                invoice,
                outputs,
                terminationType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        new ExecutionResultImpl(
                null,
                outputs,
                terminationType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullOutputs() {
        new ExecutionResultImpl(
                invoice,
                null,
                terminationType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullType() {
        new ExecutionResultImpl(
                invoice,
                outputs,
                null
        );
    }
}
