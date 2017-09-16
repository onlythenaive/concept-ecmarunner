package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.api.InvoiceParser;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceBuilderImpl;
import com.onlythenaive.concept.ecmarunner.internal.invoice.InvoiceParserJsonImpl;
import com.onlythenaive.concept.ecmarunner.internal.SandboxFactoryImpl;

/**
 * Service provider.
 *
 * Acts as a facade for accessing API implementations.
 *
 * @author Ilia Gubarev
 */
public final class ServiceFacade {

    /**
     * Creates a new execution invoice builder.
     *
     * @return new invoice builder.
     *
     * @see InvoiceBuilder
     */
    public static InvoiceBuilder invoiceBuilder() {
        return new InvoiceBuilderImpl();
    }

    /**
     * Creates a new execution invoice parser.
     *
     * @return new invoice parser.
     *
     * @see InvoiceParser
     */
    public static InvoiceParser invoiceParser() {
        return new InvoiceParserJsonImpl();
    }

    /**
     * Creates a new execution sandbox factory.
     *
     * @return new sandbox factory.
     *
     * @see SandboxFactory
     */
    public static SandboxFactory sandboxFactory() {
        return new SandboxFactoryImpl();
    }

    private ServiceFacade() {

    }
}
