package com.realdolmen.repository.storage.api;

import com.realdolmen.model.DevlabsEntity;

import java.util.UUID;

public interface Storage {

    StorageResult save(DevlabsEntity entity);
    StorageResult delete(DevlabsEntity entity);

    DevlabsEntity find(UUID id);

}