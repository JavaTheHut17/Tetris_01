//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import ui.MainFrame;
import ui.Screens.SplashScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Main {
    public static void main(String[] args) {


        //Splash Screen Show and Hide
        SplashScreen splashScreen = new SplashScreen(1);
        splashScreen.ShowSplash();
        splashScreen.SplashScreenExit();




    }


}