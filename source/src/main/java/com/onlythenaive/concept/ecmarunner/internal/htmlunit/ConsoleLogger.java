package com.onlythenaive.concept.ecmarunner.internal.htmlunit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ConsoleLogger implements Logger {

    private final Set<Consumer<String>> consumers = new HashSet<>();
    private final List<String> outputs = new ArrayList<>();

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(final Object message) {
        log(message);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(final Object message) {
        log(message);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(final Object message) {
        log(message);
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(final Object message) {
        log(message);
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(final Object message) {
        log(message);
    }

    public List<String> getOutputs() {
        return new ArrayList<>(this.outputs);
    }

    public void register(final Consumer<String> consumer) {
        this.consumers.add(consumer);
    }

    public void unregister(final Consumer<String> consumer) {
        this.consumers.remove(consumer);
    }

    private void log(final Object message) {
        final String output = message.toString();
        this.outputs.add(output);
        consume(output);
    }

    private void consume(final String output) {
        for (final Consumer<String> consumer : this.consumers) {
            consumer.accept(output);
        }
    }
}
