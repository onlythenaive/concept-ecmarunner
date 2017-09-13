package com.onlythenaive.concept.ecmarunner.internal;

import java.util.Arrays;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;

@InternalImplementation
public final class ExecutionSandboxImpl implements ExecutionSandbox {

    private final ExecutionSandboxConfiguration configuration;
    private final ExecutionSandboxFactory factory;

    public ExecutionSandboxImpl(final ExecutionSandboxConfiguration configuration,
                                final ExecutionSandboxFactory factory) {
        if (configuration == null) {
            throw new NullPointerException("Sandbox configuration cannot be null");
        }
        this.configuration = configuration;
        if (factory == null) {
            throw new NullPointerException("Sandbox factory cannot be null");
        }
        this.factory = factory;
    }

    @Override
    public ExecutionSandboxConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override
    public ExecutionSandboxFactory getFactory() {
        return this.factory;
    }

    @Override
    public ExecutionResult execute(final ExecutionInvoice invoice) {
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        // TODO: implement invoice execution
        return new ExecutionResultImpl(
                invoice,
                Arrays.asList("output 1", "output 2"),
                ExecutionTerminationType.SUCCESS
        );
    }
}
