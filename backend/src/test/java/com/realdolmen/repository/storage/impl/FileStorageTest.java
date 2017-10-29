package com.realdolmen.repository.storage.impl;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.StorageResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileStorageTest {

    private FileStorage storage;
    private TestEntity entity;

    @Before
    public void setUp() {
        storage = new FileStorage();
        storage.setStoragePath("./teststorage/");

        entity = createEntity();
    }

    @Test
    public void save_createsFile() {
        StorageResult result = storage.save(entity);

        assertEquals(StorageResult.OK, result);
    }

    @Test
    public void save_savesSameObjectTwice() {
        storage.save(entity);
        StorageResult result = storage.save(entity);

        assertEquals(StorageResult.OK, result);
    }

    @Test
    public void find_returnsExistingObject() {
        storage.save(entity);

        DevlabsEntity entityResult = storage.find(entity.getId());

        assertEntity(entity, entityResult);
    }

    @Test
    public void delete_removesExistingObject() {
        storage.save(entity);

        StorageResult result = storage.delete(entity);

        assertEquals(StorageResult.OK, result);
        assertNull(storage.find(entity.getId()));
    }

    @After
    public void cleanUp() {
        cleanUpEntity(entity);
    }

    private TestEntity createEntity() {
        TestEntity entity = new TestEntity();
        entity.setTestField("TEST");
        return entity;
    }

    private void assertEntity(TestEntity entity, DevlabsEntity entityResult) {
        assertEquals(entity.getId(), entityResult.getId());
        assertEquals(entity.getTestField(), "TEST");
    }

    private void cleanUpEntity(TestEntity entity) {
        storage.delete(entity);
    }
}
