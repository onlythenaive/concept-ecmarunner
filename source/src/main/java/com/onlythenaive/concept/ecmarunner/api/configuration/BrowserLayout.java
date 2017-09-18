package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class BrowserLayout {

    private final String html;
    private final BrowserType type;
    private final String url;

    public BrowserLayout(final String html,
                         final BrowserType type,
                         final String url) {
        Objects.requireNonNull(html, "Browser layout HTML cannot be null");
        this.html = html;
        Objects.requireNonNull(type, "Browser layout type cannot be null");
        this.type = type;
        Objects.requireNonNull(url, "Browser layout URL cannot be null");
        this.url = url;
    }

    public String getHtml() {
        return this.html;
    }

    public BrowserType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }
}
