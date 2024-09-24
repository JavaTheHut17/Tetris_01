package gameModel.Engine.Factory_Tetromino;

public class zPieceFactory implements tetrominoFactory {
    public Tetromino_Gen buildTetromino() {
        return new zPiece();
    }
}
