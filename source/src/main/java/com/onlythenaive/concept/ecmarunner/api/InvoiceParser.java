package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Execution invoice JSON parser API.
 *
 * @see InvoiceBuilder
 *
 * @author Ilia Gubarev
 */
public interface InvoiceParser {

    /**
     * Converts a JSON input to a list of execution invoices.
     *
     * @param invoiceJson a JSON input.
     * @return a list of execution invoices.
     */
    List<Invoice> parse(String invoiceJson);
}
