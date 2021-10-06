package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        boolean existResume = true;
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                System.out.println("Данное резюме уже существует в базе!");
                existResume = false;
            }
        }
        if (existResume && r.getUuid() != null && size < 10000) {
            storage[size] = r;
            size++;
        } else if (size > 9999) {
            System.out.println("Резюме переполнилась, добавить новое резюме не получится!");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid().equals(storage[i].getUuid())) {
                storage[i] = resume;
            }
        }
    }
}
