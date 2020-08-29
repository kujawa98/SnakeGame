package logic.snake;

import java.util.HashMap;
import java.util.Map;

public enum Directions {
    UP(-1, "gora"), DOWN(1, "dol"), LEFT(-2, "lewo"), RIGHT(2, "prawo");

    private int id;
    private String sign;

    Directions(int id, String sign) {
        this.id = id;
        this.sign = sign;
    }

    private static final Map<Integer, Directions> map;

    static {
        map = new HashMap<Integer, Directions>();
        for (Directions v : Directions.values()) {
            map.put(v.id, v);
        }
    }

    public static Directions findByID(int id) {
        return map.get(id);
    }

    public static Directions getDirection(String st) {
        switch (st) {
            case "w" -> {
                return UP;
            }
            case "s" -> {
                return DOWN;
            }
            case "d" -> {
                return RIGHT;
            }
            case "a" -> {
                return LEFT;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getSign() {
        return sign;
    }
}
