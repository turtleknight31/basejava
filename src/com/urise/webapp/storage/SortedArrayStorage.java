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

    protected int insertionNumber(Resume resume) {
        return -findIndex(resume.getUuid()) - 1;
    }
}
