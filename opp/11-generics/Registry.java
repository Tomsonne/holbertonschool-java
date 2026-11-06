import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Registry<T extends Identifiable> {
    private final Map<String, T> items = new TreeMap<>();

    public void register(T item) {
        if (item == null) {
            throw new IllegalArgumentException(
                "Item must not be null"
            );
        }

        String id = item.getId();

        if (items.containsKey(id)) {
            throw new IllegalArgumentException(
                "Duplicate id: " + id
            );
        }

        items.put(id, item);
    }

    public T get(String id) {
        return items.get(id);
    }

    public boolean contains(String id) {
        return items.containsKey(id);
    }

    public T unregister(String id) {
        return items.remove(id);
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(items.values());
    }
}