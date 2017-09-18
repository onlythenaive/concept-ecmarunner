package com.onlythenaive.concept.ecmarunner.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.convention.Integration;
import com.onlythenaive.concept.ecmarunner.integration.generic.GenericSandboxExecutionTest;

@Integration
@RunWith(JUnit4.class)
public class DependencyResolutionTest extends GenericSandboxExecutionTest {

    private final String cdnJquery = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js";

    @Test
    public void resolveAndUseJqueryViaCdn() {
        sandboxWithCdnDependencies(this.cdnJquery);
        executeScript("$");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.FUNCTION);
        executeScript("$('body')");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.OBJECT);
    }
}
