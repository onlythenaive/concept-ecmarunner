package com.onlythenaive.concept.ecmarunner.internal.invoice;

import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceParserPlainImplTest {

    private static InvoiceParserPlainImpl PARSER;

    @BeforeClass
    public static void init() {
        PARSER = new InvoiceParserPlainImpl();
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullText() {
        PARSER.parse(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void failOnInvalidText() {
        PARSER.parse("version:");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void parseValidText() {
        PARSER.parse("version: 1.0");
    }
}
