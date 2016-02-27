package toy.chess;

import static toy.chess.BoardDimension.Diagonal;
import static toy.chess.BoardDimension.Width;
import static toy.chess.BoardDimension.Height;
import static toy.move.CartesianMove.EAST;
import static toy.move.CartesianMove.L1;
import static toy.move.CartesianMove.L10;
import static toy.move.CartesianMove.L11;
import static toy.move.CartesianMove.L2;
import static toy.move.CartesianMove.L4;
import static toy.move.CartesianMove.L5;
import static toy.move.CartesianMove.L7;
import static toy.move.CartesianMove.L8;
import static toy.move.CartesianMove.NONE;
import static toy.move.CartesianMove.NORTH;
import static toy.move.CartesianMove.NORTHEAST;
import static toy.move.CartesianMove.NORTHWEST;
import static toy.move.CartesianMove.SOUTH;
import static toy.move.CartesianMove.SOUTHEAST;
import static toy.move.CartesianMove.SOUTHWEST;
import static toy.move.CartesianMove.WEST;
import static toy.move.SizedCartesianMove.of;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import toy.move.SizedCartesianMove;

public enum ChessPiece {

	King(of(NONE), of(NORTH), of(SOUTH), of(WEST), of(EAST),
			
			of(NORTHWEST), of(NORTHEAST),

			of(SOUTHWEST), of(SOUTHEAST)),

	Queen(of(NONE), of(NORTH, Height), of(SOUTH, Height),

			of(WEST, Width), of(EAST, Width),

			of(NORTHWEST, Diagonal), of(NORTHEAST, Diagonal),

			of(SOUTHWEST, Diagonal), of(SOUTHEAST, Diagonal)),

	Bishop(of(NONE), of(NORTHEAST, Diagonal), of(NORTHWEST, Diagonal),

			of(SOUTHEAST, Diagonal), of(SOUTHWEST, Diagonal)),

	Knight(of(NONE), of(L1), of(L2), of(L4), of(L5), of(L7), of(L8), of(L10), of(L11)),

	Rook(of(NONE), of(NORTH, Height), of(SOUTH, Height),

			of(WEST, Width), of(EAST, Width)),

	Pawn(of(NONE), of(NORTH)),

	StationaryPawn(of(NONE)),

	DoublePawn(of(NONE), of(NORTH, 2));

	private final Set<SizedCartesianMove> legalMoves;

	private ChessPiece(final SizedCartesianMove... legalMoves) {
		this.legalMoves = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(legalMoves)));
	}

	// for testing only
	public Set<SizedCartesianMove> getLegalMoves() {
		final List<SizedCartesianMove> list = new ArrayList<>(legalMoves);
		Collections.shuffle(list);
		return new HashSet<>(list);
	}
}
