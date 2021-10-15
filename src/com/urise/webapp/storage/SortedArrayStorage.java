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
        System.arraycopy(resume, -index - 1, resume, -index, size + index - 1);
        storage[-index - 1] = resume;
    }
}
