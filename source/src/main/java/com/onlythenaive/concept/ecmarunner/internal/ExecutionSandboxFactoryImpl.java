package com.onlythenaive.concept.ecmarunner.internal;

import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;


@InternalImplementation
public final class ExecutionSandboxFactoryImpl implements ExecutionSandboxFactory {

    @Override
    public ExecutionSandbox create() {
        return new ExecutionSandboxImpl();
    }
}
