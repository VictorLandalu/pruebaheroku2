package ufv.dis.finalej2.vg;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	VerticalLayout main =new VerticalLayout();
    	
    	setContent(main);
    	VerticalLayout verticalLayout = new VerticalLayout();
    	
    	
    	Panel panel = new Panel("Crear Tweet");
    	panel.setSizeUndefined(); 
    	FormLayout form = new FormLayout(); 
    	form.setMargin(true);
    	
    	
    	TextField tf1 = new TextField("Autor");
    	tf1.setIcon(VaadinIcons.PENCIL);
    	tf1.setRequiredIndicatorVisible(true);
    	form.addComponent(tf1);
    	
    	TextField tf2 = new TextField("Mensaje");
    	tf2.setIcon(VaadinIcons.BOOK);
    	tf2.setRequiredIndicatorVisible(true);
    	form.addComponent(tf2);
    	
    	TextField tf3 = new TextField("Fecha");
    	tf3.setIcon(VaadinIcons.CALENDAR);
    	tf3.setRequiredIndicatorVisible(true);
    	form.addComponent(tf3);
    	
    	panel.setContent(form);
    	verticalLayout.addComponent(panel);
    	
    	
    	Button button = new Button("Añadir");
    	button.addStyleName(ValoTheme.BUTTON_FRIENDLY);
    	verticalLayout.addComponent(button);
    	
    	Tweets tweets = new Tweets();

    	VerticalLayout verticalLayout2 = new VerticalLayout();
    	Panel viewPanel = new Panel("Lista de Tweets");
    	viewPanel.setSizeUndefined();
    	
    	
    	Grid<Tweet> grid = new Grid<>();
    	grid.addColumn(Tweet::getName).setCaption("Autor");
    	grid.addColumn(Tweet::getMensaje).setCaption("Mensaje");
    	grid.addColumn(Tweet::getDate).setCaption("Fecha");
    	
    	
    	viewPanel.setContent(grid);
    	verticalLayout2.addComponent(viewPanel);

    	HorizontalLayout primero = new HorizontalLayout(verticalLayout, verticalLayout2);
    	
    	primero.setSizeFull();
    	
    	main.addComponent(primero);
    	    	
    	button.addClickListener(e -> {
    		Tweet nuevo = new Tweet(tf1.getValue(),tf2.getValue(),tf3.getValue());
    		if(tweets.Add_Tweet(nuevo)) {
    			Notification.show("Tweet añadido con exito");
    		}
    		else {
    			Notification.show("Error al añadir");
    			
    		}
    		grid.setItems(tweets.Lista_Tweet());
    		tf1.clear();
    		tf2.clear();
    		tf3.clear();
        });
        
        verticalLayout.addComponents(main, button);
        
        setContent(verticalLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
