package com.onlythenaive.concept.ecmarunner.integration;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.DependencyType;
import com.onlythenaive.concept.ecmarunner.convention.Integration;
import com.onlythenaive.concept.ecmarunner.integration.generic.GenericSandboxExecutionTest;

@Integration
@RunWith(JUnit4.class)
public class DependencyResolutionTest extends GenericSandboxExecutionTest {

    @Test
    public void resolveAndUseJqueryViaCdn() {
        final String cdnJquery = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js";
        final List<Dependency> dependencies = dependencies(DependencyType.CDN, cdnJquery);
        sandbox(dependencies);
        executeScript("$('body')");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.OBJECT);
    }
}
