package com.example;

import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.Renderer;

public class MyRenderer extends Grid.AbstractRenderer<String> {

    protected MyRenderer() {
        super(String.class);
    }
}
