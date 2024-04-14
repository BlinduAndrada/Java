package org.example.repository.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repository.DocumentsRepository;

import java.io.File;
import java.io.IOException;

public class ExportCommand extends Command {
    private DocumentsRepository repo;
    private ObjectMapper mapper;

    /**
     *
     * @param repo the repository where we use the command
     */
    public ExportCommand(DocumentsRepository repo) {
        super("export");
        this.repo = repo;
    }

    /**
     *
     * @param repo the repository we set for this command
     */
    public void setRepo(DocumentsRepository repo) {
        this.repo = repo;
    }

    /**
     *
     * @throws IOException for the exception
     *we write the repo object as JSON to a file in the repository path
     */
    @Override
    void code() throws IOException {
        this.mapper = new ObjectMapper();
        mapper.writeValue(new File(this.repo.getPath() + File.separator + "jsonFile.json"), repo);

    }

    @Override
    public void run() throws IOException {
        code();
    }

}
