package org.example.repository;

import org.example.exceptions.ExceptionsHandling;
import org.example.repository.records.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.exceptions.DocumentException;
import org.example.repository.records.Document;
import org.example.repository.records.Person;


public class DocumentsRepository {

    private File masterDirectory;
    String pathOfDirectory;

    public DocumentsRepository(String masterDirectoryPath) throws DocumentException {
        this.masterDirectory = new File(masterDirectoryPath);
        this.pathOfDirectory = masterDirectoryPath;

    }

    public String getPath() {
        return pathOfDirectory;
    }

    public File getMasterDirectory() {
        return masterDirectory;
    }

    public void setMasterDirectory(File masterDirectory) {
        this.masterDirectory = masterDirectory;
    }

    /**
     *
     * @return the list of all documents from a repository
     * @throws DocumentException for the exception
     */
    public List<File> getFiles() throws DocumentException {
        List<File> temp = List.of(this.masterDirectory.listFiles());
        if (temp.isEmpty()) {
            throw new DocumentException("No documents in directory");
        }
        return temp;
    }



}
