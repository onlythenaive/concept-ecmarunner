package com.onlythenaive.concept.ecmarunner.api;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceBuilderTest {

    @Test
    public void createNewInvoice() {
        InvoiceBuilder builder = new InvoiceBuilder();
        builder.script("some script");
        Invoice invoice = builder.build();
        Assert.assertEquals("", invoice.getDescription());
        Assert.assertTrue(invoice.isRestricted());
        Assert.assertTrue(invoice.getScript().equals("some script"));
        Assert.assertTrue(invoice.isTimeoutEnabled());
        Assert.assertEquals(5 * 1000, invoice.getTimeoutInMilliseconds());
        Assert.assertEquals("1.0", invoice.getVersion());
    }
}
