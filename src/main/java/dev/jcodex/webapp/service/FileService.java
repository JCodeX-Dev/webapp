package dev.jcodex.webapp.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import dev.jcodex.webapp.model.PFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public String addFile(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }

    public byte[] getFile(PFile pFile) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id")
                .is(pFile.getId())));
        return operations.getResource(file)
                .getInputStream()
                .readAllBytes();
    }

    public HttpHeaders getHeaders(PFile file) {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.parseMediaType(file.getMeta()
                .getContentType()));
        String fileName = file.getFileName();
        head.add("content-disposition", "attachment; filename=" + fileName);
        head.setContentDispositionFormData(fileName, fileName);
        head.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return head;
    }
}
