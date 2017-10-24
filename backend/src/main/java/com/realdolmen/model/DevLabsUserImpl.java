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

    // Custom hashCode implementation for Set usage
    @Override
    public int hashCode() {
        int result = 11;

        for (char nameCharacter : name.toCharArray()) {
            result += 31 * result + nameCharacter;
        }

        return result;
    }

    // Custom equals implementation for Set usage
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!DevLabsUserImpl.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final DevLabsUserImpl other = (DevLabsUserImpl) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }

        return true;
    }
}
