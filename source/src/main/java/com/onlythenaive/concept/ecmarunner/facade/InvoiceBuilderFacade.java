package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceBuilderImpl;

/**
 * Implementation facade for invoice builders.
 *
 * @see InvoiceBuilder
 *
 * @author Ilia Gubarev
 */
@ImplementationFacade
public final class InvoiceBuilderFacade {

    /**
     * Creates a new invoice builder.
     *
     * @return new invoice builder.
     */
    public static InvoiceBuilder builder() {
        return new InvoiceBuilderImpl();
    }

    private InvoiceBuilderFacade() {

    }
}
