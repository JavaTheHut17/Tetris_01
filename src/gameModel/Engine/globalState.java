package gameModel.Engine;

public class globalState {
    private static globalState instance;
    public boolean currentGameState = false; // Non-static, but part of the Singleton instance

    // Private constructor to prevent creating multiple instances
    private globalState() {}

    // Get the Singleton instance
    public static globalState getInstance() {
        if (instance == null) {
            instance = new globalState();
        }
        return instance;
    }
}
