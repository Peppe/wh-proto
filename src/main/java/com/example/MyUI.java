package com.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.teemu.VaadinIcons;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@StyleSheet({"https://fonts.googleapis.com/css?family=Montserrat"})
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        HorizontalLayout header = createHeader();
        layout.addComponent(header);

        Grid grid = createGrid();
        layout.addComponent(grid);

        HorizontalLayout footer = createFooter();
        layout.addComponent(footer);


        layout.setExpandRatio(grid, 1);
        layout.setSizeFull();
        setContent(layout);
    }

    private HorizontalLayout createHeader() {
        Label headerLabel = new Label("<span style=\"color:#ffc13f;font-size:24px;vertical-align: middle;\">" + VaadinIcons.CLOCK.getHtml() + "</span> Workhours");
        headerLabel.addStyleName("layout-header-label");
        headerLabel.setContentMode(ContentMode.HTML);
        Button hoursButton = new Button("Hours");
        Button reportsButton = new Button("Reports");
        Button manageButton = new Button("Manage");
        hoursButton.addStyleName(ValoTheme.BUTTON_LINK);
        hoursButton.addStyleName("layout-header-hours");
        reportsButton.setStyleName(ValoTheme.BUTTON_LINK);
        manageButton.setStyleName(ValoTheme.BUTTON_LINK);
        final HorizontalLayout buttons = new HorizontalLayout(hoursButton, reportsButton, manageButton);
        buttons.addStyleName("layout-header-buttons");
        Button logoutButton = new Button("Log out");
        logoutButton.addStyleName("layout-header-logout");
        logoutButton.addStyleName(ValoTheme.BUTTON_LINK);
        final HorizontalLayout header = new HorizontalLayout(headerLabel, buttons, logoutButton);
        header.addStyleName("layout-header");
        header.setComponentAlignment(headerLabel, Alignment.MIDDLE_LEFT);
        header.setComponentAlignment(buttons, Alignment.MIDDLE_CENTER);
        header.setComponentAlignment(logoutButton, Alignment.MIDDLE_RIGHT);
        header.setWidth("100%");
        return header;
    }

    private Grid createGrid() {
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty("Project", String.class, null);
        container.addContainerProperty("Contract", String.class, null);
        container.addContainerProperty("Time", String.class, null);
        container.addContainerProperty("Description", String.class, null);
        container.addContainerProperty("Department", String.class, null);
        container.addContainerProperty("Time Category", String.class, null);
        for (int i = 0; i <30; i++){
            Item item = container.addItem(i);
            item.getItemProperty("Project").setValue("Project");
            item.getItemProperty("Contract").setValue("Contract");
            item.getItemProperty("Time").setValue("4h 30min");
            item.getItemProperty("Description").setValue("Description");
            item.getItemProperty("Department").setValue("SER");
            item.getItemProperty("Time Category").setValue("Normal");
        }
        Grid grid = new Grid();
        grid.setContainerDataSource(container);
        grid.setSizeFull();
        return grid;
    }


    private HorizontalLayout createFooter() {
        Label total = new Label("This month total: 35h 30min (147h)");
        Label selected = new Label("Selected total:");
        Label border = new Label("");
        border.addStyleName("layout-footer-border");
        Label currentFlex = new Label("Current flex: -14h 30min");
        Label lastMonthFlex = new Label("Flex end of last month: +2h 15min");
        total.setWidth(null);
        selected.setWidth(null);
        border.setWidth(null);
        currentFlex.setWidth(null);
        lastMonthFlex.setWidth(null);
        Button adjust = new Button("+/- Adjust");
        adjust.addStyleName(ValoTheme.BUTTON_LINK);
        adjust.addStyleName("layout-footer-adjust");
        final HorizontalLayout footer = new HorizontalLayout(total, selected, border, currentFlex, lastMonthFlex, adjust);
        footer.addStyleName("layout-footer");
        footer.setWidth("100%");
        return footer;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
