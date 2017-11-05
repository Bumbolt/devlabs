package com.realdolmen.repository;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.StorageResult;

import java.util.UUID;

public class TestEntity implements DevlabsEntity {

    private UUID id;
    private String testField;

    private TestEntity() {
        id = UUID.randomUUID();
    }

    public static TestEntity create() {
        return new TestEntity();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public StorageResult save() {
        return null;
    }

    @Override
    public StorageResult delete() {
        return null;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public String getTestField() {
        return testField;
    }
}
