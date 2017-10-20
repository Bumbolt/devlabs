package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

public class DevLabsUserImpl extends DevlabsEntityImpl implements DevLabsUser {
    private String name;

    public DevLabsUserImpl(String name) {
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
        return name;
    }
}
