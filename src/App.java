import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Board board = new Board();
        Pawn pawn = new Pawn(board, new int[]{7, 4});

        board.initializePawn(pawn);
        board.updateBoard();
        board.drawBoard();

        while (true) {
            System.out.println("Move pawn (l, r, u, d, repeat, revert):");
            String direction = reader.readLine();

            pawn.move(direction);

            if (pawn.hasArrived()) {
                System.out.println("Game finished.");
                break;
            }
        }


    }
}