package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchUuid = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchUuid);
    }

    protected void saveToArray(Resume resume, int index) {
        int indexId = -index - 1;
        System.arraycopy(storage, indexId, storage, indexId + 1, size - indexId);
        storage[indexId] = resume;
    }

    protected void deleteFromArray(int index) {
        if(size - index - 1 > 0) {
            int indexId = index + 1;
            System.arraycopy(storage, indexId, storage, indexId - 1, size - indexId);
        }
    }
}
