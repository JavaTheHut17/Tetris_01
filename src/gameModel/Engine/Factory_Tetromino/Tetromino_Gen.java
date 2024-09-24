package gameModel.Engine.Factory_Tetromino;

public abstract class Tetromino_Gen {

    public abstract int[][] createTetromino();

}

class linePiece extends Tetromino_Gen {
    public int[][] createTetromino() {
        return new int[][] {{1,1,1,1}};
    }
}

class lPiece extends Tetromino_Gen {
    public int[][] createTetromino() {
       return new int[][] { {1,0,0,0},{1,1,1,1} };
    }
}

class squarePiece extends Tetromino_Gen {
    public int[][] createTetromino() {
       return new int[][] { {1,1},{1,1} };
    }
}

class teePiece extends Tetromino_Gen {
    public int[][] createTetromino() {
       return new int[][] { {0,1,0},{1,1,1} };
    }
}
class zPiece extends Tetromino_Gen {
    public int[][] createTetromino() {
        return new int[][] { {1,1,0},{0,1,1} };
    }
}



