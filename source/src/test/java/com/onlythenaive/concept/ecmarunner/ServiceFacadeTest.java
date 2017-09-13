package com.onlythenaive.concept.ecmarunner;

import org.junit.Assert;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceBuilderImpl;

public class ServiceFacadeTest {

    @Test()
    public void createNewInvoiceBuilder() {
        ExecutionInvoiceBuilder builder = ServiceFacade.invoiceBuilder();
        Assert.assertTrue(builder instanceof ExecutionInvoiceBuilderImpl);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createNewInvoiceParser() {
        ServiceFacade.invoiceParser();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createNewSandboxFactory() {
        ServiceFacade.sandboxFactory();
    }
}
