package gameModel.Engine.Factory_Tetromino;

public class lPieceFactory implements tetrominoFactory {
    public Tetromino_Gen buildTetromino() {
        return new lPiece();
    }
}
