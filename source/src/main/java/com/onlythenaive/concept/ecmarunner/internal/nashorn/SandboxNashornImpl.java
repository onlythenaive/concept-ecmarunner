package com.onlythenaive.concept.ecmarunner.internal.nashorn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
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
    public List<String> console() {
        // TODO: return a real console output
        return new ArrayList<>();
    }

    @Override
    public Result execute(final Invoice invoice) {
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        try {
            engine.eval(invoice.getScript());
        } catch (ScriptException exception) {
            throw new RuntimeException("Script exception occurred", exception);
        }

        // TODO: implement invoice execution
        return new Result(
                Arrays.asList("output 1", "output 2"),
                invoice,
                TerminationType.SUCCESS,
                null,
                ResultValueType.NULL
        );
    }

    @Override
    public <T> T inspect(SandboxInspector<T> inspector) {
        return inspector.apply(engine);
    }
}
