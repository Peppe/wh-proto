package com.example.client;

import com.vaadin.client.connectors.AbstractRendererConnector;
import com.vaadin.shared.ui.Connect;

@Connect(com.example.MyRenderer.class)
public class MyRendererConnector extends AbstractRendererConnector<String> {

    @Override
    public MyRenderer getRenderer() {
        return (MyRenderer) super.getRenderer();
    }
}
