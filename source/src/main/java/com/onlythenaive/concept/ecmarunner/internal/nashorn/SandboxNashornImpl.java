package com.onlythenaive.concept.ecmarunner.internal.nashorn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.LogRecord;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxInspector;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class SandboxNashornImpl implements Sandbox {

    private final ScriptEngine engine;

    public SandboxNashornImpl() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    @Override
    public List<LogRecord> drain() {
        // TODO: return a real console output
        return new ArrayList<>();
    }

    @Override
    public Result execute(final Invoice invoice) {
        Objects.requireNonNull(invoice, "Execution invoice cannot be null");
        try {
            engine.eval(invoice.getScript());
        } catch (ScriptException exception) {
            throw new RuntimeException("Script exception occurred", exception);
        }

        // TODO: implement invoice execution
        return new Result(
                invoice,
                Collections.emptyList(),
                TerminationType.SUCCESS,
                null,
                ResultValueType.NULL
        );
    }

    @Override
    public <T> T inspect(SandboxInspector<T> inspector) {
        Objects.requireNonNull(inspector, "Sandbox inspector cannot be null");
        return inspector.apply(engine);
    }
}
