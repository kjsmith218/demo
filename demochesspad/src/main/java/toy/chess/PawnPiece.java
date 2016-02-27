package toy.chess;

import static toy.chess.ChessPiece.DoublePawn;
import static toy.chess.ChessPiece.Pawn;
import static toy.chess.ChessPiece.Queen;
import static toy.chess.ChessPiece.StationaryPawn;

import toy.keypad.Key;
import toy.move.SizedCartesianMove;

public class PawnPiece extends Piece {

	private static final long serialVersionUID = 1L;

	protected PawnPiece(final ChessPiece chessPiece) {
		super(chessPiece);
	}

	@Override
	public long countMoves(final Key startKey, final int maxDepth) {

		final State state = new State(maxDepth);
		countMoves(state, startKey.getName(), startKey, Pawn);
		return state.getCount();
	}

	private void countMoves(final State state, final String str, final Key key, final ChessPiece pieceIn) {

		ChessPiece piece = pieceIn;

		if (terminate(str, state.maxDepth)) {
			state.increment();
			return;
		}

		if (str.length() == 1 && key.isTopKey()) {
			piece = StationaryPawn;

		} else if (str.length() == 1 && key.isBottomKey()) {
			piece = DoublePawn;

		} else if (key.isTopKey() && piece != Queen) {
			piece = Queen;

		} else if (piece != Queen) {
			piece = Pawn;
		}

		recurse(state, str, key, piece);
	}

	protected void recurse(final State state, final String str, final Key key, final ChessPiece piece) {

		for (final SizedCartesianMove legalMove : piece.getLegalMoves()) {
			for (final Key k : getKeys(key, legalMove)) {
				final String s = str + k.getName();
				countMoves(state, s, k, piece);
			}
		}
	}
}
