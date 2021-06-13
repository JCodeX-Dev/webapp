package dev.jcodex.webapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fs.files")
public class PFile {

    @Id
    private ObjectId id;

    @Field("filename")
    private String fileName;

    @Field("metadata")
    private FileMeta meta;
//    public InputStream stream;


    public ObjectId getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public FileMeta getMeta() {
        return meta;
    }
}

