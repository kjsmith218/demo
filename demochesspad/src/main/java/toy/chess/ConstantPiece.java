package toy.chess;

import toy.keypad.Key;
import toy.move.SizedCartesianMove;

public class ConstantPiece extends Piece {

	private static final long serialVersionUID = 1L;

	protected ConstantPiece(final ChessPiece chessPiece) {
		super(chessPiece);
	}

	@Override
	public long countMoves(final Key startKey, final int maxDepth) {

		final State state = new State(maxDepth);
		countMoves(state, startKey.getName(), startKey);
		return state.getCount();
	}

	protected void recurse(final State state, final String str, final Key key) {

		for (final SizedCartesianMove legalMove : getChessPiece().getLegalMoves()) {
			for (final Key k : getKeys(key, legalMove)) {
				final String s = str + k.getName();
				countMoves(state, s, k);
			}
		}
	}
	
	protected void countMoves(final State state, final String str, final Key key) {

		if (terminate(str, state.maxDepth)) {
			state.increment();
			return;
		}

		recurse(state, str, key);
	}
}
