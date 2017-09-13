package com.onlythenaive.concept.ecmarunner.internal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxFactory;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.ServiceFacade;

public class ExecutionSandboxImplTest {

    private static ExecutionSandboxConfiguration CONFIGURATION;
    private static ExecutionSandboxFactory FACTORY;
    private static ExecutionInvoice INVOICE;

    @BeforeClass
    public static void initPreconditions() {
        CONFIGURATION = new ExecutionSandboxConfigurationImpl();
        FACTORY = new ExecutionSandboxFactory() {
            public ExecutionSandbox create(ExecutionSandboxConfiguration configuration) {
                return null;
            }
        };
        INVOICE = ServiceFacade.invoiceBuilder().script("").build();
    }

    private ExecutionSandbox sandbox;

    @Test
    public void createNewSandboxImpl() {
        this.sandbox = new ExecutionSandboxImpl(CONFIGURATION, FACTORY);
        ExecutionResult result = this.sandbox.execute(INVOICE);
        Assert.assertEquals(ExecutionTerminationType.SUCCESS,result.getTerminationType());
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullConfiguration() {
        this.sandbox = new ExecutionSandboxImpl(null, FACTORY);
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullFactory() {
        this.sandbox = new ExecutionSandboxImpl(CONFIGURATION, null);
    }

    @Test(expected = NullPointerException.class)
    public void failOnNullInvoice() {
        this.sandbox = new ExecutionSandboxImpl(CONFIGURATION, FACTORY);
        this.sandbox.execute(null);
    }
}
