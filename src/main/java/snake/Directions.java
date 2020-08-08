package snake;

import java.util.HashMap;
import java.util.Map;

public enum Directions {
    UP(-1), DOWN(1), LEFT(-2), RIGHT(2);

    private int id;

    Directions(int id) {
        this.id = id;
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

    public static Directions getDirection(String st){
        switch (st){
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
}
