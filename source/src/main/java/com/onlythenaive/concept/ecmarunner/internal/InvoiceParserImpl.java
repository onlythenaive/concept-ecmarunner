package com.onlythenaive.concept.ecmarunner.internal;

import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.InvoiceParser;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class InvoiceParserImpl implements InvoiceParser {

    @Override
    public List<Invoice> parse(final String invoiceJson) {
        if (invoiceJson == null) {
            throw new NullPointerException("Invoice JSON cannot be null");
        }
        // TODO: implement invoice parsing
        throw new UnsupportedOperationException();
    }
}
