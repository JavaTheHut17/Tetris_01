package gameModel.Engine;
import java.time.Instant;

public class GameTime {

    private static GameTime instance;

    private long  currentStartTime;

    private GameTime() {
        currentStartTime = Instant.now().getEpochSecond();
    }

    public static GameTime getInstance() {
        if (instance == null) {
            instance = new GameTime();
        }
        return instance;
    }

    public long startTime(){
       currentStartTime = Instant.now().getEpochSecond();
       System.out.println("start time: " + currentStartTime / 1000000000);
       return currentStartTime;
    }

    public long gameDuration(){
        long now = Instant.now().getEpochSecond();
        long CurrentDuration = now - currentStartTime;
        System.out.println("current duration: " + CurrentDuration );
        return CurrentDuration ;
    };




    
}
