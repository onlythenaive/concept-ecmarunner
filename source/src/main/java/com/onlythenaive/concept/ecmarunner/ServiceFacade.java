package com.onlythenaive.concept.ecmarunner;

import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceBuilderImpl;

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
     * @see ExecutionInvoiceBuilder
     */
    public static ExecutionInvoiceBuilder invoiceBuilder() {
        return new ExecutionInvoiceBuilderImpl();
    }

    /**
     * Creates a new execution invoice parser.
     *
     * @return new invoice parser.
     *
     * @see ExecutionInvoiceParser
     */
    public static ExecutionInvoiceParser invoiceParser() {
        // TODO: implement parser creation
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a new execution sandbox factory.
     *
     * @return new sandbox factory.
     *
     * @see ExecutionSandboxFactory
     */
    public static ExecutionSandboxFactory sandboxFactory() {
        // TODO: implement factory creation
        throw new UnsupportedOperationException();
    }

    private ServiceFacade() {

    }
}
