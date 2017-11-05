package com.realdolmen.repository.storage.impl;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.Storage;
import com.realdolmen.repository.storage.api.StorageResult;
import com.realdolmen.util.Logger;
import com.realdolmen.util.LoggerImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FileStorage implements Storage {

    private static String STORAGE;

    private LoggerImpl logger;

    private FileStorage(String path) {
        STORAGE = path;
        logger = new LoggerImpl();
    }

    public static FileStorage create(String path) {
        return new FileStorage(path);
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

    @Override
    public <T extends DevlabsEntity> List<T> findAll(Class<T> clazz) {
        try {
            return Files.walk(Paths.get(STORAGE))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(name -> {
                        try {
                            return new FileInputStream(name);
                        } catch (FileNotFoundException e) {
                            logger.log(e.getMessage(), e);
                        }
                        return null;
                    })
                    .map(in -> {
                        try {
                            return new ObjectInputStream(in);
                        } catch (IOException e) {
                            logger.log(e.getMessage(), e);
                        }
                        return null;
                    })
                    .map(objectInputStream -> {
                        try {
                            return objectInputStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            logger.log(e.getMessage(), e);
                        }
                        return null;
                    })
                    .filter(clazz::isInstance)
                    .map(clazz::cast)
                    .sorted(Comparator.comparing(DevlabsEntity::getId))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clear() throws IOException {
        Files.walk(Paths.get(STORAGE))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);
    }
}
