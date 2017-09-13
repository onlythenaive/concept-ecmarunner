package com.onlythenaive.concept.ecmarunner.internal;

import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;
import com.onlythenaive.concept.ecmarunner.internal.ExecutionSandboxImpl;

@InternalImplementation
public final class ExecutionSandboxFactoryImpl implements ExecutionSandboxFactory {

    @Override
    public ExecutionSandbox create(final ExecutionSandboxConfiguration configuration) {
        if (configuration == null) {
            throw new NullPointerException("Execution sandbox configuration cannot be null");
        }
        return new ExecutionSandboxImpl(configuration, this);
    }
}
