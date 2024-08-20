package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen extends JPanel implements ActionListener{

    private int x = 100;
    private int y =0;

    private Timer timer;
    private int xgrid =0;
    private int ygrid=0;

    private int yCords = 0;

    private int startGridDepth = 575;
    private int currentGridDepth =0;
    private int newGridDepth =0;


    public GameScreen() {

//        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.BLACK);
        timer = new Timer(10, this);
        timer.start();
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();



        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left Pressed");
                x -= 25;
                if (x < 100) x = 475;
                repaint();
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right Pressed");
                x += 25;
                if (x > 475) x = 100;
                repaint();
            }
        });


        setFocusable(true);
        requestFocusInWindow(true);

        SwingUtilities.invokeLater(this::requestFocusInWindow);
        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });

    }


    @Override
    public void paint(Graphics g) {
    super.paint(g);

    DrawGrid(g);
    Piece(g);


    }



    public void Piece (Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x,yCords = 100 + y, 25, 25);
    }

    public void DrawGrid(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for(xgrid = 0; xgrid<400;xgrid+=25){
            for(ygrid= 0;ygrid<700;ygrid+=25){
                g.fillRect(100 + xgrid,100 + ygrid,25,25);
            }

        }


    }

    public void actionPerformed(ActionEvent e) {
//        x += 1;
//        if (x > 375){
//            x =100 ;
//
//        }
        y +=1;
        if (y >= 675){
            y=675;
        }
        repaint();
    }




//    @Override
//    public void keyPressed(KeyEvent e) {
//
//        int keyCode = e.getKeyCode(); // Get the key code of the pressed key
//
//        // Move piece based on arrow key presses
//        if (keyCode == KeyEvent.VK_LEFT) {
//            System.out.println("Left Pressed");
//            x -= 25;
//            if(x < 100){
//                x=475;
//            }
//            repaint();
//            // Additional logic for boundaries, etc.
//        } else if (keyCode == KeyEvent.VK_RIGHT) {
//            System.out.println("Right Pressed");
//            x += 25;
//            if(x > 475){
//                x=100;
//            }
//            repaint();
//            // Additional logic for boundaries, etc.
//        } else if (keyCode == KeyEvent.VK_UP) {
//            System.out.println("Up Pressed");
//            // Handle up key action
//        } else if (keyCode == KeyEvent.VK_DOWN) {
//            System.out.println("Down Pressed");
//            // Handle down key action
//        }
//
//        repaint();
//    }


}
