package ui.Screens;
import JsonFiles.LoadState;
import gameModel.Engine.*;
import gameModel.Engine.Factory_Tetromino.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameScreen extends JPanel implements ActionListener {
    LoadState ls = LoadState.LoadFromFile("config.json");
    public Timer timer;
    public Boolean isPaused = false;
    private int[] linePiece = {1, 1, 1, 1};
    private int cellWidth = 25;
    private int cellHeight = 25;
    private int[][] grid;
    public final int rows = ls.getRows();
    public final int cols= ls.getCols();
    public int gamelvl = ls.getgameLvl();
    private int[][] currentPiece;
    private int currentPieceLength;
    private int newPiecePosX;
    private int newPiecePosY;
    private Boolean piecePlaced = false;
    private int[][] oldPiece;

    private int screenWidth = 600;
    private int screenHeight = 900;
    int StartGridX = (screenWidth - (cols * cellWidth)) / 2;
    int StartGridY = (screenHeight - (rows * cellHeight)) / 2;
    private int x;
    private int y;

    private boolean isMusicRunning;

    public GameScreen() {
//        MusicPlayer mp = new MusicPlayer("src/Assets/Sound/backgroundMusic.mp3");

//        mp.run();

        System.out.println("rows: " + rows);
        timer = new Timer(10, this);

        x = StartGridX;
        y = StartGridY - 25;

        grid = new int[rows][cols];
        currentPiece = new int[][]{linePiece};
        currentPieceLength = currentPiece.length;

        //Game Timer Start
        if (globalState.getInstance().currentGameState) {

            timer.start();
        }

        //Window
        setFocusable(true);
        SwingUtilities.invokeLater(this::requestFocusInWindow);
        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());

        //Pause Text Box
        JPanel pausePanel = new JPanel();
        pausePanel.setSize(100, 100);
        pausePanel.setBackground(Color.WHITE);
        JLabel pauseLabel = new JLabel("Game Paused: Press \"P\" to unpause");
        pauseLabel.setSize(100, 50);
        pausePanel.add(pauseLabel);
        add(pausePanel);
        pausePanel.setVisible(false);

        //User Input
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("P"), "Pause");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

        actionMap.put("Pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    isPaused = true;
                    pausePanel.setVisible(true);
                    timer.stop();
                } else {
                    isPaused = false;
                    pausePanel.setVisible(false);
                    timer.start();
                }
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    x -= 25;
                    if (x < StartGridX)
                        x = StartGridX;
                    repaint();
                }
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    x += 25;
                    int calc = StartGridX + (cols - currentPiece[0].length) * cellWidth;
                    if (x > calc) {
                        x =calc;
                    }
                    repaint();
                }
            }
        });
//
//        inputMap.put(KeyStroke.getKeyStroke("m"), "Music");
//
//        actionMap.put("Music", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(isMusicRunning){
//                    mp.pause();
//                    setIsMusicRunnning(false);
//                }if(!isMusicRunning){
//                    mp.run();
//                    setIsMusicRunnning(true);
//                }
//            }
//        });

        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e -> {
            timer.stop();
            pausePanel.setVisible(true);
            //Back Option Panel
            int backOption = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit the game?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION

            );

            if (backOption == JOptionPane.YES_OPTION) {
                NavigationEngine.bButtonFunc();
                restartGame();
                pausePanel.setVisible(false);

            }
            if (backOption == JOptionPane.NO_OPTION) {
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
        if (piecePlaced) {

            PiecePlacement(g);

        }
    }

    public void restartGame() {
        x = 100;
        y = 0;
        timer.restart();
        timer.start();
        repaint();
        revalidate();
    }


    public void Piece(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < currentPiece.length; i++) {
            for (int j = 0; j < currentPiece[i].length; j++) {
                if (currentPiece[i][j] == 1) {
                    g.fillRect(x + j * 25, y + i * 25, 25, 25);
                }

            }
        }
    }

    public void PiecePlacement(Graphics g) {
        g.setColor(Color.PINK);
        for (int i = 0; i < oldPiece.length; i++) {
            for (int j = 0; j < oldPiece[i].length; j++) {
                if(oldPiece[i][j] == 1){
                    int drawXP = StartGridX + (newPiecePosX - StartGridX) + j * cellWidth;
                    int drawYP = StartGridY + (newPiecePosY - StartGridY) + i * cellHeight;
                    g.fillRect(drawXP, drawYP, cellWidth, cellHeight);                }

            }
        }

        updateGrid();
        lockPiece(g);
        piecePlaced = false;
    }

    public void updateGrid() {
        int gridX = (newPiecePosX - StartGridX) / cellWidth;
        int gridY = (newPiecePosY - StartGridY) / cellHeight;

        for (int i = 0; i < oldPiece.length; i++) {
            for (int j = 0; j < oldPiece[i].length; j++) {
                if (oldPiece[i][j] == 1) {

                    if (gridX + j >= 0 && gridX + j < cols && gridY + i >= 0 && gridY + i < rows) {
                        grid[gridY + i][gridX + j] = 1;  // Mark the grid cell as filled
                    }
                }

            }
        }
    }

    public void lockPiece(Graphics g) {
        g.setColor(Color.BLUE);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    g.fillRect(StartGridX + j * cellWidth, StartGridY + i * cellWidth, cellWidth, cellHeight);

                }
            }
        }
    }


    public void DrawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g.fillRect(StartGridX + j * cellWidth, StartGridY + i * cellWidth, cellWidth, cellHeight);
            }
        }
    }


    public void actionPerformed(ActionEvent e) {

        y += gamelvl;
        if (y >= (StartGridY + rows * cellWidth) - 25) {
            oldPiece = currentPiece;
            newPiecePosX = x;
            newPiecePosY = y;
            piecePlaced = true;
//            updateGrid();
            y = StartGridY - 25;
            x = StartGridX;

            randomPieceGen();

        }
        repaint();
    }

    public void randomPieceGen() {


        tetrominoFactory linePieceFactory = new linePieceFactory();
        Tetromino_Gen linePiece = linePieceFactory.buildTetromino();

        tetrominoFactory squarePieceFactory = new squarePieceFactory();
        Tetromino_Gen squarePiece = squarePieceFactory.buildTetromino();

        tetrominoFactory zPieceFactory = new zPieceFactory();
        Tetromino_Gen zPiece = zPieceFactory.buildTetromino();

        tetrominoFactory teePieceFactory = new teePieceFactory();
        Tetromino_Gen teePiece = teePieceFactory.buildTetromino();

        tetrominoFactory lPieceFactory = new lPieceFactory();
        Tetromino_Gen lPiece = lPieceFactory.buildTetromino();



        Random randNum = new Random();
        int randomNumb = randNum.nextInt(6);

        if (randomNumb == 1) {
            currentPiece = linePiece.createTetromino();
        }
        else if (randomNumb == 2) {
            currentPiece = zPiece.createTetromino();
        }
        else if (randomNumb == 3) {
            currentPiece = teePiece.createTetromino();
        }
        else if (randomNumb == 4) {
            currentPiece = lPiece.createTetromino();
        }
        else if (randomNumb == 5) {
            currentPiece = squarePiece.createTetromino();
        }
    }
    public void setIsMusicRunnning(boolean isMusicRunning){
        this.isMusicRunning = isMusicRunning;
    }
    public boolean getIsMusicRunning(){
        return isMusicRunning;
    }



}
