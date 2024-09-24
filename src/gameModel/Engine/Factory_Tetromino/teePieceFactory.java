package gameModel.Engine.Factory_Tetromino;

public class teePieceFactory implements tetrominoFactory {
    public Tetromino_Gen buildTetromino() {
        return new teePiece();
    }
}
