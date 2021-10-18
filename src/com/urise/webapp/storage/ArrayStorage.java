package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {
    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveToArray(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    protected void deleteFromArray(int index) {
        storage[index] = storage[size - 1];
    }
}
