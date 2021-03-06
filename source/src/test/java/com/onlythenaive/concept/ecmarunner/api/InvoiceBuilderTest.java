package com.onlythenaive.concept.ecmarunner.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.onlythenaive.concept.ecmarunner.convention.UnitTest;

@UnitTest(InvoiceBuilder.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest({Invoice.class, InvoiceBuilder.class})
public class InvoiceBuilderTest {

    @Test
    public void createNewInvoiceWithoutException() throws Exception {

        final Invoice invoiceMock = PowerMockito.mock(Invoice.class);
        final InvoiceBuilder tested = new InvoiceBuilder();

        PowerMockito
                .whenNew(Invoice.class)
                .withAnyArguments()
                .thenReturn(invoiceMock);

        tested.script("1 + 2");
        final Invoice invoice = tested.build();

        PowerMockito
                .verifyNew(Invoice.class)
                .withArguments("", false, "1 + 2", false, 1000L, "1.0");

        Assert.assertEquals(invoice, invoice);
    }
}
