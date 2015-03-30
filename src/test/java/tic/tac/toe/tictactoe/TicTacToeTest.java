package tic.tac.toe.tictactoe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class TicTacToeTest {
	
	TicTacToeGame game = new TicTacToeGame();
	
	@Test
	public void whenStartingGamePlayboardIsInitialized()  {
		int[][] board = game.playboard();
		assertThatBoardIsInitialized(board);
	}

	private void assertThatBoardIsInitialized(int[][] board) {
		for (int[] row : board) {
			for (int value : row) {
				assertThat(value, is(0));
			}
		}
	}
	
	private boolean spaceMarkedBy(int row, int column, Player player) {
		return game.playboard()[row -1][column -1] == player.id();
	}
	
	@Test
	public void whenPlayerMarks1_1BoardIsUpdated() {
		game.markSpace(1, 1, Player.PLAYER_1);
		assertTrue(spaceMarkedBy(1, 1, Player.PLAYER_1));
	}
	
	@Test
	public void whenPlayerMarks2_2BoardIsUpdated() {
		game.markSpace(2, 2, Player.PLAYER_2);
		assertTrue(spaceMarkedBy(2, 2, Player.PLAYER_2));
	}
	
	@Test
	public void whenPlayerMarks3_3BoardIsUpdated() throws Exception {
		game.markSpace(3, 3, Player.PLAYER_1);
		assertTrue(spaceMarkedBy(3, 3, Player.PLAYER_1));
	}
	
	@Test(expected = RuntimeException.class)
	public void whenSpaceIsPlayedTwiceExceptionIsThrown() {
		game.markSpace(3, 3, Player.PLAYER_1);
		game.markSpace(3, 3, Player.PLAYER_1);
	}
	
	@Test
	public void whenPlayerMarksRow1GameIsWon() throws Exception {
		game.markSpace(1, 1, Player.PLAYER_1);
		game.markSpace(1, 2, Player.PLAYER_1);
		boolean won = game.markSpace(1, 3, Player.PLAYER_1);
		assertTrue(won);
	}

	@Test
	public void whenPlayerMarksRow2GameIsWon() throws Exception {
		game.markSpace(2, 1, Player.PLAYER_1);
		game.markSpace(2, 2, Player.PLAYER_1);
		boolean won = game.markSpace(2, 3, Player.PLAYER_1);
		assertTrue(won);
	}
	
	@Test
	public void whenPlayerMarksRow3GameIsWon() throws Exception {
		game.markSpace(3, 1, Player.PLAYER_1);
		game.markSpace(3, 2, Player.PLAYER_1);
		boolean won = game.markSpace(3, 3, Player.PLAYER_1);
		assertTrue(won);
	}
	
	@Test
	public void whenPLayerMarksColumn1GameIsWon() {
		game.markSpace(1, 1, Player.PLAYER_2);
		game.markSpace(2, 1, Player.PLAYER_2);
		boolean won = game.markSpace(3, 1, Player.PLAYER_2);
		assertTrue(won);
	}
	
	@Test
	public void whenPLayerMarksColumn2GameIsWon() {
		game.markSpace(1, 2, Player.PLAYER_2);
		game.markSpace(2, 2, Player.PLAYER_2);
		boolean won = game.markSpace(3, 2, Player.PLAYER_2);
		assertTrue(won);
	}
	
	@Test
	public void whenPLayerMarksColumn3GameIsWon() {
		game.markSpace(1, 3, Player.PLAYER_2);
		game.markSpace(2, 3, Player.PLAYER_2);
		boolean won = game.markSpace(3, 3, Player.PLAYER_2);
		assertTrue(won);
	}
	
	@Test
	public void whenPlayerMarksDiogonal1GameIsWon() {
		game.markSpace(1, 1, Player.PLAYER_1);
		game.markSpace(2, 2, Player.PLAYER_1);
		boolean won = game.markSpace(3, 3, Player.PLAYER_1);
		assertTrue(won);
	}
	
	@Test
	public void whenPlayerMarksDiogonal2GameIsWon() {
		game.markSpace(1, 3, Player.PLAYER_2);
		game.markSpace(2, 2, Player.PLAYER_2);
		boolean won = game.markSpace(3, 1, Player.PLAYER_2);
		assertTrue(won);
	}
	
}
