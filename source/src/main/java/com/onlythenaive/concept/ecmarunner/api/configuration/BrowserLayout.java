package com.onlythenaive.concept.ecmarunner.api.configuration;

import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
public final class BrowserLayout {

    private final String html;
    private final BrowserType type;
    private final String url;

    public BrowserLayout(final String html,
                         final BrowserType type,
                         final String url) {
        this.html = html;
        this.type = type;
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
