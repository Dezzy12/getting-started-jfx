package com.dezzy;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenusBar extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){

        // Creating the main menu
        MenuBar main_menu = new MenuBar();
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu View = new Menu("View");
        Menu Navigate = new Menu("Navigate");
        Menu Code = new Menu("Code");
        Menu Refactor = new Menu("Refactor");
        Menu Build = new Menu("Build");
        Menu Run = new Menu("Run");
        Menu Tools = new Menu("Tools");

        // Mapping all the menu objects to the menu bar
        main_menu.getMenus().add(File);
        main_menu.getMenus().add(Edit);
        main_menu.getMenus().add(View);
        main_menu.getMenus().add(Navigate);
        main_menu.getMenus().add(Code);
        main_menu.getMenus().add(Refactor);
        main_menu.getMenus().add(Build);
        main_menu.getMenus().add(Run);
        main_menu.getMenus().add(Tools);

        // Menu items for fileMenu
        Menu New = new Menu("New");
//        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open... ");
        MenuItem OpenRecent = new MenuItem("Open Recent");
        MenuItem Remote = new MenuItem("Remote Development...  ");
        MenuItem Close = new MenuItem("Close Project");
        MenuItem Settings = new MenuItem("Settings...  ");
        MenuItem projectStructure = new MenuItem("Project Structure...  ");

        // Menu items for EditMenu
        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        // menu item for New
        MenuItem project = new MenuItem("Project...");
        MenuItem project2 = new MenuItem("Project from existing source...");
        MenuItem project3 = new MenuItem("Project from vesion control...");
        MenuItem module1 = new MenuItem("Module...");
        MenuItem module2 = new MenuItem("Module from existing source...");
        MenuItem javaClass = new MenuItem("Java Class");
        MenuItem file = new MenuItem("File");

        // mapping menuItems for New
        New.getItems().add(project);
        New.getItems().add(project2);
        New.getItems().add(project3);
        New.getItems().add(new SeparatorMenuItem());
        New.getItems().add(module1);
        New.getItems().add(module2);
        New.getItems().add(new SeparatorMenuItem());
        New.getItems().add(javaClass);
        New.getItems().add(file);



        // mapping menuItems to file menu
        File.getItems().add(New);
        File.getItems().add(Open);
        File.getItems().add(OpenRecent);
        File.getItems().add(Remote);
        File.getItems().add(Close);
        File.getItems().add(new SeparatorMenuItem());
        File.getItems().add(Settings);
        File.getItems().add(projectStructure);

        // mapping menuItems to edit menu
        Edit.getItems().add(undo);
        Edit.getItems().add(redo);
        Edit.getItems().add(new SeparatorMenuItem());
        Edit.getItems().add(cut);
        Edit.getItems().add(copy);
        Edit.getItems().add(paste);


        BorderPane root = new BorderPane();
        root.setTop(main_menu);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Intellij IDEA Ultimate Edition");
        primaryStage.show();
    }
}

