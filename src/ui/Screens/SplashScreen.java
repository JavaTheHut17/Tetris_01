package ui.Screens;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JWindow {

    public int time;

    public SplashScreen(int time) {

        this.time = time;

    }

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



    public void SplashScreenExit(){

        Timer timer = new Timer(time * 4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);

            }
        });
        timer.setRepeats(false); // Ensure the timer runs only once
        timer.start(); // Start the timer
    }






}




