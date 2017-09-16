package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionResultValueType;
import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionSandboxInspector;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ExecutionSandboxImpl implements ExecutionSandbox {

    private final ScriptEngine engine;

    public ExecutionSandboxImpl() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    @Override
    public List<String> console() {
        // TODO: return a real console output
        return new ArrayList<>();
    }

    @Override
    public ExecutionResult execute(final ExecutionInvoice invoice) {
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        try {
            engine.eval(invoice.getScript());
        } catch (ScriptException exception) {
            throw new RuntimeException("Script exception occurred", exception);
        }

        // TODO: implement invoice execution
        return new ExecutionResultImpl(
                Arrays.asList("output 1", "output 2"),
                invoice,
                ExecutionTerminationType.SUCCESS,
                null,
                ExecutionResultValueType.NULL
        );
    }

    @Override
    public <T> T inspect(ExecutionSandboxInspector<T> inspector) {
        return inspector.apply(engine);
    }
}
