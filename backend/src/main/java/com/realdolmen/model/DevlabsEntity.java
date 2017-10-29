package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;
import java.io.Serializable;
import java.util.UUID;

public interface DevlabsEntity extends Serializable {
    UUID getId();

    StorageResult save();
    StorageResult delete();
}
