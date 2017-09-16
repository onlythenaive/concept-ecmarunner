package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.Test;

public class InvoiceImplTest {

    private static String description = "";
    private static boolean restricted = false;
    private static String script = "1";
    private static boolean timeoutEnabled = false;
    private static int timeoutInMilliseconds = 0;
    private static String version = "1.0";

    @Test
    public void createNewInvoice() {
        new InvoiceImpl(
                description,
                restricted,
                script,
                timeoutEnabled,
                timeoutInMilliseconds,
                version);
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullScripts() {
        new InvoiceImpl(
                description,
                restricted,
                null,
                timeoutEnabled,
                timeoutInMilliseconds,
                version);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failOnNegativeTimeout() {
        new InvoiceImpl(
                description,
                restricted,
                script,
                timeoutEnabled,
                -1,
                version);
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullVersion() {
        new InvoiceImpl(
                description,
                restricted,
                script,
                timeoutEnabled,
                timeoutInMilliseconds,
                null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failOnEmptyVersion() {
        new InvoiceImpl(
                description,
                restricted,
                script,
                timeoutEnabled,
                timeoutInMilliseconds,
                "");
    }
}
