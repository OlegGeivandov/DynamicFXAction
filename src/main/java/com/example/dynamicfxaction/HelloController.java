package com.example.dynamicfxaction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    Button helloB;
    @FXML
    Button changeAct;

    @FXML
    Label fname;
    @FXML
    VBox wordBox;

    @FXML
    GridPane elGrid;


    @FXML
    private void loadWords()
    {
        String fn = fname.getText();
        try {
            List<String> lines = Files.readAllLines(new File(fn).toPath(), Charset.defaultCharset());
            for (String word: lines ) {
                wordBox.getChildren().add(new TextField(word));
                Button b = new Button("клик");
                wordBox.getChildren().add(b);
                b.setOnAction(actionEvent -> System.out.println("клац "+word));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadAsElClick(){
        ArrayList<Elephant> e = loadElephants(fname.getText());
        paintElephants(e);
    }
    public ArrayList<Elephant> loadElephants(String fname)
    {
        ArrayList<Elephant> elephants=new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(new File(fname).toPath(), Charset.defaultCharset());
            for (String word : lines) {
                elephants.add(new Elephant(word));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return elephants;
    }

    public void paintElephants(ArrayList<Elephant> elephants)
    {
        elGrid.getChildren().clear();
        int k = elGrid.getRowCount();
        for (Elephant el: elephants ) {
            System.out.println("надо бы нарисовать слона");
            Button bt=new Button("***");
            bt.setOnAction(actionEvent -> el.say());
            elGrid.addRow(k+1, new Label(el.name), bt);
            k++;
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){
        test("инициализация контроллера");
        welcomeText.setText("а мы уже тут");
        helloB.setOnAction(a -> welcomeText.setText("нажата кнопка"));
        //Лучше так не делать!!!
        changeAct.setOnAction(a->{
            helloB.setOnAction(b->{
                welcomeText.setText("клац-клац");
            });
        });
    }
    public void test(String s)
    {
        System.out.println(s);
    }
}