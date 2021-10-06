import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        boolean existResume = true;
        for (int i = 0; i < size; i++) {
            if(r.uuid.equals(storage[i].uuid)) {
                System.out.println("Данное резюме уже существует в базе!");
                existResume = false;
            }
        }
        if(existResume && r.uuid != null && size < 10000) {
            storage[size] = r;
            size++;
        } else if(size > 9999) {
            System.out.println("Резюме переполнилась, добавить новое резюме не получится!");
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[i] = null;
                size--;
           }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    void update(Resume resume)  {
        for(int i = 0; i < size; i++) {
            if (resume.uuid.equals(storage[i].uuid)) {
                storage[i] = resume;
            }
        }
    }
}
