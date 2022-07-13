public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!checkNewPosition(chessBoard, line, column, toLine, toColumn)) return false;

        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {   // can move any number of squares diagonally
            if (!IsPieceOnTheWay(chessBoard, line, column, toLine, toColumn)) {
                return true;
            }
        }
        return false;
    }

    private boolean IsPieceOnTheWay(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isPieceOnTheWay = false;

        if (column < toColumn) {
            if (line < toLine) {
                for (int i = 1; i < toLine - line; i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        isPieceOnTheWay = true;
                        break;
                    }
                }
            } else if (line > toLine) {
                for (int i = 1; i < line - toLine; i++) {
                    if (chessBoard.board[line - i][column + i] != null) {
                        isPieceOnTheWay = true;
                        break;
                    }
                }
            }
        } else if (column > toColumn) {
            if (line < toLine) {
                for (int i = 1; i < toLine - line; i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        isPieceOnTheWay = true;
                        break;
                    }
                }
            } else if (line > toLine) {
                for (int i = 1; i < line - toLine; i++) {
                    if (chessBoard.board[line - i][column - i] != null) {
                        isPieceOnTheWay = true;
                        break;
                    }
                }
            }
        }
        if (isPieceOnTheWay) System.out.println("Piece on the way!");

        return isPieceOnTheWay;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

}
