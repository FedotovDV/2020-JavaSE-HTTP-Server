package lesson06_gomoku_impl;
import java.util.Objects;
import lesson06_gomoku.Cell;
import lesson06_gomoku.CellValue;
import lesson06_gomoku.GameTable;
import lesson06_gomoku.HumanTurn;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class DefaultHumanTurn implements HumanTurn{
	private GameTable gameTable;
	
	@Override
	public void setGameTable(GameTable gameTable) {
		Objects.requireNonNull(gameTable, "Game table can't be null");
		this.gameTable = gameTable;
	}

	@Override
	public Cell makeTurn(int row, int col) {
		gameTable.setValue(row, col, CellValue.HUMAN);
		return new Cell(row, col);
	}
}
