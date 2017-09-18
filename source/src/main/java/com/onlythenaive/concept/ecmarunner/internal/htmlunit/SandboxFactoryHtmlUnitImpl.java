package com.onlythenaive.concept.ecmarunner.internal.htmlunit;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.Sandbox;
import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
@Immutable
public final class SandboxFactoryHtmlUnitImpl implements SandboxFactory {

    private final SandboxConfiguration configuration;

    public SandboxFactoryHtmlUnitImpl(final SandboxConfiguration configuration) {
        Objects.requireNonNull(configuration, "Sandbox configuration cannot be null");
        this.configuration = configuration;
    }

    @Override
    public Sandbox create() {
        try {
            final WebClient client = new WebClient();
            final ConsoleLogger logger = new ConsoleLogger(configuration.getLogLayout());
            client.getWebConsole().setLogger(logger);
            final StringWebResponse response = response();
            final WebWindow window = client.getCurrentWindow();
            final HtmlPage page = HTMLParser.parseHtml(response, window);
            final Sandbox sandbox = new SandboxHtmlUnitImpl(client, logger, page);
            for (final Dependency dependency : configuration.getDependencies()) {
                final Invoice dependencyInvoice = configuration.getDependencyResolver().resolve(dependency);
                sandbox.execute(dependencyInvoice);
            }
            return sandbox;
        } catch (final IOException e) {
           throw new RuntimeException(e);
        }
    }

    private StringWebResponse response() {
        final URL url = this.configuration.getBrowserLayout().getUrl();
        final String html = this.configuration.getBrowserLayout().getHtml();
        return new StringWebResponse(html, url);
    }
}
