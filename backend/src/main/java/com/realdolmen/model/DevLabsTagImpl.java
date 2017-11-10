package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

public class DevLabsTagImpl extends DevlabsEntityImpl implements DevLabsTag {

    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 13;
        for (char nameCharacter : name.toCharArray()) {
            result += 37 * result + nameCharacter;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && DevLabsTagImpl.class.isAssignableFrom(obj.getClass()) && this.name.equals(((DevLabsTagImpl) obj).name);
    }
}
