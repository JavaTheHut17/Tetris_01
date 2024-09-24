package gameModel.Engine.Factory_Tetromino;

public class linePieceFactory implements tetrominoFactory{
    public Tetromino_Gen buildTetromino() {
        return new linePiece();
    }
}
