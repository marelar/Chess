public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!checkNewPosition(chessBoard, line, column, toLine, toColumn)) return false;

        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) { // moves one square in any direction

            if (!this.isUnderAttack(chessBoard, line, column, toLine, toColumn)) {
                this.check = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column, int toLine, int toColumn) {
        ChessPiece tempPiece = null;        // simulate situation when the king has already moved
        // to new position for canMoveToPosition method's correct work
        if (board.board[toLine][toColumn] != null) {
            tempPiece = board.board[toLine][toColumn];
        }
        board.board[toLine][toColumn] = board.board[line][column];
        board.board[line][column] = null;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !this.getColor().equals(board.board[i][j].getColor())) {
                    if (board.board[i][j].getSymbol().equals("K") &&           // kings can't stay on adjacent squares
                            (Math.abs(i - toLine) <= 1 && Math.abs(j - toColumn) <= 1)) {
                        System.out.println("kings can't stay on adjacent squares");

                        board.board[line][column] = board.board[toLine][toColumn]; // return pieces to original state
                        board.board[toLine][toColumn] = tempPiece;
                        return true;
                    }
                    if (board.board[i][j].canMoveToPosition(board, i, j, toLine, toColumn)) {
                        System.out.println("You can't make a move that puts or leaves your king in check");

                        board.board[line][column] = board.board[toLine][toColumn];
                        board.board[toLine][toColumn] = tempPiece;
                        return true;
                    }
                }
            }
        }
        board.board[line][column] = board.board[toLine][toColumn];
        board.board[toLine][toColumn] = tempPiece;
        return false;
    }
}
