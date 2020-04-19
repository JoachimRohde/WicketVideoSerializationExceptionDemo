package com.wicket.video.demo;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class WicketApplication extends WebApplication {

    @Override
    public final Session newSession(Request request, Response response) {
        return new WebSession(request);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return IndexPage.class;
    }

}
