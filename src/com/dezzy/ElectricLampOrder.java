package com.dezzy;

import javafx.application.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.control.CheckBox;




public class ElectricLampOrder extends Application {
    public static void main(String[] args){
        System.out.println("Started");
        launch(args);
        System.out.println("ended");
    }
        Stage stage;

    // Customer name, phone, and address fields
    TextField txtName;
    TextField txtPhone;
    TextField txtAddress;

    // Type Radio buttons;
    RadioButton rdoSpot;
    RadioButton rdoCoiled;
    RadioButton rdoFluorescent;
    RadioButton rdoFTube;

    // Size Radio buttons
    RadioButton rdoSmall;
    RadioButton rdoMedium;
    RadioButton rdoLarge;

    // Color Radio buttons
    RadioButton rdoWhite;
    RadioButton rdoWarmWhite;
    RadioButton rdoBlue;
    RadioButton rdoRed;

    //Other equipments
    CheckBox chkSwitch;
    CheckBox chkCables;
    CheckBox chkLampHolder;
    CheckBox chkScrews;

    @Override public void start(Stage primaryStage){
        stage = primaryStage;

        // ----- Create the top pane -----
        Text textHeading  =  new Text("Order Your Electric Lamp Now");
        textHeading.setFont(new Font(20));
        HBox paneTop = new HBox(textHeading);
        paneTop.setPadding(new Insets(20,10,20,10));

        // --------------- Creating the customer pane ---------------

        //  Name label and text field
        Label labelName = new Label("Name:");
        labelName.setPrefWidth(100);
        txtName = new TextField();
        txtName.setPrefColumnCount(20);
        txtName.setPromptText("Enter the Customer's name here");
        txtName.setMaxWidth(Double.MAX_VALUE);
        HBox paneName = new HBox(labelName,txtName);

        // Create the phone number label and text field
        Label labelPhone = new Label("Phone Number:");
        labelPhone.setPrefWidth(100);
        txtPhone = new TextField();
        txtPhone.setPrefColumnCount(20);
        txtPhone.setPromptText("Enter the customer's phone number here");
        txtPhone.setMaxWidth(Double.MAX_VALUE);
        HBox panePhone = new HBox(labelPhone, txtPhone);

        // Create the address label and text field
        Label labelAddress = new Label("Address:");
        labelAddress.setPrefWidth(100);
        txtAddress = new TextField();
        txtAddress.setPrefColumnCount(20);
        txtAddress.setPromptText("Enter te customer's address here");
        HBox paneAddress = new HBox(labelAddress, txtAddress);

        // Create the customer pane
        VBox paneCustomer = new VBox(10, paneName,panePhone,paneAddress);

        // ------------- Create the order pane -----------------

        // Create the type pane
        Label labelType = new Label("Type");
        rdoSpot = new RadioButton("Spot");
        rdoCoiled = new RadioButton("Coiled");
        rdoFluorescent = new RadioButton("Fluorescent");
        rdoFTube = new RadioButton("Tube ");
        rdoFluorescent.setSelected(true);
        ToggleGroup groupType = new ToggleGroup();
        rdoSpot.setToggleGroup(groupType);
        rdoCoiled.setToggleGroup(groupType);
        rdoFluorescent.setToggleGroup(groupType);
        rdoFTube.setToggleGroup(groupType);

        VBox paneType = new VBox(labelType,rdoSpot,rdoCoiled,rdoFluorescent,rdoFTube);
        paneType.setSpacing(10);

        // Create the size pane
        Label labelSize = new Label("Size");
        rdoSmall = new RadioButton("Small");
        rdoMedium = new RadioButton("Medium");
        rdoLarge = new RadioButton("Large");
        rdoMedium.setSelected(true);
        ToggleGroup groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(labelSize,rdoSmall,rdoMedium,rdoLarge);
        paneSize.setSpacing(10);

        // Create color pane
        Label labelColor = new Label("Color");
        rdoWhite = new RadioButton("White");
        rdoWarmWhite = new RadioButton("Warm White");
        rdoBlue = new RadioButton("Blue");
        rdoRed = new RadioButton("Red");
        rdoWhite.setSelected(true);
        ToggleGroup groupColor = new ToggleGroup();
        rdoWhite.setToggleGroup(groupColor);
        rdoWarmWhite.setToggleGroup(groupColor);
        rdoBlue.setToggleGroup(groupColor);
        rdoRed.setToggleGroup(groupColor);

        VBox paneColor = new VBox(labelColor, rdoWhite,rdoWarmWhite,rdoBlue,rdoRed);
        paneColor.setSpacing(10);

        // Create other equipments pane
        Label labelOthers = new Label("Others");
        chkSwitch = new CheckBox("Switch");
        chkCables = new CheckBox("Cables");
        chkLampHolder = new CheckBox("Lamp holders");
        chkScrews = new CheckBox("Screws");

        //creating css properties
        ToggleGroup groupTheme = new ToggleGroup();
        RadioButton rdoModena =
                new RadioButton("Modena Theme");
        rdoModena.setToggleGroup(groupTheme);
        rdoModena.setSelected(true);
        rdoModena.setOnAction(e ->
        {
            setUserAgentStylesheet(STYLESHEET_MODENA);
        });
        RadioButton rdoCaspian =
                new RadioButton("Caspian Theme");
        rdoCaspian.setToggleGroup(groupTheme);
        rdoCaspian.setOnAction(e ->
        {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });
        HBox paneTheme = new HBox(10, rdoModena, rdoCaspian);

        FlowPane paneOthers = new FlowPane(Orientation.VERTICAL,chkSwitch,chkCables,chkLampHolder,chkScrews);
        paneOthers.setPadding(new Insets(10,0,10,0));
        paneOthers.setHgap(20);
        paneOthers.setVgap(10);
        paneOthers.setPrefWrapLength(100);

        VBox paneOther = new VBox(labelOthers, paneOthers);

        // Add the type,size,color and others pane to the order pane

        HBox paneOrder = new HBox(50, paneType, paneSize,paneColor,paneOther);

        // Create the center pane
        VBox paneCenter = new VBox(20, paneCustomer, paneOrder);
        paneCenter.setPadding(new Insets(0,10,0,10));

        //-------------- Create the bottom page ----------------
        Button btnOk = new Button("OK");
        btnOk.setPrefWidth(80);
        btnOk.setOnAction(e -> btnOk_Click());

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click());

