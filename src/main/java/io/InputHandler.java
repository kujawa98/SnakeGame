package io;

import snake.Directions;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public Directions getDirection(Directions currentDirection) {
        try {
            String dirSymb = scanner.nextLine();
            Directions newDir = Directions.getDirection(dirSymb);
            return newDir;
        } catch (IllegalArgumentException ac) {
            return currentDirection;
        }
    }

    public void close() {
        scanner.close();
    }
}
