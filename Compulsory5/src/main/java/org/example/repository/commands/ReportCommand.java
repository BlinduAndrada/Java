package org.example.repository.commands;

import org.example.repository.DocumentsRepository;
import org.example.exceptions.DocumentException;
import org.example.exceptions.ReportException;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReportCommand extends Command {
    private DocumentsRepository repository;

    /**
     * the command report that creates and opens a html page with the files it finds in a repository
     */
    public ReportCommand() {
        super("report");
    }

    /**
     *
     * @param repository the repository we set in
     */
    public void setRepo(DocumentsRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @throws IOException for the exception
     * we create a html template for the path we gave, and then we write in the html page with the Write function
     * we then use flush to delete everything after we wrote it
     * we use the configuration for the Free Maker, and then we launch it, and we create the html and open it
     *we make a map with the data used in the template
     */
    @Override
    void code() throws IOException {
        File template = new File(repository.getPath() + File.separator + "report_template.ftl");
        if (!template.exists()) {
            boolean create = false;

            create = template.createNewFile();

            System.out.println("It doesn't exist. We create the template");
            if (!create) {
                create = template.createNewFile();
            }
            if (!create) {
                throw new IOException("Could not create file");
            }
        }

        try (Writer writeFile = new FileWriter(template)) {
            System.out.println("Scrie continut");
            String content = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Repository Report</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Repository Content</h1>\n" +
                    "    <ul>\n" +
                    "        <#list files as file>\n" +
                    "            <li>${file}</li>\n" +
                    "        </#list>\n" +
                    "    </ul>\n" +
                    "</body>\n" +
                    "</html>";

            writeFile.write(content);
            writeFile.flush();
        }


        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setTemplateLoader(new FileTemplateLoader(new File(this.repository.getPath())));

        try {
            List<File> fileList = this.repository.getFiles();

            Template template1 = cfg.getTemplate("report_template.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("files", fileList);

            File reportFile = new File(repository.getPath() + File.separator + "report_template.html");
            FileWriter writer = new FileWriter(reportFile);
            template1.process(data, writer);
            writer.flush();
            writer.close();

            System.out.println("html generated :D");
            ViewCommand v = new ViewCommand(this.repository);

            v.launch("report_template.html");
        } catch (IOException | TemplateException e) {
            System.out.println(e.getMessage());
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @throws IOException for the exception
     * we run the code for the command
     */
    @Override
    public void run() throws IOException {
        code();
    }

}
