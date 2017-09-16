package com.onlythenaive.concept.ecmarunner.internal;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.facade.InvoiceBuilderFacade;

public class ResultImplTest {

    private List<String> console;
    private Invoice invoice;
    private TerminationType terminationType;
    private Object value;
    private ResultValueType valueType;

    @Before
    public void beforeClass() {
        console = Arrays.asList("", "", "");
        invoice = InvoiceBuilderFacade.builder().script("").build();
        terminationType = TerminationType.SUCCESS;
        value = null;
        valueType = ResultValueType.NULL;
    }

    @Test
    public void createNewResult() {
        new ResultImpl(
                console,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullConsole() {
        new ResultImpl(
                null,
                invoice,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        new ResultImpl(
                console,
                null,
                terminationType,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullTerminationType() {
        new ResultImpl(
                console,
                invoice,
                null,
                value,
                valueType
        );
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullValueType() {
        new ResultImpl(
                console,
                invoice,
                terminationType,
                value,
                null
        );
    }
}
