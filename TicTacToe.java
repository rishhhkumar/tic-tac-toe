import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardwidth = 600;
    int boardheight = 650;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardpanel = new JPanel();

    JButton[][] board = new JButton[3][3];

    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardpanel.setLayout(new GridLayout(3, 3));
        boardpanel.setBackground(Color.darkGray);
        frame.add(boardpanel);

        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardpanel.add(tile);

                tile.setBackground(Color.white);
                tile.setForeground(Color.darkGray);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if(gameOver) return;

                        JButton tile = (JButton) e.getSource();

                        if(tile.getText()==""){

                            tile.setText(currentPlayer);
                            turns++;

                            checkWinner();
                            if(!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                            
                        }   

                    }
                });
            }
        }
    }

    void checkWinner(){
        // horizontal
         for(int r=0; r<3; r++){
            if(board[r][0].getText()=="") continue;

            if(board[r][0].getText()==board[r][1].getText() && board[r][1].getText()==board[r][2].getText()){
                for(int i=0; i<3; i++){
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        // vertical
        for(int c=0; c<3; c++){
            if(board[0][c].getText()=="") continue;

            if(board[0][c].getText()==board[1][c].getText() && board[1][c].getText()==board[2][c].getText()){
                for(int i=0; i<3; i++){
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        // diagonal
        if(board[0][0].getText()!="" && 
           board[0][0].getText()==board[1][1].getText() &&
           board[1][1].getText()==board[2][2].getText()){
                for(int i=0; i<3; i++){
                    setWinner(board[i][i]);
                }
                gameOver = true;
                return;
        }

        // anti-diagonal
        if(board[0][2].getText()!="" && 
           board[0][2].getText()==board[1][1].getText() &&
           board[1][1].getText()==board[2][0].getText()){
                for(int i=0; i<3; i++){
                    setWinner(board[i][2-i]);
                }
                gameOver = true;
                return;
        }

        if(turns == 9){
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++){
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }

    }

    void setWinner(JButton tile){
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the Winner!");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.yellow);
        tile.setBackground(Color.gray);
        textLabel.setText("It's a Tie!");
    }
}