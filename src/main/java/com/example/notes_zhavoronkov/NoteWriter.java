package com.example.notes_zhavoronkov;

import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface NoteWriter {
    String simpleFileName = "src/main/directoryFilesNames/simpleNames.txt";
    String fileName = "src/main/directoryFilesNames/notesNames.txt";
    List<TextField> listNotes = new ArrayList<>();
    default void writeNote(TextField note1, TextField note2, TextField note3, TextField note4, TextField note5,
                           TextField note6, TextField note7, NoteData noteData) {
        listNotes.add(note1);
        listNotes.add(note2);
        listNotes.add(note3);
        listNotes.add(note4);
        listNotes.add(note5);
        listNotes.add(note6);
        listNotes.add(note7);
        try {
            List<String> listOfNames = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
            listOfNames.add(0, noteData.fileName);
            List<String> listOfSimpleNames = new ArrayList<>(Files.readAllLines(Paths.get(simpleFileName)));
            listOfSimpleNames.add(0, noteData.simpleFileName);
            try (FileWriter fw = new FileWriter(fileName); FileWriter fws = new FileWriter(simpleFileName);) {
                String temp;
                for (int i = 0; i < listOfNames.size(); i++) {
                    fw.write(listOfNames.get(i) + System.lineSeparator());
                    temp = listOfSimpleNames.get(i) + System.lineSeparator();
                    fws.write(temp);
                    if (i <= 6) {
                        listNotes.get(i).setText(temp);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default void starWrite(TextField note1, TextField note2, TextField note3, TextField note4, TextField note5,
                           TextField note6, TextField note7) {
        listNotes.add(note1);
        listNotes.add(note2);
        listNotes.add(note3);
        listNotes.add(note4);
        listNotes.add(note5);
        listNotes.add(note6);
        listNotes.add(note7);
        try {
            List<String> listOfNames = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
            List<String> listOfSimpleNames = new ArrayList<>(Files.readAllLines(Paths.get(simpleFileName)));
            String temp;
            for (int i = 0; i < listOfNames.size(); i++) {
                temp = listOfSimpleNames.get(i) + System.lineSeparator();
                if (i <= 6) {
                    listNotes.get(i).setText(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



