package com.dima.graphics;

import com.dima.graphics.window.MainAppWindow;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GraphicsAppRunner {

    public static void main(String[] args) {
        log.info("RUN BEGIN");
        System.out.println("RUN!!!!");
        MainAppWindow.launch();
        log.info("RUN END");
    }
}
