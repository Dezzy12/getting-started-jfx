package com.dezzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //The size toggle pane
        RadioButton rdoSmall = new RadioButton("Small");
        RadioButton rdoMedium = new RadioButton("Medium");
        RadioButton rdoLarge = new RadioButton("Large");

        ToggleGroup sizeGroup = new ToggleGroup();
        sizeGroup.getToggles().addAll(rdoSmall,rdoMedium,rdoLarge);
        rdoMedium.setSelected(true);

        VBox sizeBox = new VBox(10);
        sizeBox.setPadding(new Insets(10));
        sizeBox.getChildren().addAll(rdoSmall,rdoMedium,rdoLarge);
        TitledPane sizeType = new TitledPane("Size", sizeBox);

        // The style toggle pane
        RadioButton rdoThin = new RadioButton("Thin crust");
        RadioButton rdoThick = new RadioButton("Thick crust");

        ToggleGroup styleGroup = new ToggleGroup();
        styleGroup.getToggles().addAll(rdoThin,rdoThick);
        rdoThin.setSelected(true);

        VBox styleBox = new VBox(10);
        styleBox.setPadding(new Insets(10));
        styleBox.getChildren().addAll(rdoThin,rdoThick);
        TitledPane stylePane = new TitledPane("Style", styleBox);

        //The toppings toggle page
        CheckBox checkBoxPep = new CheckBox("Pepperoni");
        CheckBox checkBoxSaus = new CheckBox("Sausage");
        CheckBox checkBoxOlives = new CheckBox("Olives");
        CheckBox checkBoxMush = new CheckBox("Mushrooms");
        CheckBox checkBoxAnch = new CheckBox("Anchovies");

        VBox toppingBox = new VBox(10);
        toppingBox.setPadding(new Insets(10));
        toppingBox.getChildren().addAll(checkBoxOlives,checkBoxAnch,checkBoxSaus,checkBoxMush,checkBoxPep);

        TitledPane toppingsTpane = new TitledPane("Toppings", toppingBox);
        toppingsTpane.setCollapsible(true);

        // Accordion control
        Accordion acc = new Accordion();
        acc.getPanes().addAll(sizeType,stylePane,toppingsTpane);

        Scene scene = new Scene(acc);
        stage.setScene(scene);
        stage.setTitle("Titled Panes");
        stage.setWidth(200);
        stage.setHeight(300);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