        Region spacer = new Region();
        HBox paneBottom = new HBox(10,paneTheme, spacer, btnOk, btnCancel);
        paneBottom.setHgrow(spacer, Priority.ALWAYS);
        paneBottom.setPadding(new Insets(20,10,20,10));

        // -------------- finish the scene ----------------
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        paneMain.setCenter(paneCenter);
        paneMain.setBottom(paneBottom);

        // Create the scene and the stage
        Scene scene = new Scene(paneMain);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Electric Lamps Order");
        primaryStage.show();

    }
    public void btnOk_Click(){
        // Create a message with the customers information

        String msg = "Customer:\n\n";
        msg += "\t" + txtName.getText() + "\n";
        msg += "\t" + txtAddress.getText() + "\n";
        msg += "\t" + txtPhone.getText() + "\n\n";
        msg += "You have ordered a ";

        // Add the Lamp type
        if(rdoSpot.isSelected())
            msg += "Spot Lamp ";
        if (rdoCoiled.isSelected())
            msg += "Coiled Lamp ";
        if (rdoFluorescent.isSelected())
            msg += "Fluorescent Lamp ";
        if (rdoFTube.isSelected())
            msg+= "Tube Lamp ";

        // Add the lamp size
        if (rdoSmall.isSelected())
            msg += "of size 'Small', ";
        if (rdoMedium.isSelected())
            msg += "of size 'Medium', ";
        if (rdoLarge.isSelected())
            msg += "of size 'Large', ";

        // Add the color
        if (rdoWhite.isSelected())
            msg += "White color.\n";
        if (rdoWarmWhite.isSelected())
            msg += "Warm White color.\n";
        if (rdoBlue.isSelected())
            msg += "Blue color.\n";
        if (rdoRed.isSelected())
            msg += "Red color.\n";

        // Add the other Equipments
        String Others = "";
        Others = buildOthers(chkSwitch,Others);
        Others = buildOthers(chkCables,Others);
        Others = buildOthers(chkLampHolder,Others);
        Others = buildOthers(chkScrews,Others);

        if(Others.equals(""))
            msg += "No extra equipments";
        else
            msg += "Extra Equipments:\n" + Others;

        // Display the message
        MessageBox.show(msg,"Order Details");



    }

    public String buildOthers(CheckBox chk, String msg){
        // Helper method for displaying the list of extra equipments(others)
        if (chk.isSelected()){
            if (!msg.equals("")){
                msg += ", ";
            }
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click(){
        boolean confirm = false;
        confirm = ConfirmationBox.show("Are you sure you want to quit?",
                "Confirmation", "Yes", "No");

        if (confirm){
            //place any code needed to save files or
            // close resources here.

            stage.close();
        }
    }

}
