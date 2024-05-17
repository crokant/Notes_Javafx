package com.example.notes_zhavoronkov;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface NoteOpener {
    default void openNote(int i, TextField TitleText, TextArea NoteText) {

        String fileName = "src/main/directoryFilesNames/notesNames.txt";
        String directoryPath = "src/main/directoryJSONfiles";
        try {
            List<String> names = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));

            if (i <= names.size()) {
                String pathToJson = directoryPath + File.separator + names.get(i-1);
                try (BufferedReader br = new BufferedReader(new FileReader(pathToJson))) {

                    String jsonString = br.readLine();

                    NoteData noteData = JSON.parseObject(jsonString, NoteData.class);

                    String title = noteData.getSimpleNoDate();
                    String content = noteData.getContent();

                    TitleText.setText(title);
                    NoteText.setText(content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void newNote(TextArea textNote, TextField textTitle) {
        textNote.setText("");
        textTitle.setText("");
    }
}
