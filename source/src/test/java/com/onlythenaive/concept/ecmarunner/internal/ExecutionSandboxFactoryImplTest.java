package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;

public class ExecutionSandboxFactoryImplTest {

    private static ExecutionSandboxConfiguration CONFIGURATION;
    private static ExecutionSandboxFactory FACTORY;

    @BeforeClass
    public static void initPreconditions() {
        CONFIGURATION = new ExecutionSandboxConfigurationImpl();
        FACTORY = new ExecutionSandboxFactoryImpl();
    }

    private ExecutionSandboxFactory factory;

    @Test
    public void createNewSandboxImpl() {
        ExecutionSandbox sandbox = FACTORY.create(CONFIGURATION);
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullConfiguration() {
        ExecutionSandbox sandbox = FACTORY.create(null);
    }
}
