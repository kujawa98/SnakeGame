package board;

import food.Food;
import snake.Part;
import snake.Snake;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static int INITIAL_WIDTH = 6;
    public static int INITIAL_HEIGHT = 6;

    private final Map<Point, Part> pointPartMap = new HashMap<>();
    private final Map<Point, Food> pointFoodMap = new HashMap<>();
//    TODO: availablePoints będzie tworzona za każdym razem tylko i wyłącznie podczas losowania miejsca na jedzenie


    public Board(Snake snake) {
        putSnakeOnBoard(snake);
    }

    public void putSnakeOnBoard(Snake snake){
        pointPartMap.clear();
        for (Part part : snake.getSingleParts()) {
            Point point = part.getCurrentPoint();
            pointPartMap.put(point, part);
        }
    }
    
//    Test
    private void printPointPartMap(){
        for(Map.Entry<Point,Part> entry : pointPartMap.entrySet()){
            System.out.println(entry.getKey().getX()+" "+entry.getKey().getY());
        }
    }

    public static void main(String[] args) {
        Snake snake = new Snake();
        Board brd = new Board(snake);

        brd.printPointPartMap();
        snake.move();
        brd.putSnakeOnBoard(snake);
        System.out.println();
        brd.printPointPartMap();

//        brd.printPointPartMap();
//        TODO: cykl wygląda tak: map.reload -> snake.move i tak w koło Macieju

    }
}
