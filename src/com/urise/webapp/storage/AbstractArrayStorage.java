package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    public Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

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

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        }
        return storage[index];
    }

    protected abstract int findIndex(String uuid);

    protected abstract int insertionNumber(Resume resume);
}
