package com.example.notes_zhavoronkov;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public interface FolderOpener {
    default void openFolderInExplorer(String folderPath) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                File folder = new File(folderPath);
                desktop.open(folder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
