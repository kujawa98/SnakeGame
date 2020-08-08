package snake;

import board.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;


@Getter
@AllArgsConstructor
public class Snake {
    public static final int INITIAL_HEAD_X = 3;
    public static final int INITIAL_HEAD_Y = 3;
    public static final int INITIAL_LENGTH = 3;

    private final Part head;
    private final List<Part> singleParts = new LinkedList<>();
    private Directions direction = Directions.UP;

    public Snake() {
        Point headPoint = new Point(INITIAL_HEAD_X, INITIAL_HEAD_Y);
        this.head = new Part(headPoint);
        singleParts.add(this.head);
        for (int i = 1; i < INITIAL_LENGTH; i++) {
            Point pt = new Point(INITIAL_HEAD_X, INITIAL_HEAD_Y + i);
            Part prt = new Part(pt);
            singleParts.add(prt);
        }
    }

    public void move() {
        for (int i = singleParts.size() - 1; i > 0; i--) {
            Point newPoint = singleParts.get(i - 1).getCurrentPoint();
            singleParts.get(i).moveToNewPoint(newPoint);
        }

        switch (this.direction) {
            case UP -> head.moveYOnly(-1);
            case DOWN -> head.moveYOnly(1);
            case LEFT -> head.moveXOnly(-1);
            case RIGHT -> head.moveXOnly(1);
        }
    }

    public void changeDirection(Directions direction) {
        if (direction.getId() - this.direction.getId() != 0) {
            this.direction = direction;
        }
    }

    public void eat(){

    }

    public void printSnake() {
        for (Part p : singleParts) {
            System.out.println(p.getCurrentPoint().getX() + " " + p.getCurrentPoint().getY());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Snake s = new Snake();

        s.printSnake();
        s.move();
        s.printSnake();
    }
}
