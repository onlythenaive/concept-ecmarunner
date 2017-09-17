package com.onlythenaive.concept.ecmarunner.api.facade;

import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.builder.InvoiceBuilderImpl;

/**
 * Implementation facade for invoice builders.
 *
 * @see InvoiceBuilder
 *
 * @author Ilia Gubarev
 */
@PublishedApi
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
