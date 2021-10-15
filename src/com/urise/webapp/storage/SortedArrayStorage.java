package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchUuid = new Resume();
        searchUuid.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchUuid);
    }

    protected void insertionNumber(Resume resume, int index) {
        int indexId = -index - 1;
        System.arraycopy(storage, indexId, storage, indexId + 1, size - indexId);
        storage[-index - 1] = resume;
    }

    protected void deleteNumber(int index) {
        int indexId = index + 1;
        System.arraycopy(storage, indexId, storage, indexId - 1, size - indexId);
    }
}
