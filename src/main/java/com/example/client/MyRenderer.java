package com.example.client;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * Created by jensj on 01/10/2016.
 */
public class MyRenderer implements Renderer<String> {


    @Override
    public void render(RendererCellReference cell, String string) {
        cell.getElement().setInnerSafeHtml(SafeHtmlUtils.fromSafeConstant("Hello world " + string ));
    }
}
