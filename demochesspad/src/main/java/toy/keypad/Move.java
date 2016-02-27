package toy.keypad;

import java.io.Serializable;

import toy.move.CartesianMove;

public class Move implements Serializable {

	private static final long serialVersionUID = 1L;

	private final CartesianMove move;
	private final Key key;

	private Move(final CartesianMove move, final Key key) {
		this.move = move;
		this.key = key;
	}

	public CartesianMove getMove() {
		return move;
	}

	public Key getKey() {
		return key;
	}

	public static Move of(final CartesianMove move, final Key key) {
		return new Move(move, key);
	}

	@Override
	public String toString() {
		return "Move [" + (move != null ? "move=" + move + ", " : "") + (key != null ? "key=" + key : "") + "]";
	}

}
