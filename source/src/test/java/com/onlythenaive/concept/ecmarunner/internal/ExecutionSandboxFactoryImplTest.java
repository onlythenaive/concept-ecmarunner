package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;

public class ExecutionSandboxFactoryImplTest {

    private static ExecutionSandboxFactory FACTORY;

    @BeforeClass
    public static void initPreconditions() {
        FACTORY = new ExecutionSandboxFactoryImpl();
    }

    @Test
    public void createNewSandboxImpl() {
        FACTORY.create();
    }
}
