package gameModel.Engine.Factory_Tetromino;

public class squarePieceFactory implements tetrominoFactory {
    public Tetromino_Gen buildTetromino() {
        return new squarePiece();
    }
}
