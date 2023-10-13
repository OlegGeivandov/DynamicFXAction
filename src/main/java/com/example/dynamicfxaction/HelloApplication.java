package com.example.dynamicfxaction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("запуск программы");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        System.out.println("загрузка представления из fxml");
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        System.out.println("сейчас будет отоброжено окошко");
        stage.show();
        System.out.println("окошко показано. теперь дело за пользователем");
    }

    public static void main(String[] args) {
        launch();
    }
}