package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.Assert;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionInvoiceBuilder;

public class ExecutionInvoiceBuilderImplTest {

    @Test
    public void createNewInvoice() {
        ExecutionInvoiceBuilder builder = new ExecutionInvoiceBuilderImpl();
        builder.addScript("some script");
        ExecutionInvoice invoice = builder.build();
        Assert.assertEquals("", invoice.getDescription());
        Assert.assertTrue(invoice.isRestricted());
        Assert.assertTrue(invoice.getScripts().contains("some script"));
        Assert.assertEquals(1, invoice.getScripts().size());
        Assert.assertTrue(invoice.isTimeoutEnabled());
        Assert.assertEquals(10 * 1000, invoice.getTimeoutInMilliseconds());
        Assert.assertEquals("1.0", invoice.getVersion());
    }
}
