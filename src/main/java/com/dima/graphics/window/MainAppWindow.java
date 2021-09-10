package com.dima.graphics.window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.dima.graphics.constants.Constants.HEIGHT_OF_WINDOW_PIXELS;
import static com.dima.graphics.constants.Constants.WIDTH_OF_WINDOW_PIXELS;

@Slf4j
public class MainAppWindow extends Application {

    public static void launch() {
        Application.launch(MainAppWindow.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Graphics Creator");
        primaryStage.setWidth(WIDTH_OF_WINDOW_PIXELS);
        primaryStage.setHeight(HEIGHT_OF_WINDOW_PIXELS);

        GridPane graphicsPanel = new GridPane();
//
        List<Integer> integers = IntStream.range(0, 20).boxed().collect(Collectors.toList());
//        log.info("LIST BEGIN");
//        integers.stream().forEach(System.out::println);
//        log.info("LIST END");
        List<ColumnConstraints> columnConstraintsList = integers.stream()
                .map(number -> new ColumnConstraints(5)).collect(Collectors.toList());
        graphicsPanel.getColumnConstraints().addAll(columnConstraintsList);
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(5);
        rectangle.setFill(Color.RED);
        GridPane.setRowIndex(rectangle, 0);
        GridPane.setColumnIndex(rectangle, 2);
        graphicsPanel.getChildren().add(rectangle);
        graphicsPanel.getRowConstraints().add(new RowConstraints(5));
        graphicsPanel.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        graphicsPanel.setGridLinesVisible(true);



        StackPane graphicsStackPane = new StackPane(graphicsPanel);

        Label helloWorldLabel = new Label("Hello world!");
        Button buttonClick = new Button("Click me");
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(helloWorldLabel, graphicsStackPane, buttonClick);
        Scene primaryScene = new Scene(flowPane);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
}
