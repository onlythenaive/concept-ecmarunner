package com.onlythenaive.concept.ecmarunner.integration.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactoryProvider;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.DependencyType;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfigurationBuilder;

public abstract class GenericSandboxExecutionTest {

    protected SandboxConfiguration configuration;
    protected SandboxFactory factory;
    protected Invoice invoice;
    protected Result result;
    protected Sandbox sandbox;

    protected void assertLogEmpty() {
        assertLogSize(0);
    }

    protected void assertLogSize(final int size) {
        Assert.assertEquals(size, result.getLogRecords().size());
    }

    protected void assertTermination(final TerminationType type) {
        Assert.assertEquals(type, this.result.getTerminationType());
    }

    protected void assertTerminationException() {
        assertTermination(TerminationType.EXCEPTION);
    }

    protected void assertTerminationSuccess() {
        assertTermination(TerminationType.SUCCESS);
    }

    protected void assertTerminationTimeout() {
        assertTermination(TerminationType.TIMEOUT);
    }

    protected void assertValue(final Object value) {
        Assert.assertEquals(value, this.result.getValue());
    }

    protected void assertValueLike(final String pattern) {
        final String value = this.result.getValueAsString();
        Assert.assertTrue(value, Pattern.matches(pattern, value));
    }

    protected void assertValueNotNull() {
        Assert.assertNotNull(this.result.getValue());
    }

    protected void assertValueSize(final int size) {
        Assert.assertEquals(size, this.result.getValueAsList().size());
    }

    protected void assertValueType(final ResultValueType type) {
        Assert.assertEquals(type, this.result.getValueType());
    }

    protected List<Dependency> dependencies(final DependencyType type, final String... resources) {
        final List<Dependency> dependencies = new ArrayList<>();
        for (final String resource : resources) {
            dependencies.add(new Dependency(resource, type));
        }
        return dependencies;
    }

    protected void executeScript(final String script) {
        executeScript(script, false);
    }

    protected void executeScript(final String script, final boolean restricted) {
        executeScript(script, restricted, 0);
    }

    protected void executeScript(final String script, final boolean restricted, final long timeout) {
        this.invoice = this.sandbox.invoiceBuilder()
                .restricted(restricted)
                .script(script)
                .timeoutEnabled(timeout > 0)
                .timeoutInMilliseconds(timeout)
                .build();
        this.result = this.sandbox.execute(this.invoice);
        Assert.assertEquals(this.invoice, this.result.getInvoice());
    }

    protected void sandbox() {
        sandbox(Collections.emptyList());
    }

    protected void sandbox(final List<Dependency> dependencies) {
        final SandboxConfigurationBuilder builder = SandboxFactoryProvider.configurationBuilder();
        for (final Dependency dependency : dependencies) {
            builder.dependency(dependency);
        }
        this.configuration = builder.build();
        this.factory = SandboxFactoryProvider.factory(this.configuration);
        this.sandbox = this.factory.create();
    }
}