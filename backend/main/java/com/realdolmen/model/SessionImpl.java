package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

public class SessionImpl extends DevlabsEntityImpl implements Session {
    private String name;

    public SessionImpl(String name) {
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
