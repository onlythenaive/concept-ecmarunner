package com.onlythenaive.concept.ecmarunner.internal;

import com.onlythenaive.concept.ecmarunner.api.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.api.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;


@InternalImplementation
public final class ExecutionSandboxFactoryImpl implements ExecutionSandboxFactory {

    @Override
    public ExecutionSandbox create() {
        return new ExecutionSandboxImpl();
    }
}
