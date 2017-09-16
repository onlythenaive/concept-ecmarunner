package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;

public class SandboxFactoryImplTest {

    private static SandboxFactory FACTORY;

    @BeforeClass
    public static void initPreconditions() {
        FACTORY = new SandboxFactoryImpl();
    }

    @Test
    public void createNewSandboxImpl() {
        FACTORY.create();
    }
}
