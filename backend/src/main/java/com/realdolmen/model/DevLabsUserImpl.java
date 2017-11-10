package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

public class DevLabsUserImpl extends DevlabsEntityImpl implements DevLabsUser {
    private String name;

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


    @Override
    public int hashCode() {
        int result = 11;
        for (char nameCharacter : name.toCharArray()) {
            result += 31 * result + nameCharacter;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && DevLabsUserImpl.class.isAssignableFrom(obj.getClass()) && this.name.equals(((DevLabsUserImpl) obj).name);
    }
}
