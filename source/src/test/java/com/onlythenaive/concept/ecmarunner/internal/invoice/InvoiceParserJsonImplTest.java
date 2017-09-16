package com.onlythenaive.concept.ecmarunner.internal.invoice;

import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceParserJsonImplTest {

    private static InvoiceParserJsonImpl PARSER;

    @BeforeClass
    public static void init() {
        PARSER = new InvoiceParserJsonImpl();
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullJson() {
        PARSER.parse(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void failOnInvalidJson() {
        PARSER.parse("{property}");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void parseValidJson() {
        PARSER.parse("{}");
    }
}