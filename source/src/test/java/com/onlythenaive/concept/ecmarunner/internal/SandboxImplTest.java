package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.facade.ServiceFacade;

public class SandboxImplTest {

    private static Invoice INVOICE;

    @BeforeClass
    public static void initPreconditions() {
        INVOICE = ServiceFacade.invoiceBuilder().script("").build();
    }

    private Sandbox sandbox;

    @Test
    public void createNewSandboxImpl() {
        this.sandbox = new SandboxImpl();
        Result result = this.sandbox.execute(INVOICE);
        Assert.assertEquals(TerminationType.SUCCESS,result.getTerminationType());
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        this.sandbox = new SandboxImpl();
        this.sandbox.execute(null);
    }
}
