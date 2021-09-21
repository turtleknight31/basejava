import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if(r.uuid != null) {
            storage[size] = r;
            size++;
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
                storage[i] = null;
                if (size - 1 - i >= 0)
                    System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                    size--;
            } else {
                System.out.println("Резюме не было найдено!");
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
}
