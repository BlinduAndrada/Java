package org.example.repository.commands;

import org.example.repository.DocumentsRepository;
import org.example.exceptions.DocumentException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewCommand extends Command {
    private DocumentsRepository repo;
    private String programme;

    /**
     *
     * @param repo the repository we are in
     *             the command name
     */
    public ViewCommand(DocumentsRepository repo) {
        super("view");
        this.repo = repo;
    }

    /**
     *
     * @param repo the repo it works in
     */
    /**
     *
     * @param repo the repo we set
     */
    public void setRepo(DocumentsRepository repo) {
        this.repo = repo;
    }

    /**
     * the function of the command where we use Desktop class to open a document, with a given name and from a set repository
     * we also check if the file exists
     * @throws IOException the exception
     */
    @Override
    void code() throws IOException {
        Desktop d = Desktop.getDesktop();
        Scanner scan = new Scanner(System.in);
        programme = scan.nextLine();
        File file = new File(repo.getPath() + File.separator + programme);
        try {
            if (!file.exists() || file.isDirectory()) {
                throw new DocumentException("This file doesn't exist :( ");
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        d.open(file);

    }

    /**
     *
     * @param relativePath the path from where we get the file, and then we launch it with the function,
     *                     so we can open that file, and again we check if it exists
     * @throws IOException for the exception
     */
    public void launch(String relativePath) throws IOException {
        Desktop d = Desktop.getDesktop();

        File file = new File(repo.getPath() + File.separator + relativePath);

        try {
            if (!file.exists() || file.isDirectory()) {
                throw new DocumentException("This file doesn't exist :( ");
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }

        d.open(file);
    }

    /**
     *
     * @throws IOException the exception
     * the function we run the code with the command
     */
    @Override
    public void run() throws IOException {
        code();
    }

    public void setRepository(DocumentsRepository temp) {
        this.repo = temp;
    }
}
