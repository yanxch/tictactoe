package tic.tac.toe.tictactoe;

public enum Player {

	PLAYER_1(1), PLAYER_2(2);
	
	Player(int id) {
		this.id = id;
	}
	
	private final int id;
	
	public int id() {
		return id;
	}
}
