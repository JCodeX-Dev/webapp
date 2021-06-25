package dev.jcodex.webapp.model;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "fs.files")
public class PFile {

    @Id
    private ObjectId id;

    @Field("filename")
    private String fileName;

    @Field("metadata")
    private FileMeta meta;
}

