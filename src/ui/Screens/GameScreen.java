package ui.Screens;
import gameModel.Engine.NavigationEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gameModel.Engine.globalState;
public class GameScreen extends JPanel implements ActionListener{

    private int x = 100;
    private int y =0;
    public Timer timer;
    private int xgrid =0;
    private int ygrid = 0;
    private int gridWidth =400;
    private int gridHeight=700;
    public Boolean isPaused = false;
    private int[] linePiece = {1,1,1,1};

    private int cellWidth =25;
    private int cellHeight = 25;
    private int[][] grid;
    private final int rows = 28;
    private final int cols = 16;
    private int yCords = 0;
    private int[] currentPiece;
    private int currentPieceLength;
    private int newPiecePosX;
    private int newPiecePosY;
    private int newPiecePosLength;
    private int bottomGrid =675;
    private Boolean piecePlaced = false;


    public GameScreen() {
        System.out.println("gameScreen loaded");
        timer = new Timer(10, this);

        grid = new int[rows][cols];
        currentPiece = linePiece;
        currentPieceLength = currentPiece.length;

        if(globalState.getInstance().currentGameState){
            System.out.println("GS called.");
            timer.start();
        }

        setFocusable(true);
        SwingUtilities.invokeLater(this::requestFocusInWindow);
        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());

        //Pause Text Box
        JPanel pausePanel = new JPanel();
        pausePanel.setSize(100,100);
        pausePanel.setBackground(Color.WHITE);
        JLabel pauseLabel = new JLabel("Game Paused: Press \"P\" to unpause" );
        pauseLabel.setSize(100,50);
        pausePanel.add(pauseLabel);
        add(pausePanel);
        pausePanel.setVisible(false);

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("P"),"Pause");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

        actionMap.put("Pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPaused){
                    isPaused = true;
                    pausePanel.setVisible(true);
                    timer.stop();
                }else{
                    isPaused = false;
                    pausePanel.setVisible(false);
                    timer.start();
                }
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPaused){
                    x -= 25;
                    if (x < 0) x = 300;
                    repaint();
                }
                }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPaused){
                    x += 25;
                    if (x > 300) x = 0;
                    repaint();
                }
                }
        });



        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{

            timer.stop();
            pausePanel.setVisible(true);
            //Back Option Panel
            int backOption = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit the game?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION

            );

            if(backOption == JOptionPane.YES_OPTION){
                NavigationEngine.bButtonFunc();
                restartGame();
                pausePanel.setVisible(false);

            }
            if(backOption == JOptionPane.NO_OPTION){
                pausePanel.setVisible(false);
                timer.start();
            }
        });
    }

    //Paint Grid & Pieces
    @Override
    public void paint(Graphics g) {
    super.paint(g);
    DrawGrid(g);
    Piece(g);
//    PiecePlacement(g);
    if(piecePlaced){
//        super.paint(g);
        PiecePlacement(g);
//        piecePlaced = false;
    }
    }

    public void restartGame() {
        x =100;
        y =0;
        timer.restart();
        timer.start();
        repaint();
        revalidate();
    }


    public void Piece (Graphics g){
        g.setColor(Color.GREEN);
        for(int i =0;i<currentPiece.length;i++){
            if(currentPiece[i] == 1){
                g.fillRect(x + (currentPieceLength + i) * 25,yCords = 100 + y, 25, 25);
            }
        }
    }

    public void PiecePlacement(Graphics g){
        g.setColor(Color.GREEN);
        for(int i =0;i<currentPiece.length;i++){
            for(int j=0;j<currentPiece.length;j++){
                g.fillRect(100 + newPiecePosX + i * 25 ,100 + newPiecePosY ,cellWidth,cellHeight);
            }

        }
        updateGrid();
        lockPiece(g);
    }

    public void updateGrid(){
        for (int i = 0; i < currentPiece.length; i++) {
            if (currentPiece[i] == 1) {
                int gridX = newPiecePosX / cellWidth;
                int gridY = newPiecePosY / cellHeight;

                if (gridX + i < cols && gridY < rows) {
                    grid[gridY][gridX + i] = 1;  // Mark the grid cell as filled
                }
            }
        }
    }

    public void lockPiece(Graphics g){
        g.setColor(Color.BLUE);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    g.fillRect(100 + j * cellWidth, 100 + i * cellHeight, cellWidth, cellHeight);

                }
            }
        }
    }


    public void DrawGrid(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                g.fillRect(100 + j * cellWidth, 100 + i * cellWidth, cellWidth,cellHeight);
                }
            }
        }


    public void actionPerformed(ActionEvent e) {

        y +=1;
        if (y >= bottomGrid){

//            newPiecePosLength = x + (currentPieceLength * cellWidth);
            newPiecePosX = x;
            newPiecePosY = y ;
            bottomGrid = y - 25;
            piecePlaced = true;
//            System.out.println("new Piece x" + newPiecePosX);
//            System.out.println("New piece y " + newPiecePosY);
            y = 100;


        }
        repaint();
    }
}
