package com.wicket.video.demo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class IndexPage extends WebPage {

    public IndexPage(final PageParameters parameters) {
        super(parameters);
        add(new VideoCard("videoCard"));
    }

}
