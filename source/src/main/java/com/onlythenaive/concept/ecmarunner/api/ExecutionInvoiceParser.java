package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Execution invoice JSON parser API.
 *
 * @see ExecutionInvoiceBuilder
 *
 * @author Ilia Gubarev
 */
public interface ExecutionInvoiceParser {

    /**
     * Converts a JSON input to a list of execution invoices.
     *
     * @param invoiceJson a JSON input.
     * @return a list of execution invoices.
     */
    List<ExecutionInvoice> parse(String invoiceJson);
}
