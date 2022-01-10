import java.util.Arrays;

public class Board {
    private final int[][] board = new int[][]{{}, {}, {}, {}, {}, {}, {}, {}};
    private Pawn pawn;

    public Board() {
    }

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            this.board[i] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
        this.board[pawn.getPosition()[0]][pawn.getPosition()[1]] = 1;
    }

    public void initializePawn(Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public String toString() {
        StringBuilder ui = new StringBuilder();
        for (int[] row : board) {
            ui.append(Arrays.toString(row)).append("\n");
        }
        return ui.toString();
    }

    public void drawBoard() {
        System.out.println(this);
    }
}
