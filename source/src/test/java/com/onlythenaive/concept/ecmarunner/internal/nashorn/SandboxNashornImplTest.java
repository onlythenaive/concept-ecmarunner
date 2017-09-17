package com.onlythenaive.concept.ecmarunner.internal.nashorn;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;

public class SandboxNashornImplTest {

    private static Invoice INVOICE;

    @BeforeClass
    public static void initPreconditions() {
        INVOICE = new InvoiceBuilder().script("").build();
    }

    private Sandbox sandbox;

    @Test
    public void createNewSandboxImpl() {
        this.sandbox = new SandboxNashornImpl();
        Result result = this.sandbox.execute(INVOICE);
        Assert.assertEquals(TerminationType.SUCCESS,result.getTerminationType());
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        this.sandbox = new SandboxNashornImpl();
        this.sandbox.execute(null);
    }
}
