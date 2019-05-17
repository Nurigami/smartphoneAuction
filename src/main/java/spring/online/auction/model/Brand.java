package spring.online.auction.model;

import java.util.HashMap;
import java.util.Map;

public enum Brand {
    Samsung(1), Apple(2), Motorola(3),Huawei(4);

    private int value;
    private static Map map = new HashMap<>();

    private Brand(int value) {
        this.value = value;
    }

    static {
        for (Brand brand : Brand.values()) {
            map.put(brand.value, brand);
        }
    }

    public static Brand valueOf(int brand) {
        return (Brand) map.get(brand);
    }

    public int getValue() {
        return value;
    }
}
