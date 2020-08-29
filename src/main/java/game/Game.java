package game;

import logic.board.Board;
import io.InputHandler;
import lombok.Getter;
import logic.snake.Directions;
import logic.snake.Snake;

@Getter
public final class Game {
    private final Snake snake;
    private final Board gameBoard;
    private boolean isOver = false;

    private final InputHandler inputHandler;
    private final StatusChecker statusChecker;

    public Game() {
        this.snake = new Snake();
        this.gameBoard = new Board(this.snake);
        this.inputHandler = new InputHandler();
        this.statusChecker = new StatusChecker();
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
