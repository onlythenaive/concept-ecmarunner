package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.InvoiceParser;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceParserJsonImpl;

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
     * @return new JSON invoice parser.
     */
    public static InvoiceParser jsonParser() {
        return new InvoiceParserJsonImpl();
    }

    private InvoiceParserFacade() {

    }
}
