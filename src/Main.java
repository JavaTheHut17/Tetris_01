//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import gameModel.Engine.GameTime;
import ui.Screens.SplashScreen;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        GameTime gameTimer = GameTime.getInstance();
        gameTimer.startTime();
//        Thread.sleep(5000);
        gameTimer.gameDuration();
        //Splash Screen Show and Hide
        SplashScreen splashScreen = new SplashScreen(1);
        splashScreen.ShowSplash();
        splashScreen.SplashScreenExit();




    }


}