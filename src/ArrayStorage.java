import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    Resume res = new Resume();

    void clear() {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        int i = 0;
         do {
            storage[i] = r;
            i++;
         } while(storage[i] == null);
        res.setSize(i);
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
                if (storage.length - 1 - i >= 0) 
                    System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, res.getSize());
    }

    int size() {
        return res.getSize();
    }
}
