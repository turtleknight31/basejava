import java.util.Arrays;
import java.lang.String;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume r) {
        int i = 0;
        if(r.uuid != null) {
            do {
                storage[i] = r;
                i++;
            } while (storage[size] == null);
        }
        size = i;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            } else if(storage[size] == null) {
                System.out.println(uuid + "uuid Не найден");
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                if (storage.length - 1 - i >= 0) 
                    System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);
            } else {
                System.out.println("Резюме не было найдено!");
           }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
