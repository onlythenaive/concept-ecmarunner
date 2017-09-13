package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutionInvoiceParserImplTest {

    private static ExecutionInvoiceParserImpl PARSER;

    @BeforeClass
    public static void init() {
        PARSER = new ExecutionInvoiceParserImpl();
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
