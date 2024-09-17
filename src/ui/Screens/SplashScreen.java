package ui.Screens;

import gameModel.Engine.GameTime;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;


public class SplashScreen extends JWindow {

    public int time;


    public SplashScreen(int time) {

        this.time = time;

    }

    //Splash Screen
    public void ShowSplash() {
        JPanel content = new JPanel();
        int width = 400;
        int height = 800;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        JLabel label = new JLabel(new ImageIcon("src/images/Splash.jpg"));
        content.add(label, BorderLayout.CENTER);
        add(content);
        setVisible(true);


    }


//Splash Screen Function
    public void SplashScreenExit() throws InterruptedException {

        GameTime gameTimer = GameTime.getInstance();
        gameTimer.gameDuration();

        while(true){

            if(gameTimer.gameDuration() >= 4){

                setVisible(false);
                new MainFrame();
                break;
            }
            Thread.sleep(500);
        }

    }


}


