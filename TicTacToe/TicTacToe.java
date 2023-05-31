package TicTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JLabel text_field = new JLabel();
	JButton[] buttons = new JButton[9]; 
	boolean player1;
TicTacToe() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 800);
	frame.getContentPane().setBackground(new Color(50, 50, 50));
	frame.setLayout(new BorderLayout());
	frame.setVisible(true);
	
	title.setLayout(new BorderLayout());
	title.setBounds(0, 0, 800, 100);
	
	text_field.setBackground(new Color(20, 20, 20));
	text_field.setForeground(new Color(50,100, 0));
	text_field.setFont(new Font("Verdana", Font.BOLD, 75));
	text_field.setHorizontalAlignment(JLabel.CENTER);
	text_field.setText("Tic-Tac-Toe");
	text_field.setOpaque(true);
	
	button.setLayout(new GridLayout(3,3));
	button.setBackground(new Color(130, 40,30));
	
	for(int i=0; i<9; i++) {
		buttons[i]=new JButton();
		button.add(buttons[i]);
		buttons[i].setFont(new Font("Verdana", Font.BOLD, 75));
		buttons[i].setFocusable(true);
		buttons[i].addActionListener(this);
	}
	
	title.add(text_field);
	frame.add(title, BorderLayout.NORTH);
	frame.add(button);
	firstTurn();
}
@Override
public void actionPerformed(ActionEvent e) {
for (int i=0; i<9; i++) {
	if(e.getSource()==buttons[i]) {
		if(player1) {
			if(buttons[i].getText()=="") {
				buttons[i].setForeground(new Color(155, 0, 0));
				buttons[i].setText("X");
				player1=false;
				text_field.setText("O Turn");
			}
		}else {
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(0, 0, 155));
					buttons[i].setText("O");
					player1=true;
					text_field.setText("X Turn");
			}
		}
	}
check();
}	
}

public void firstTurn() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(random.nextInt(2)==0) {
		 player1=true;
		 text_field.setText("X Turn");
		 }else {
		 player1=false;
		 text_field.setText("O Turn");
		 }
}
public void check() {
	if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X"){
		xWins(0, 1, 2);
	}else if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X") {
	xWins(3, 4, 5);
		}else if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X") {
		xWins(6, 7, 8);
			}else if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X") {
			xWins(0, 3, 6);
				}else if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X") {
					xWins(1, 4, 7);
						}else if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X") {
					xWins(2, 5, 8);
							}else if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X") {
								xWins(0, 4, 8);
									}else if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X") {
										xWins(2, 4, 6);
								}else if(buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O") {
									oWins(0, 1, 2);
							}else if(buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O") {
								oWins(3, 4, 5);
						}else if(buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O") {
							oWins(6, 7, 8);
					}else if(buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O") {
						oWins(0, 3, 6);
				}else if(buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O") {
					oWins(1, 4, 7);
			}else if(buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O") {
				oWins(2, 5, 8);
		}else if(buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O") {
			oWins(0, 4, 8);
	}else if(buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O") {
		oWins(2, 4, 6);
}
	if (buttons[0].getText()!="" && buttons[1].getText()!="" && buttons[2].getText()!="" && buttons[3].getText()!="" && buttons[4].getText()!=""
			&& buttons[5].getText()!="" && buttons[6].getText()!="" && buttons[7].getText()!="" && buttons[8].getText()!="") {
		text_field.setText("Match Draw");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newGame();
	}
}
public void xWins(int a, int b, int c) {
	buttons[a].setBackground(new Color(0, 255, 0));
	buttons[b].setBackground(new Color(0, 255, 0));
	buttons[c].setBackground(new Color(0, 255, 0));
	text_field.setText("X Wins");
	for (int i =0; i<9; i++) {
		buttons[i].setEnabled(false);
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void oWins(int a, int b, int c) {
	buttons[a].setBackground(new Color(0, 255, 0));
	buttons[b].setBackground(new Color(0, 255, 0));
	buttons[c].setBackground(new Color(0, 255, 0));
	text_field.setText("O Wins");
	for (int i =0; i<9; i++) {
		buttons[i].setEnabled(false);
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void newGame() {
	text_field.setText("New Game");
	for (int i=0; i<9; i++) {
		buttons[i].setText("");
	}
}
}
