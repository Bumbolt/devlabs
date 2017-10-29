package com.realdolmen.repository.storage.impl;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.StorageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileStorageTest {

    @Test
    public void saveShouldCreateAFile() {
        FileStorage storage = new FileStorage();
        TestEntity entity = new TestEntity();

        StorageResult result = storage.save(entity);

        assertEquals(StorageResult.OK, result);
    }

    @Test
    public void saveShouldBeAbleToSaveSameObjectTwice() {
        FileStorage storage = new FileStorage();
        TestEntity entity = new TestEntity();

        storage.save(entity);
        StorageResult result = storage.save(entity);

        assertEquals(StorageResult.OK, result);
    }

    @Test
    public void findShouldFindAnExistingObject() {
        FileStorage storage = new FileStorage();
        TestEntity entity = new TestEntity();
        storage.save(entity);

        DevlabsEntity entityResult = storage.find(entity.getId());

        assertEquals(entity.getId(), entityResult.getId());
    }

}
