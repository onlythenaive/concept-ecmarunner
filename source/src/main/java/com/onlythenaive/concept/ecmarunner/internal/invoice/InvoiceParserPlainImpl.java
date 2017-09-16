package com.onlythenaive.concept.ecmarunner.internal.invoice;

import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.InvoiceParser;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class InvoiceParserPlainImpl implements InvoiceParser {

    @Override
    public List<Invoice> parse(final String invoiceString) {
        if (invoiceString == null) {
            throw new NullPointerException("Invoice string representation cannot be null");
        }
        // TODO: implement invoice parsing
        throw new UnsupportedOperationException();
    }
}
