package com.khulk.microservice.JSONwiter;

import com.khulk.microservice.models.Task;
import org.w3c.dom.ls.LSInput;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class JSON {
    private final String fileName;
    public JSON(String name) throws IOException {
        this.fileName = name;
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.createFile(Paths.get(this.fileName));
            Files.write(Paths.get(this.fileName),"{}".getBytes());
        }
    }
    public String getFileName() {
        return fileName;
    }
    private  void  clearAllContents() throws IOException {
            FileWriter fileWriter = new FileWriter(this.getFileName(), false);
            fileWriter.write("");
            fileWriter.close();
    }
    public boolean  WriteToFile(HashMap<Integer,Task> tasks)  {
        try {
            if (tasks.isEmpty()) {
                Files.write(Paths.get(fileName), "".getBytes());
            }
            clearAllContents();
            StringBuilder builder= new StringBuilder();
            String jsonString="{";
            for (Task task : tasks.values()) {
                Integer id=task.getId();
                String description=task.getDescription();
                String status= task.getStatus().toString();
                Long createdAt=task.getCreatedAt();
                Long updatedAt=task.getUpdatedAt();
                 jsonString+=String.format( """
                    { "id": %d,
                    "description": %s,
                    "status": %s,
                    "CreatedAt": %s,
                    "UpdatedAt": %s,
                    },
                    """,id,description,status, createdAt, updatedAt);
                //String content= new String(Files.readAllBytes(Paths.get(fileName)));

                //builder=new StringBuilder(content);
            }
            builder.append(jsonString);
            builder.append('}');
            Files.write(Paths.get(fileName), builder.toString().getBytes());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public String GetFileContent() throws IOException {
        return  new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public String convertToJSON(List<Task> tasks) throws IOException {
        StringBuilder builder=new StringBuilder();
        StringBuilder jsonString= new StringBuilder("{");
        for (Task task : tasks) {
            Integer id=task.getId();
            String description=task.getDescription();
            String status= task.getStatus().toString();
            long createdAt=task.getCreatedAt();
            long updatedAt=task.getUpdatedAt();
             jsonString.append(String.format("""
                     { "id": %d,
                     "description":%s,
                     "status":%s,
                     "CreatedAt": %s,
                     "UpdatedAt": %s,
                     },
                     """, id, description, status, createdAt, updatedAt));
            //String content= new String(Files.readAllBytes(Paths.get(fileName)));
            //builder=new StringBuilder(content);
            //builder.deleteCharAt(content.length()-1);

        }
        builder.append(jsonString);
        builder.append('}');
        return builder.toString();
    }
}
