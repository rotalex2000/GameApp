import java.util.ArrayList;

public class Pawn {

    private int[] position;
    private Board board;
    private ArrayList<int[]> backup = new ArrayList<>();
    private String backupMove;

    public Pawn(Board board, int[] position) {
        this.board = board;
        this.position = position;
        this.backup.add(this.position);
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void move(String direction) {
        switch(direction) {
            case "l":
                if (this.position[1] == 0) {
                    System.out.println("Edge.");
                } else {
                    this.moveLeft();
                    this.backup.add(this.position);
                    this.backupMove = "l";
                    board.updateBoard();
                    board.drawBoard();
                }
                break;
            case "r":
                if (this.position[1] == 7) {
                    System.out.println("Edge.");
                } else {
                    this.moveRight();
                    this.backup.add(this.position);
                    this.backupMove = "r";
                    board.updateBoard();
                    board.drawBoard();
                }
                break;
            case "u":
                if (this.position[0] == 0) {
                    System.out.println("Edge.");
                } else {
                    this.moveUp();
                    this.backup.add(this.position);
                    this.backupMove = "u";
                    board.updateBoard();
                    board.drawBoard();
                }
                break;
            case "d":
                if (this.position[0] == 7) {
                    System.out.println("Edge.");
                } else {
                    this.moveDown();
                    this.backup.add(this.position);
                    this.backupMove = "d";
                    board.updateBoard();
                    board.drawBoard();
                }
                break;
            case "repeat":
                this.move(this.backupMove);
                break;
            case "revert":
                this.moveAt(this.backup.get(this.backup.size() - 2));
                this.backup.add(this.backup.get(this.backup.size() - 2));
                board.updateBoard();
                board.drawBoard();
                break;
            default:
                System.out.println("Please enter a valid direction.");
        }
    }

    private void moveAt(int[] position) {
        this.position = position;
        this.backup.add(position);
    }

    private void moveLeft() {
        this.position = new int[]{this.position[0], this.position[1] - 1};
    }

    private void moveRight() {
        this.position = new int[]{this.position[0], this.position[1] + 1};
    }

    private void moveUp() {
        this.position = new int[]{this.position[0] - 1, this.position[1]};
    }

    private void moveDown() {
        this.position = new int[]{this.position[0] + 1, this.position[1]};
    }

    public boolean hasArrived() {
        return this.position[0] == 0;
    }
}
