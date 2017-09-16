package com.onlythenaive.concept.ecmarunner.internal;

import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoiceParser;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ExecutionInvoiceParserImpl implements ExecutionInvoiceParser {

    @Override
    public List<ExecutionInvoice> parse(final String invoiceJson) {
        if (invoiceJson == null) {
            throw new NullPointerException("Invoice JSON cannot be null");
        }
        // TODO: implement invoice parsing
        throw new UnsupportedOperationException();
    }
}
