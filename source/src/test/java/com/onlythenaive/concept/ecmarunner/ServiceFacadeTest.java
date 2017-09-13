package com.onlythenaive.concept.ecmarunner;

import org.junit.Test;

public class ServiceFacadeTest {

    @Test(expected = UnsupportedOperationException.class)
    public void createNewInvoiceBuilder() {
        ServiceFacade.invoiceBuilder();
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
