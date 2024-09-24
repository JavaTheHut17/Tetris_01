package ui.Screens;
import gameModel.Engine.*;
import gameModel.Engine.Factory_Tetromino.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameScreen extends JPanel implements ActionListener {

    public Timer timer;
    public Boolean isPaused = false;
    private int[] linePiece = {1, 1, 1, 1};
    private int cellWidth = 25;
    private int cellHeight = 25;
    private int[][] grid;
    private final int rows = 15;
    private final int cols = 5;
    private int[][] currentPiece;
    private int currentPieceLength;
    private int newPiecePosX;
    private int newPiecePosY;
    private Boolean piecePlaced = false;

    //Screen Sizing (fix this )
//    Toolkit toolkit = Toolkit.getDefaultToolkit();
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    private int screenWidth = (screenSize.width - getWidth()) / 2;
//    private int screenHeight = (screenSize.height - getHeight()) / 2;
    private int screenWidth = 600;
    private int screenHeight = 900;
    private int StartGridX = (screenWidth - (cols * cellWidth)) / 2;
    private int StartGridY = (screenHeight - (rows * cellHeight)) / 2;
    private int x;
    private int y;


    public GameScreen() {
        System.out.println("gameScreen loaded");
        timer = new Timer(10, this);
        x = StartGridX;
        y = StartGridY - 25;
        grid = new int[rows][cols];

        randomPieceGen();

        currentPieceLength = currentPiece.length;

        //Game Timer Start
        if (globalState.getInstance().currentGameState) {
            timer.start();
        }

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
                        x = StartGridX + (cols - currentPiece.length) * cellWidth;
                    repaint();
                }
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    x += 25;
                    if (x > StartGridX + (cols - currentPiece.length) * cellWidth) {
                        x = StartGridX;
                    }
                    repaint();
                }
            }
        });


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
//    PiecePlacement(g);
        if (piecePlaced) {
//        super.paint(g);
            PiecePlacement(g);

//        piecePlaced = false;
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
        for (int i = 0; i < currentPiece.length; i++) {
            for (int j = 0; j < currentPiece[i].length; j++) {

                g.fillRect(newPiecePosX + j * cellWidth, newPiecePosY + i * cellWidth, cellWidth, cellHeight);
            }
        }

        updateGrid();
        lockPiece(g);
    }

    public void updateGrid() {
        int gridX = newPiecePosX / cellWidth;
        int gridY = newPiecePosY / cellHeight;

        for (int i = 0; i < currentPiece.length; i++) {
            for (int j = 0; j < currentPiece[i].length; j++) {
                if (currentPiece[i][j] == 1) {

                    if (gridX + j < cols && gridY + i < rows) {
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

        y += 1;
        if (y >= (StartGridY + rows * cellWidth) - 25) {
//            newPiecePosLength = x + (currentPieceLength * cellWidth);

            newPiecePosX = x;
            newPiecePosY = y;
            piecePlaced = true;
            randomPieceGen();

//            PiecePlacement(getGraphics());
//            updateGrid();
            y = StartGridY - 25;
            x = StartGridX;
//            piecePlaced = false;


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



}
