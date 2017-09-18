package com.onlythenaive.concept.ecmarunner.api.configuration;

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
        if (html == null) {
            throw new NullPointerException("Browser layout HTML cannot be null");
        }
        this.html = html;
        if (type == null) {
            throw new NullPointerException("Browser layout type cannot be null");
        }
        this.type = type;
        if (url == null) {
            throw new NullPointerException("Browser layout URL cannot be null");
        }
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
