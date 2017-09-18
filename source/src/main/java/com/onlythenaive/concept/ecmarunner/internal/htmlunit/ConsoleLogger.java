package com.onlythenaive.concept.ecmarunner.internal.htmlunit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import com.onlythenaive.concept.ecmarunner.api.LogRecord;
import com.onlythenaive.concept.ecmarunner.api.LogRecordType;
import com.onlythenaive.concept.ecmarunner.api.configuration.LogLayout;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ConsoleLogger implements Logger {

    private final Set<Consumer<LogRecord>> consumers = new HashSet<>();
    private final LogLayout logLayout;
    private final List<LogRecord> records = new ArrayList<>();

    public ConsoleLogger(final LogLayout logLayout) {
        Objects.requireNonNull(logLayout, "Log layout cannot be null");
        this.logLayout = logLayout;
    }

    @Override
    public boolean isTraceEnabled() {
        return enabledForType(LogRecordType.TRACE);
    }

    @Override
    public void trace(final Object message) {
        accept(message, LogRecordType.TRACE);
    }

    @Override
    public boolean isDebugEnabled() {
        return enabledForType(LogRecordType.DEBUG);
    }

    @Override
    public void debug(final Object message) {
        accept(message, LogRecordType.DEBUG);
    }

    @Override
    public boolean isInfoEnabled() {
        return enabledForType(LogRecordType.INFO);
    }

    @Override
    public void info(final Object message) {
        accept(message, LogRecordType.INFO);
    }

    @Override
    public boolean isWarnEnabled() {
        return enabledForType(LogRecordType.WARN);
    }

    @Override
    public void warn(final Object message) {
        accept(message, LogRecordType.WARN);
    }

    @Override
    public boolean isErrorEnabled() {
        return enabledForType(LogRecordType.ERROR);
    }

    @Override
    public void error(final Object message) {
        accept(message, LogRecordType.ERROR);
    }

    public List<LogRecord> getRecords() {
        return new ArrayList<>(this.records);
    }

    public void register(final Consumer<LogRecord> consumer) {
        requireNonNullConsumer(consumer);
        this.consumers.add(consumer);
    }

    public void unregister(final Consumer<LogRecord> consumer) {
        requireNonNullConsumer(consumer);
        this.consumers.remove(consumer);
    }

    private void accept(final Object message, final LogRecordType type) {
        if (message == null) {
            return;
        }
        final LogRecord record = new LogRecord(type, message.toString(), Instant.now());
        this.records.add(record);
        consume(record);
    }

    private void consume(final LogRecord record) {
        for (final Consumer<LogRecord> consumer : this.consumers) {
            consumer.accept(record);
        }
    }

    private boolean enabledForType(final LogRecordType type) {
        return logLayout.isEnabled() && logLayout.getLevel().greaterThan(type);
    }

    private void requireNonNullConsumer(final Consumer<LogRecord> consumer) {
        Objects.requireNonNull(consumer, "Log record consumer cannot be null");
    }
}
