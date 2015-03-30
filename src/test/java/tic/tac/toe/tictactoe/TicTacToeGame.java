package tic.tac.toe.tictactoe;

public class TicTacToeGame {

	private int[][] playboard = new int[3][3];
	
	public int[][] playboard() {
		return playboard;
	}

	public boolean markSpace(int row, int column, Player player) {
		validate(row, column);
		playboard[row -1][column - 1] = player.id();
		return gameFinished(player);
	}

	private boolean gameFinished(Player player) {
		boolean rowWin = checkRowForPlayer(1, player) || 
						 checkRowForPlayer(2, player) || 
						 checkRowForPlayer(3, player);
		
		boolean columnWin = checkColumnForPlayer(1, player) ||
							checkColumnForPlayer(2, player) ||
							checkColumnForPlayer(3, player);
		
		boolean diogonalWin = checkDiogonal1ForPlayer(player) || checkDiogonal2ForPlayer(player);
		
		return rowWin || columnWin || diogonalWin; 
	}

	private boolean checkRowForPlayer(int row, Player player) {
		return playboard[row - 1][0] == player.id() &&
			   playboard[row - 1][1] == player.id() &&
			   playboard[row - 1][2] == player.id();
	}
	
	private boolean checkColumnForPlayer(int column, Player player) {
		return playboard[0][column - 1] == player.id() &&
			   playboard[1][column - 1] == player.id() &&
			   playboard[2][column - 1] == player.id();
	}

	private boolean checkDiogonal1ForPlayer(Player player) {
		return playboard[0][0] == player.id() &&
			   playboard[1][1] == player.id() &&
			   playboard[2][2] == player.id();
	}
	
	private boolean checkDiogonal2ForPlayer(Player player) {
		return playboard[0][2] == player.id() &&
			   playboard[1][1] == player.id() &&
			   playboard[2][0] == player.id();
	}
	
	private void validate(int row, int column) {
		if(playboard[row - 1][column - 1] != 0) {
			throw new RuntimeException("Space already marked!");
		}
	}
}
