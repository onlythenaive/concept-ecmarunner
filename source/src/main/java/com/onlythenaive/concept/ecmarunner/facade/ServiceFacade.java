package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoiceParser;
import com.onlythenaive.concept.ecmarunner.api.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceBuilderImpl;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionInvoiceParserImpl;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionSandboxFactoryImpl;

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
        return new ExecutionInvoiceParserImpl();
    }

    /**
     * Creates a new execution sandbox factory.
     *
     * @return new sandbox factory.
     *
     * @see ExecutionSandboxFactory
     */
    public static ExecutionSandboxFactory sandboxFactory() {
        return new ExecutionSandboxFactoryImpl();
    }

    private ServiceFacade() {

    }
}
