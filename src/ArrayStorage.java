import java.util.Arrays;
import java.util.Scanner;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
         do {
            storage[i] = r;
            i++;
         } while(storage[i] == null);
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                for(int j = i; j < storage.length - 1; j++) {
                    storage[j] = storage[j + 1];
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                i++;
            }
            count = i;
        }
        return count;
    }
}
