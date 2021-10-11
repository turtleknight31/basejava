package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Данное резюме" + r.getUuid() + " уже существует в базе!");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Резюме переполнилась, добавить новое резюме не получится!");
        } else {
            size++;
            for (int i = 0; i < size - insertionNumber(r); i++) {
                storage[size - i] = storage[size - i - 1];
            }
            storage[insertionNumber(r)] = r;
        }
    }

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
