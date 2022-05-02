package maps;

import example.maps.Maps;

import java.util.Map;

public class MapsMain {
    private static Maps.IdWrapper newIdWrapper(int id) {
        return Maps.IdWrapper.newBuilder().setId(id).build();
    }

    public static void main(String[] args) {
        Maps.MapExample message = Maps.MapExample.newBuilder()
                .putIds("One", newIdWrapper(1))
                .putIds("Two", newIdWrapper(2))
                .putAllIds(Map.of(
                        "Three", newIdWrapper(3),
                        "Four", newIdWrapper(4)
                ))
                .build();

        System.out.println(message);
    }
}
