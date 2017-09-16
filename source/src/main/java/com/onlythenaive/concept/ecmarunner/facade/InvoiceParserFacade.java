package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.InvoiceParser;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceParserJsonImpl;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceParserPlainImpl;

/**
 * Implementation facade for invoice parsers.
 *
 * @see InvoiceParser
 *
 * @author Ilia Gubarev
 */
@ImplementationFacade
public final class InvoiceParserFacade {

    /**
     * Creates a new JSON-based invoice parser.
     *
     * @return new invoice parser.
     */
    public static InvoiceParser jsonParser() {
        return new InvoiceParserJsonImpl();
    }

    /**
     * Creates a new plain text-based invoice parser.
     *
     * @return new invoice parser.
     */
    public static InvoiceParser plainParser() {
        return new InvoiceParserPlainImpl();
    }

    private InvoiceParserFacade() {

    }
}
