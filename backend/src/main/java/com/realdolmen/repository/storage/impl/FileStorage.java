package com.realdolmen.repository.storage.impl;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.Storage;
import com.realdolmen.repository.storage.api.StorageResult;
import com.realdolmen.util.LoggerImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileStorage implements Storage {

    private static final String STORAGE = "./storage/";

    private LoggerImpl logger;

    FileStorage() {
        this.logger = new LoggerImpl();
    }

    @Override
    public StorageResult save(DevlabsEntity entity) {

        try {
            Path path = Paths.get(STORAGE + entity.getId() + ".devlabs");
            Files.deleteIfExists(path);
            Files.createDirectories(path.getParent());
            Files.createFile(path);

            FileOutputStream fos = new FileOutputStream(path.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entity);
            return StorageResult.OK;
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Error while saving entity with id=" + entity.getId(), e);
            return StorageResult.ERROR;
        }
    }

    @Override
    public StorageResult delete(DevlabsEntity entity) {
        try {
            Path path = Paths.get(STORAGE + entity.getId() + ".devlabs");
            Files.deleteIfExists(path);
            return StorageResult.OK;
        } catch (IOException e) {
            logger.log("Error while deleting entity with id=" + entity.getId(), e);
            return StorageResult.ERROR;
        }
    }

    @Override
    public DevlabsEntity find(UUID id) {

        try {
            FileInputStream fin = new FileInputStream(STORAGE + id + ".devlabs");
            ObjectInputStream objectInputStream = new ObjectInputStream(fin);
            return (DevlabsEntity) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.log("Error while attempting to find entity with id=" + id);
        }
        return null;
    }
}
