package com.example.notes_zhavoronkov;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class Controller implements NoteSaver, NoteWriter, NoteOpener, FolderOpener {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextArea Note_text;

    @FXML
    private AnchorPane panel_mainNote;

    @FXML
    public TextField Title_text;

    @FXML
    private Button allFiles_button;

    @FXML
    private AnchorPane backgound_panel;

    @FXML
    private AnchorPane buttoms_panel;

    @FXML
    private Button dark_mode_button;

    @FXML
    private Button deleteFiles_button;

    @FXML
    private AnchorPane left_panel;

    @FXML
    private Button light_mode_button;

    @FXML
    private AnchorPane lower_panel;

    @FXML
    private AnchorPane name_panel;

    @FXML
    private Button newNoteButton;

    @FXML
    private TextField note1;

    @FXML
    private TextField note2;

    @FXML
    private TextField note3;

    @FXML
    private TextField note4;

    @FXML
    private TextField note5;

    @FXML
    private TextField note6;

    @FXML
    private TextField note7;

    @FXML
    private Text notes_name;

    @FXML
    private Button open_note1;

    @FXML
    private Button open_note2;

    @FXML
    private Button open_note3;

    @FXML
    private Button open_note4;

    @FXML
    private Button open_note5;

    @FXML
    private Button open_note6;

    @FXML
    private Button open_note7;

    @FXML
    private AnchorPane right_panel;

    @FXML
    private Button save_button;

    @FXML
    void initialize() {
        starWrite(note1, note2, note3, note4, note5, note6, note7);
        allFiles_button.setOnAction(event -> {
            openFolderInExplorer("src/main/directoryJSONfiles");
        });
        dark_mode_button.setOnAction(event -> {
            setDarkMode();
        });

        light_mode_button.setOnAction(event -> {
            setLightMode();
        });

        newNoteButton.setOnAction(event -> {
            newNote(Note_text, Title_text);
        });

        save_button.setOnAction(event -> {
            NoteData noteData = saveNote(Title_text.getText(), Note_text.getText());
            writeNote(note1, note2, note3, note4, note5, note6, note7, noteData);
            Title_text.setText("");
            Note_text.setText("");
        });

        deleteFiles_button.setOnAction(event -> {
            delete_Names();
            note1.setText("");
            note2.setText("");
            note3.setText("");
            note4.setText("");
            note5.setText("");
            note6.setText("");
            note7.setText("");
        });

        open_note1.setOnAction(event -> {
            openNote(1, Title_text, Note_text);
        });

        open_note2.setOnAction(event -> {
            openNote(2, Title_text, Note_text);
        });

        open_note3.setOnAction(event -> {
            openNote(3, Title_text, Note_text);
        });

        open_note4.setOnAction(event -> {
            openNote(4, Title_text, Note_text);
        });

        open_note5.setOnAction(event -> {
            openNote(5, Title_text, Note_text);
        });

        open_note6.setOnAction(event -> {
            openNote(6, Title_text, Note_text);
        });

        open_note7.setOnAction(event -> {
            openNote(7, Title_text, Note_text);
        });
    }
    void delete_Names(){
        String simpleFileName = "src/main/directoryFilesNames/simpleNames.txt";
        String fileName = "src/main/directoryFilesNames/notesNames.txt";
        try(FileWriter fw = new FileWriter(simpleFileName, false))
        {
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(fileName, false))
        {
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void setDarkMode() {
        String backgroundColor = "#000";
        String bigPanelColor = " #0a0a0a";
        String smallPanelColor = "#6b1111";
        String borderColor = "#af1515";
        String buttonColor = "#d4d4d4";
        // Изменение цвета панелек
        backgound_panel.setStyle("-fx-background-color: " + backgroundColor + ";");
        right_panel.setStyle("-fx-background-color:" + bigPanelColor+ "; -fx-background-radius: 25;");
        left_panel.setStyle("-fx-background-color: " + bigPanelColor+"; -fx-background-radius: 25;");
        buttoms_panel.setStyle("-fx-background-color:"+ smallPanelColor+"; -fx-background-radius: 7;");
        lower_panel.setStyle("-fx-background-color:" + smallPanelColor+"; -fx-background-radius: 9;");
        name_panel.setStyle("-fx-background-color: " + smallPanelColor+"; -fx-background-radius: 9;");
        panel_mainNote.setStyle("-fx-background-color: " + buttonColor+"; -fx-background-radius: 15;");
            //изменения цвета названия
        notes_name.setFill(javafx.scene.paint.Color.web(buttonColor));
        // Изменение цвета текстовых полей
        Title_text.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        //Note_text.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note1.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note2.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note3.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note4.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note5.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note6.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note7.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        // Изменение цвета кнопок
        save_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        dark_mode_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        light_mode_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        newNoteButton.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");

        allFiles_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 9;");
        deleteFiles_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 9;");
        open_note1.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note2.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note3.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note4.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note5.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note6.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note7.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
    }

    void setLightMode(){
        String backgroundColor = "#e2c5ff";
        String bigPanelColor = "#ffffff";
        String smallPanelColor = "#fcee98";
        String borderColor = "#9461fe";
        String buttonColor = "#e2c5ff";
        // Изменение цвета панелек
        backgound_panel.setStyle("-fx-background-color: " + backgroundColor + ";");
        right_panel.setStyle("-fx-background-color:" + bigPanelColor+ "; -fx-background-radius: 25;");
        left_panel.setStyle("-fx-background-color: " + bigPanelColor+"; -fx-background-radius: 25;");
        buttoms_panel.setStyle("-fx-background-color:"+ smallPanelColor+"; -fx-background-radius: 7;");
        lower_panel.setStyle("-fx-background-color:" + smallPanelColor+"; -fx-background-radius: 9;");
        name_panel.setStyle("-fx-background-color: " + smallPanelColor+"; -fx-background-radius: 9;");
        panel_mainNote.setStyle("-fx-background-color: " + buttonColor+"; -fx-background-radius: 15;");
        //изменения цвета названия
        notes_name.setFill(javafx.scene.paint.Color.web(buttonColor));
        // Изменение цвета текстовых полей
        Title_text.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        //Note_text.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note1.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note2.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note3.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note4.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note5.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note6.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        note7.setStyle("-fx-background-color:" +bigPanelColor+ "; -fx-border-color: "+borderColor+"; -fx-border-radius: 7; -fx-background-radius: 7;");
        // Изменение цвета кнопок
        save_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        dark_mode_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        light_mode_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        newNoteButton.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 10;");
        allFiles_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 9;");
        deleteFiles_button.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 9;");

        open_note1.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note2.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note3.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note4.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note5.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note6.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
        open_note7.setStyle("-fx-background-color: " + buttonColor + "; -fx-background-radius: 7;");
    }
}
