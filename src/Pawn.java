public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!checkNewPosition(chessBoard, line, column, toLine, toColumn)) return false;

        if (column == toColumn) {
            if (chessBoard.board[toLine][toColumn] == null) {
                if (chessBoard.board[line][column].getColor().equals("White")) {
                    if (line + 1 == toLine) return true;               //  move forward to square
                    if (line == 1 && (line + 2 == toLine))             // on its first move it can advance two squares
                        return true;
                }

                if (chessBoard.board[line][column].getColor().equals("Black")) {
                    if (line - 1 == toLine) return true;
                    if (line == 6 && (line - 2 == toLine)) return true;
                }
            } else return false;
        } else if (column == toColumn - 1 || column == toColumn + 1) {
            if (chessBoard.board[toLine][toColumn] != null) {
                if (chessBoard.board[line][column].getColor().equals("White")) {
                    if (line + 1 == toLine) return true;
                }

                if (chessBoard.board[line][column].getColor().equals("Black")) {
                    if (line - 1 == toLine) return true;
                }
            } else return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

