package com.onlythenaive.concept.ecmarunner;

import java.util.List;

import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.DependencyType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class DependencyResolutionTest extends GenericIntegrationTest {

    @Test
    public void resolveAndUseJqueryViaCdn() {
        final String cdnJquery = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js";
        final List<Dependency> dependencies = dependencies(DependencyType.CDN, cdnJquery);
        resetSandbox(dependencies);
        execute("$('body')");
        assertLogEmpty();
        assertTerminationSuccess();
        assertValueNotNull();
        assertValueType(ResultValueType.OBJECT);
    }
}
