public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!checkNewPosition(chessBoard, line, column, toLine, toColumn)) return false;
        // horse' move forms an "L"-shape
        if ((((line + 1 == toLine) || (line - 1 == toLine)) &&                  // 1 square horizontally
                ((column + 2 == toColumn) || (column - 2 == toColumn)))         // and 2 squares vertically
                || (((line + 2 == toLine) || (line - 2 == toLine)) &&           // or 2 squares horizontally
                ((column + 1 == toColumn) || (column - 1 == toColumn)))) {      // and 1 square vertically
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
