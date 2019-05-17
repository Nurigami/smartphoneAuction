package spring.online.auction.model;

import java.util.HashMap;
import java.util.Map;

public enum OpSystem {
    Android(1), iOS(2), Blackberry(3),Windows(4);

    private int value;
    private static Map map = new HashMap<>();

    private OpSystem(int value) {
        this.value = value;
    }

    static {
        for (OpSystem opSystem : OpSystem.values()) {
            map.put(opSystem.value, opSystem);
        }
    }

    public static OpSystem valueOf(int opSystem) {
        return (OpSystem) map.get(opSystem);
    }

    public int getValue() {
        return value;
    }
}
