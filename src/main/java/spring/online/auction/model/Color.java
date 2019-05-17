package spring.online.auction.model;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    Black(1), White(2), Silver(3), Gold(4), Red(5), Blue(6), Other(7);

    private int value;
    private static Map map = new HashMap<>();

    private Color(int value) {
        this.value = value;
    }

    static {
        for (Color color : Color.values()) {
            map.put(color.value, color);
        }
    }

    public static Color valueOf(int color) {
        return (Color) map.get(color);
    }

    public int getValue() {
        return value;
    }
}
