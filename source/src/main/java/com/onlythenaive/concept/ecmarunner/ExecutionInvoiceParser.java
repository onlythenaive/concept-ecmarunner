package com.onlythenaive.concept.ecmarunner;

import java.util.List;

/**
 * Execution invoice JSON parser API.
 *
 * @see ExecutionInvoiceBuilder
 * @see ServiceFacade
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
