package logic.snake;

import logic.board.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Part {
    private Point currentPoint;

    public void moveToNewPoint(Point newPoint) {
        int x = newPoint.getX();
        int y = newPoint.getY();
        currentPoint = new Point(x, y);
    }

    public void moveXOnly(int length) {
        int x = currentPoint.getX() + length;
        int y = currentPoint.getY();
        currentPoint = new Point(x, y);
    }

    public void moveYOnly(int length) {
        int x = currentPoint.getX();
        int y = currentPoint.getY() + length;
        currentPoint = new Point(x, y);
    }   
}
