package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.facade.ServiceFacade;

public class ExecutionSandboxImplTest {

    private static ExecutionInvoice INVOICE;

    @BeforeClass
    public static void initPreconditions() {
        INVOICE = ServiceFacade.invoiceBuilder().script("").build();
    }

    private ExecutionSandbox sandbox;

    @Test
    public void createNewSandboxImpl() {
        this.sandbox = new ExecutionSandboxImpl();
        ExecutionResult result = this.sandbox.execute(INVOICE);
        Assert.assertEquals(ExecutionTerminationType.SUCCESS,result.getTerminationType());
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        this.sandbox = new ExecutionSandboxImpl();
        this.sandbox.execute(null);
    }
}
