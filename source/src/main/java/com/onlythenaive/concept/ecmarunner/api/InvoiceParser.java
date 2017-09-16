package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Execution invoice parser API.
 *
 * @see InvoiceBuilder
 *
 * @author Ilia Gubarev
 */
public interface InvoiceParser {

    /**
     * Converts a text input to a list of execution invoices.
     *
     * @param invoiceString a text invoice representation.
     * @return a list of execution invoices.
     */
    List<Invoice> parse(String invoiceString);
}
