package com.realdolmen.repository.storage.impl;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.NeverPersistedEntity;
import com.realdolmen.repository.TestEntity;
import com.realdolmen.repository.storage.api.StorageResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileStorageTest {

    private FileStorage storage;
    private TestEntity entity;

    @Before
    public void setUp() {
        storage = FileStorage.create("./teststorage/");
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

    @Test
    public void findAll_returnsAList() throws Exception {
        createEntities();

        List<TestEntity> result = storage.findAll(TestEntity.class);

        assertNotNull(result);
    }

    @Test
    public void findAll_returnsAFilledList() throws Exception {
        List<TestEntity> expected = createEntities();

        List<TestEntity> result = storage.findAll(TestEntity.class);

        assertEquals(expected.size(), result.size());
    }

    @Test
    public void findAll_returnsInstancesOfRequestedClass() throws Exception {
        List<TestEntity> expectedList = createEntitiesOrdered();

        List<TestEntity> result = storage.findAll(TestEntity.class);

        assertEntityId(expectedList.get(0), result.get(0));
        assertEntityId(expectedList.get(1), result.get(1));
        assertEntityId(expectedList.get(2), result.get(2));
    }

    @Test
    public void findAll_returnsEmptyListForWrongClass() throws Exception {
        createEntitiesOrdered();

        List<NeverPersistedEntity> result = storage.findAll(NeverPersistedEntity.class);

        assertEquals(0, result.size());
    }

    @After
    public void cleanUp() throws IOException {
        storage.clear();
    }

    private void assertEntityId(TestEntity expected, TestEntity entity) {
        assertEquals(expected.getId(), entity.getId());
    }

    private void assertEntity(TestEntity entity, DevlabsEntity entityResult) {
        assertEquals(entity.getId(), entityResult.getId());
        assertEquals(entity.getTestField(), "TEST");
    }

    private List<TestEntity> createEntitiesOrdered() {
        List<TestEntity> expectedList = createEntities();
        expectedList.sort(Comparator.comparing(TestEntity::getId));
        return expectedList;
    }

    private List<TestEntity> createEntities() {
        ArrayList<TestEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            entityList.add(createPersistedEntity());
        }
        return entityList;
    }

    private TestEntity createPersistedEntity() {
        TestEntity entity = createEntity();
        storage.save(entity);
        return entity;
    }

    private TestEntity createEntity() {
        TestEntity entity = TestEntity.create();
        entity.setTestField("TEST");
        return entity;
    }
}
