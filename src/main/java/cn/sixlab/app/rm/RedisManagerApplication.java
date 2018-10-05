package cn.sixlab.app.rm;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RedisManagerApplication extends Application {
    private static Logger logger = LoggerFactory.getLogger(RedisManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RedisManagerApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.setImplicitExit(true);
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("rm.fxml"));
        } catch (IOException e1) {
            parent = new Label("读取失败");
            logger.error(e1.getMessage(), e1);
        }
        Scene scene = new Scene(parent, 1040, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Redis Manager");
        primaryStage.show();
    }
}
