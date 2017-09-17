package com.onlythenaive.concept.ecmarunner.internal.builder;

import org.junit.Assert;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;

public class InvoiceBuilderImplTest {

    @Test
    public void createNewInvoice() {
        InvoiceBuilder builder = new InvoiceBuilderImpl();
        builder.script("some script");
        Invoice invoice = builder.build();
        Assert.assertEquals("", invoice.getDescription());
        Assert.assertTrue(invoice.isRestricted());
        Assert.assertTrue(invoice.getScript().equals("some script"));
        Assert.assertTrue(invoice.isTimeoutEnabled());
        Assert.assertEquals(10 * 1000, invoice.getTimeoutInMilliseconds());
        Assert.assertEquals("1.0", invoice.getVersion());
    }
}
