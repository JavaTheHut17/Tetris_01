package gameModel.Engine;

public class globalState {
    private static globalState instance;
    public boolean currentGameState = false;

    private globalState() {}

    public static globalState getInstance() {
        if (instance == null) {
            instance = new globalState();
        }
        return instance;
    }
}
