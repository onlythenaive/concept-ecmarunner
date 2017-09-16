package com.onlythenaive.concept.ecmarunner.internal;

import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;


@InternalImplementation
public final class SandboxFactoryImpl implements SandboxFactory {

    @Override
    public Sandbox create() {
        return new SandboxImpl();
    }
}
