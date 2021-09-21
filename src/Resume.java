/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;
    int size;

    @Override
    public String toString() {
        return uuid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
