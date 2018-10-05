package cn.sixlab.app.rm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RmController implements Initializable {
    public static RmController self;

    public TextArea leftText;
    public TextArea rightText;

    public void textChange(KeyEvent event) {
        TextArea textArea = (TextArea) event.getTarget();
        rightText.setText(textArea.getText().length() + " 个字符");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        self = this;
    }

    public void itemClick(ActionEvent actionEvent) {
        System.out.println("itemClick");
    }
}
