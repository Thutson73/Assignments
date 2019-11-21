import java.awt.*;

public class TicTacToe {
	int[][] xo = new int[3][3];
	public static void main(String[] args) {
		StdDraw.setXscale(0, 9.0);
        StdDraw.setYscale(0, 9.0);
        StdDraw.enableDoubleBuffering();
        Font font = new Font("Arial", Font.BOLD, 60);
        TicTacToe state = new TicTacToe();
        StdDraw.setFont(font);
        int turn = 1;
        int win = 0;
        boolean running = true;
        
        StdDraw.line(3.0, 9.0, 3.0, 0);
        StdDraw.line(6.0, 9.0, 6.0, 0);
        StdDraw.line(0, 3.0, 9.0, 3.0);
        StdDraw.line(0, 6.0, 9.0, 6.0);
        StdDraw.pause(10);
        while(running) {
        	if(StdDraw.isMousePressed()) {
        		win = state.click(turn);
        		if(win == 0) {
        			turn++;
        		}
        	}
        	
        	if(win == 3) {
        		StdDraw.setPenColor(StdDraw.RED);
        		StdDraw.text(4.5, 4.5, "Tie!", 15.0);
        		running = false;
        	}
        	else if(win == 1) {
        		StdDraw.setPenColor(StdDraw.RED);
        		StdDraw.text(4.5, 4.5, "Player 1 wins!", 15.0);
        		running = false;
        	}
        	else if(win == 2) {
        		StdDraw.setPenColor(StdDraw.RED);
        		StdDraw.text(4.5, 4.5, "Player 2 wins!", 15.0);
        		running = false;
        	}
        	StdDraw.show();
        	StdDraw.pause(50);
        }
    }
	
	public int click(int turn) {
		int test[][] = new int[3][3];
		int player = 0;
		double x = 0;
		double y = 0;
		int a = 0;
		int b = 0;
		boolean board[][] = new boolean[3][3];
		int tieCheck = 0;
		boolean valid = false;
		StdDraw.pause(200);
		
		if (turn % 2 == 0) {
			player = 2;
		}
		else if (turn % 2 != 0) {
			player = 1;
		}
		a = (int)StdDraw.mouseX()/3;
		b = (int)StdDraw.mouseY()/3;
		board[a][b] = true;
		
		if(board[0][0] && xo[0][0] == 0) {
			x = 1.5;
			y = 1.5;
			valid = true;
		}
		else if(board[0][1] && xo[0][1] == 0) {
			x = 1.5;
			y = 4.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[0][2] && xo[0][2] == 0) {
			x = 1.5;
			y = 7.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[1][0] && xo[1][0] == 0) {
			x = 4.5;
			y = 1.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[1][1] && xo[1][1] == 0) {
			x = 4.5;
			y = 4.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[1][2] && xo[1][2] == 0) {
			x = 4.5;
			y = 7.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[2][0] && xo[2][0] == 0) {
			x = 7.5;
			y = 1.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[2][1] && xo[2][1] == 0) {
			x = 7.5;
			y = 4.5;
			valid = true;
			board[a][b] = false;
		}
		else if(board[2][2] && xo[2][2] == 0) {
			x = 7.5;
			y = 7.5;
			valid = true;
			board[a][b] = false;
		}
		if (player == 1 && valid) {
			StdDraw.text(x, y, "X");
			xo[a][b] = 1;
		}
		else if (player == 2 && valid) {
			StdDraw.text(x, y, "O");
			xo[a][b] = 2;
		}
		
		if(xo[0][0] == xo[0][1] && xo[0][2] == xo[0][0]) {
			if (xo[0][0] == 1) {
				return 1;
			}
			else if (xo[0][0] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if(xo[1][0] == xo[1][1] && xo[1][2] == xo[1][0]) {
			if (xo[1][0] == 1) {
				return 1;
			}
			else if (xo[1][0] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if(xo[2][0] == xo[2][1] && xo[2][2] == xo[2][0]) {
			if (xo[2][0] == 1) {
				return 1;
			}
			else if (xo[2][0] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if(xo[0][0] == xo[1][0] && xo[1][0] == xo[2][0]) {
			if (xo[0][0] == 1) {
				return 1;
			}
			else if (xo[0][0] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if (xo[0][1] == xo[1][1] && xo[1][1] == xo[2][1]) {
			if (xo[0][1] == 1) {
				return 1;
			}
			else if (xo[0][1] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if(xo[0][2] == xo[1][2] && xo[1][2] == xo[2][2]) {
			if (xo[0][2] == 1) {
				return 1;
			}
			else if (xo[0][2] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if(xo[0][0] == xo[1][1] && xo[1][1] == xo[2][2]) {
			if (xo[0][0] == 1) {
				return 1;
			}
			else if (xo[0][0] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}
		if (xo[0][2] == xo[1][1] && xo[1][1] == xo[2][0]) {
			if (xo[0][2] == 1) {
				return 1;
			}
			else if (xo[0][2] == 2) {
				return 2;
			}
			else {
				if (!valid) {
					return 5;
				}
				return 0;
			}
		}	
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (xo[i][j] != 0) {
					tieCheck++;
					//System.out.println("" + i + j);
					//test[i][j]++;
				}
			}
		}
		/*for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (xo[i][j] != 0) {
					//tieCheck++;
					//System.out.println("" + i + j);
					System.out.println(test[i][j]);
				}
			}
		}*/
		//System.out.println(tieCheck);
		//System.out.println("-------------------------------");
		if(tieCheck == 9) {
			//System.out.println("tie");
			return 3;
		}
		else {
			if (!valid) {
				return 5;
			}
			return 0;
		}
	}
}