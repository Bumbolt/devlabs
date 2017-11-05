package com.realdolmen.repository.storage.api;

import com.realdolmen.model.DevlabsEntity;

import java.util.List;
import java.util.UUID;

public interface Storage {

    StorageResult save(DevlabsEntity entity);

    StorageResult delete(DevlabsEntity entity);

    DevlabsEntity find(UUID id);

    <T extends DevlabsEntity> List<T> findAll(Class<T> clazz);

}