package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

public class DevLabsTagImpl extends DevlabsEntityImpl implements DevLabsTag {
    private String name;

    public DevLabsTagImpl() {
    }

    public DevLabsTagImpl(String name) {
        this.name = name;
    }

    @Override
    public StorageResult save() {
        return StorageResult.ERROR;
    }

    @Override
    public StorageResult delete() {
        return StorageResult.ERROR;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
