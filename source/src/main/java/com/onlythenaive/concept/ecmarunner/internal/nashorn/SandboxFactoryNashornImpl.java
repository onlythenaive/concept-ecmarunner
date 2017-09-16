package com.onlythenaive.concept.ecmarunner.internal.nashorn;

import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class SandboxFactoryNashornImpl implements SandboxFactory {

    @Override
    public Sandbox create() {
        return new SandboxNashornImpl();
    }
}
