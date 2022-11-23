package com.dezzy;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MovieInventory extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label labelHeading = new Label("Movie Inventory");
        labelHeading.setFont(new Font("Arial", 20));

        TableView<Movie> table = new TableView<Movie>();
        table.setItems(loadData());

        TableColumn<Movie, String> colTitle = new TableColumn("Title");
        colTitle.setMinWidth(300);
        colTitle.setCellValueFactory(
                new PropertyValueFactory<Movie, String>("Title"));

        TableColumn<Movie, Integer> colYear = new TableColumn("Year");
        colYear.setMinWidth(100);
        colYear.setCellValueFactory(
                new PropertyValueFactory<Movie, Integer>("Year")
        );

        TableColumn<Movie, Double> colPrice = new TableColumn("Price");
        colPrice.setMinWidth(100);
        colPrice.setCellValueFactory(
                new PropertyValueFactory<Movie, Double>("Price")
        );

        table.getColumns().addAll(colTitle, colYear, colPrice);

        VBox paneMain = new VBox();
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(10, 10, 10, 10));
        paneMain.getChildren().addAll(labelHeading, table);

        Scene scene = new Scene(paneMain);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Movie Inventory");
        primaryStage.show();
    }

    public ObservableList<Movie> loadData() {
        ObservableList<Movie> data = FXCollections.observableArrayList();

        data.add(new Movie("It's a Wonderful Life",
                1946, 14.95));
        data.add(new Movie("Young Frankenstein",
                1974, 16.95));
        data.add(new Movie("Star Wars Episode 4",
                1976, 17.95));
        data.add(new Movie("The Princess Bride",
                1987, 16.95));
        data.add(new Movie("Glory",
                1989, 14.95));
        data.add(new Movie("The Game",
                1997, 14.95));
        data.add(new Movie("Shakespeare in Love",
                1998, 19.95));
        data.add(new Movie("The Invention of Lying",
                2009, 18.95));
        data.add(new Movie("The King's Speech",
                2010, 19.95));

        return data;
    }


}
