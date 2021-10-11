package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме " + uuid + " не существует");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Резюме " + resume.getUuid() + " не существует");
        } else {
            storage[index] = resume;
        }
    }

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
