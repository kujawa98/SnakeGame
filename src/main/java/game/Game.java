package game;

import board.Board;
import io.InputHandler;
import lombok.Getter;
import snake.Directions;
import snake.Snake;

@Getter
public final class Game {
    private final Snake snake;
    private final Board gameBoard;
    private boolean isOver = false;

    private final InputHandler inputHandler;

    public Game() {
        this.snake = new Snake();
        this.gameBoard = new Board(this.snake);
        this.inputHandler = new InputHandler();
    }

    public void gameLoop() {
        do {
//            TODO: na początku printujemy mapkę, jakaś klasa MapPrinter etc
            Directions newDirection = inputHandler.getDirection(this.snake.getDirection());
            this.snake.move();
            this.gameBoard.putSnakeOnBoard(this.snake);
            isOver = statusChecker.checkIfIsOver();
        } while (!isOver);

    }
}
