package com.dima.graphics.window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        graphicsPanel.getColumnConstraints().addAll(new ColumnConstraints(10),
                new ColumnConstraints(110),
                new ColumnConstraints(50));

        List<Integer> integers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        log.info("LIST BEGIN");
        integers.stream().forEach(System.out::println);
        log.info("LIST END");
//        graphicsPanel.getColumnConstraints().addAll(IntStream.range(0, 12)
//                .collect(Collectors.toList()));
        graphicsPanel.setGridLinesVisible(true);
        graphicsPanel.getChildren().addAll(new Label(), new Label(), new Label());

        Label helloWorldLabel = new Label("Hello world!");
        Button buttonClick = new Button("Click me");
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(graphicsPanel, helloWorldLabel, buttonClick);
        Scene primaryScene = new Scene(flowPane);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
}
