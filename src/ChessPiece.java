abstract public class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

    public boolean checkNewPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!(toLine >= 0 && toLine <= 7) || !(toColumn >= 0 && toColumn <= 7)) return false; // can't go out board

        if (line == toLine && column == toColumn) return false;                               // can't "don't move"

        if (chessBoard.board[toLine][toColumn] == null) return true;        // move to either an unoccupied square
        else {                                                       //  is square occupied by an opponent's piece
            if (!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                return true;
            } else return false;
        }
    }

}

