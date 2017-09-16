package com.onlythenaive.concept.ecmarunner;

import org.junit.Assert;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.facade.ServiceFacade;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceBuilderImpl;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceParserImpl;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionSandboxFactoryImpl;

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

    @Test()
    public void createNewSandboxFactory() {
        ExecutionSandboxFactory factory = ServiceFacade.sandboxFactory();
        Assert.assertTrue(factory instanceof ExecutionSandboxFactoryImpl);
    }
}
