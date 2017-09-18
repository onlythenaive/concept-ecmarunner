package com.onlythenaive.concept.ecmarunner.internal.htmlunit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.TimeoutError;
import net.sourceforge.htmlunit.corejs.javascript.NativeArray;
import net.sourceforge.htmlunit.corejs.javascript.NativeFunction;
import net.sourceforge.htmlunit.corejs.javascript.NativeObject;
import net.sourceforge.htmlunit.corejs.javascript.Undefined;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.LogRecord;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxInspector;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class SandboxHtmlUnitImpl implements Sandbox {

    private final WebClient client;
    private final ConsoleLogger logger;
    private final List<LogRecord> logRecords = new ArrayList<>();
    private final HtmlPage page;

    public SandboxHtmlUnitImpl(final WebClient client,
                               final ConsoleLogger logger,
                               final HtmlPage page) {
        Objects.requireNonNull(client, "Web client cannot be null");
        this.client = client;
        Objects.requireNonNull(logger, "Console logger cannot be null");
        this.logger = logger;
        Objects.requireNonNull(page, "Page cannot be null");
        this.page = page;
        this.logger.register(logRecords::add);
    }

    @Override
    public List<LogRecord> drain() {
        final List<LogRecord> result = new ArrayList<>(this.logRecords);
        this.logRecords.clear();
        return result;
    }

    @Override
    public Result execute(final Invoice invoice) {
        // TODO: refactor this method
        Objects.requireNonNull(invoice, "Execution invoice cannot be null");
        final List<LogRecord> records = new ArrayList<>();
        try (final WebClient webClient = this.client) {
            this.logger.register(records::add);
            if (invoice.isTimeoutEnabled()) {
                webClient.getJavaScriptEngine().setJavaScriptTimeout(invoice.getTimeoutInMilliseconds());
            } else {
                webClient.getJavaScriptEngine().setJavaScriptTimeout(0);
            }
            final ScriptResult scriptResult = this.page.executeJavaScript(invoice.getScript());
            final Object value = value(scriptResult);
            return new Result(invoice, new ArrayList<>(records), TerminationType.SUCCESS, value, valueType(scriptResult));
        } catch (TimeoutError e) {
            return new Result(invoice, new ArrayList<>(records), TerminationType.TIMEOUT, null, ResultValueType.UNDEFINED);
        } catch (Exception e) {
            return new Result(invoice, new ArrayList<>(records), TerminationType.EXCEPTION, null, ResultValueType.UNDEFINED);
        }
    }

    @Override
    public <T> T inspect(final SandboxInspector<T> inspector) {
        Objects.requireNonNull(inspector, "Sandbox inspector cannot be null");
        return inspector.apply(this.page, this.client, this.logger);
    }

    private Object value(final ScriptResult scriptResult) {
        final Object value = scriptResult.getJavaScriptResult();
        if (value instanceof NativeArray) {
            return new ArrayList<Object>((NativeArray) value);
        }
        if (value instanceof NativeFunction) {
            return value.toString().replace("\n", "").trim();
        }
        if (value instanceof Undefined) {
            return null;
        }
        return value;
    }

    private ResultValueType valueType(final ScriptResult scriptResult) {
        final Object value = scriptResult.getJavaScriptResult();
        if (value == null) {
            return ResultValueType.NULL;
        }
        if (value instanceof NativeArray) {
            return ResultValueType.ARRAY;
        }
        if (value instanceof Boolean) {
            return ResultValueType.BOOLEAN;
        }
        if (value instanceof NativeFunction) {
            return ResultValueType.FUNCTION;
        }
        if (value instanceof Number) {
            return ResultValueType.NUMBER;
        }
        if (value instanceof String) {
            return ResultValueType.STRING;
        }
        if (value instanceof Undefined) {
            return ResultValueType.UNDEFINED;
        }
        // TODO: implement result value type detection
        return ResultValueType.OBJECT;
    }
}
