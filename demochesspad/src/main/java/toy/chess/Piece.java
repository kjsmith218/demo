package toy.chess;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import toy.keypad.Key;
import toy.move.SizedCartesianMove;

public abstract class Piece implements Serializable {

	private static final long serialVersionUID = 1L;

	private final ChessPiece chessPiece;

	protected Piece(final ChessPiece chessPiece) {
		this.chessPiece = chessPiece;
	}

	public ChessPiece getChessPiece() {
		return chessPiece;
	}

	protected boolean terminate(final String str, final int maxDepth) {
		return str.length() == maxDepth;
	}

	public abstract long countMoves(Key startKey, int maxDepth);

	protected Set<Key> getKeys(final Key key, final SizedCartesianMove legalMove) {

		final Set<Key> newKeys = new HashSet<>();
		Key newKey = key;

		for (int i = 0; i < legalMove.getMaxSteps(); i++) {

			if (newKey.has(legalMove.getLegalMove())) {
				newKey = newKey.get(legalMove.getLegalMove());
				newKeys.add(newKey);
			} else {
				break;
			}
		}
		return newKeys;
	}

	protected class State {

		private long count = 0;
		protected final int maxDepth;

		protected State(final int maxDepth) {
			this.maxDepth = maxDepth;
		}

		protected long getCount() {
			return count;
		}

		protected void increment() {
			count++;
		}
	}
}
