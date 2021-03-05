package su.nepom.patterns.home1.model.object;

import su.nepom.patterns.home1.model.UObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UObjectImpl implements UObject {
    private final Map<Class<?>, Object> impl = new HashMap<>();

    public UObjectImpl(Part ... parts) {
        for (var part : parts)
            for (var cls : part.canQueryAs())
                impl.put(cls, part);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> queryInterface(Class<T> cls) {
        return Optional.ofNullable((T)impl.get(cls));
    }
}
