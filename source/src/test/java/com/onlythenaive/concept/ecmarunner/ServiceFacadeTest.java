package com.onlythenaive.concept.ecmarunner;

import org.junit.Assert;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceBuilderImpl;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceParserImpl;

public class ServiceFacadeTest {

    @Test()
    public void createNewInvoiceBuilder() {
        ExecutionInvoiceBuilder builder = ServiceFacade.invoiceBuilder();
        Assert.assertTrue(builder instanceof ExecutionInvoiceBuilderImpl);
    }

    @Test()
    public void createNewInvoiceParser() {
        ExecutionInvoiceParser parser = ServiceFacade.invoiceParser();
        Assert.assertTrue(parser instanceof ExecutionInvoiceParserImpl);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createNewSandboxFactory() {
        ServiceFacade.sandboxFactory();
    }
}
