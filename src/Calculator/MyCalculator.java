package Calculator;

import com.dezzy.ConfirmationBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyCalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    private TextField textField = new TextField();
    private long num1 = 0;
    private String operator = "";
    private boolean start = true;

    Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        textField.setFont(Font.font(20));
        textField.setPrefHeight(50);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setEditable(false);

        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().add(textField);

        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setAlignment(Pos.TOP_CENTER);
        tilePane.getChildren().addAll(
                createButtonForNumber("7"),
                createButtonForNumber("8"),
                createButtonForNumber("9"),
                createButtonForOperator("/"),

                createButtonForNumber("4"),
                createButtonForNumber("5"),
                createButtonForNumber("6"),
                createButtonForOperator("X"),

                createButtonForNumber("1"),
                createButtonForNumber("2"),
                createButtonForNumber("3"),
                createButtonForOperator("-"),

                createButtonForNumber("0"),
                createButtonForClear("C"),
                createButtonForOperator("="),
                createButtonForOperator("+")

        );

        BorderPane root = new BorderPane();
        root.setTop(stackPane);
        root.setCenter(tilePane);
        Scene scene = new Scene(root, 250, 310);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            btnClose_Click();
        });
        primaryStage.show();

    }

    private Button createButtonForNumber(String ch) {
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::processNumber);
        return button;
    }

    private Button createButtonForOperator(String ch) {
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::processOperator);
        return button;
    }

    private Button createButtonForClear(String ch) {
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(e -> {
            textField.setText("");
            operator = "";
            start = true;
        });
        return button;
    }

    private void processNumber(ActionEvent e) {
        if (start) {
            textField.setText("");
            start = false;
        }
        String value = ((Button) e.getSource()).getText();
        textField.setText(textField.getText() + value);
    }

    private void processOperator(ActionEvent e) {
        String value = ((Button) e.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            num1 = Long.parseLong(textField.getText());
            operator = value;
            textField.setText("");
        } else {
            if (operator.isEmpty())
                return;
            long num2 = Long.parseLong(textField.getText());
            float result = calculate(num1, num2, operator);
            textField.setText(String.valueOf(result));
            start = true;
            operator = "";
        }
    }

    private float calculate(long num1, long num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "X":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0;
                return num1 / num2;
            default:
                return 0;
        }
    }

    public void btnClose_Click() {
        boolean confirm = false;
        confirm = ConfirmationBox.show("Are you sure you want to quit?",
                "Confirmation", "Yes", "No");

        if (confirm) {
            //place any code needed to save files or
            // close resources here.

            stage.close();
        }
    }
}
