public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {


        if (!checkNewPosition(chessBoard, line, column, toLine, toColumn)) return false;

        if ((column == toColumn) || (line == toLine)) {         // move any number of squares along a rank or file
            if (!IsPieceOnTheWay(chessBoard, line, column, toLine, toColumn)) {
                this.check = false;
                return true;
            }
        }
        return false;
    }

    private boolean IsPieceOnTheWay(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isPieceOnTheWay = false;

        if (column < toColumn) {
            for (int i = column + 1; i < toColumn; i++) {
                if (chessBoard.board[line][i] != null) {
                    isPieceOnTheWay = true;
                    break;
                }
            }
        } else if (column > toColumn) {
            for (int i = toColumn + 1; i < column; i++) {
                if (chessBoard.board[line][i] != null) {
                    isPieceOnTheWay = true;
                    break;
                }
            }
        } else if (line < toLine) {
            for (int i = line + 1; i < toLine; i++) {
                if (chessBoard.board[i][column] != null) {
                    isPieceOnTheWay = true;
                    break;
                }
            }
        } else if (line > toLine) {
            for (int i = toLine + 1; i < line; i++) {
                if (chessBoard.board[i][column] != null) {
                    isPieceOnTheWay = true;
                    break;
                }
            }
        }
        if (isPieceOnTheWay) System.out.println("Piece on the way!");
        return isPieceOnTheWay;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

}
