package com.realdolmen.repository.storage.api;

import com.realdolmen.model.DevlabsEntity;

public interface Storage {
    StorageResult save(DevlabsEntity entity);
    StorageResult delete(DevlabsEntity entity);
    StorageResult find(DevlabsEntity entity);
}