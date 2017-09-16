package com.onlythenaive.concept.ecmarunner.internal.nashorn;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;

public class SandboxFactoryNashornImplTest {

    private static SandboxFactory FACTORY;

    @BeforeClass
    public static void initPreconditions() {
        FACTORY = new SandboxFactoryNashornImpl();
    }

    @Test
    public void createNewSandboxImpl() {
        FACTORY.create();
    }
}
