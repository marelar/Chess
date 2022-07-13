public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (new Bishop(this.getColor()).canMoveToPosition(chessBoard, line, column, toLine, toColumn) ||
                new Rook(this.getColor()).canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}
