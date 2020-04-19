package com.wicket.video.demo;

import java.net.URI;
import java.nio.file.Path;
import java.util.Date;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.media.video.Video;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.resource.FileSystemResourceReference;

public class VideoCard extends Panel {

    private transient Path path;
    private transient FileSystemResourceReference ref;
    private transient Video video = null;

    public VideoCard(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize(); //To change body of generated methods, choose Tools | Templates.

        WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        add(wmc);

        // TODO: change this path
        String moviePath = "file:///home/jr/Desktop/example.mp4";

        try {
            path = FileSystemResourceReference.getPath(URI.create(moviePath));
            ref = new FileSystemResourceReference("video" + new Date().toString(), path);
            video = new Video("video", ref);
            wmc.add(video);

            // If the AjaxLink is removed the exception does not occur
            add(new AjaxLink("playButton") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    video.setAutoplay(true);
                    target.add(video);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
