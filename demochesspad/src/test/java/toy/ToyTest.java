package toy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import toy.chess.ChessPiece;
import toy.chess.Piece;
import toy.chess.PieceFactory;
import toy.keypad.Key;
import toy.keypad.KeyPad;

public class ToyTest {

	private KeyPad keyPad;

	@Before
	public void before() throws Exception {

		keyPad = new KeyPad();
	}

	@Test
	public void testCount() {

		final Key key = keyPad.getKey(5);
		final Piece piece = PieceFactory.build(ChessPiece.Queen);
		final int expectedNumberMoves = 124768940;

		final long on = System.currentTimeMillis();
		final long movesSize = piece.countMoves(key, 10);

		System.out.println((System.currentTimeMillis() - on) / 1000.0 + " sec");
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testKing() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.King);

		int expectedNumberMoves = 4; // ok
		long movesSize = piece.countMoves(key, 2);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 21; // ok
		movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 5697655;
		movesSize = piece.countMoves(key, 10);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testQueen() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.Queen);

		int expectedNumberMoves = 6; // ok
		long movesSize = piece.countMoves(key, 2);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 48; // ok
		movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 78190936;
		movesSize = piece.countMoves(key, 10);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testBishop() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.Bishop);

		int expectedNumberMoves = 11; // ok
		long movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 41; // ok
		movesSize = piece.countMoves(key, 4);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 124293;
		movesSize = piece.countMoves(key, 10);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testKnight() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.Knight);

		int expectedNumberMoves = 9; // ok
		long movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 27; // ok
		movesSize = piece.countMoves(key, 4);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 19683;
		movesSize = piece.countMoves(key, 10);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testRook() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.Rook);

		int expectedNumberMoves = 4; // ok
		long movesSize = piece.countMoves(key, 2);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 22; // ok
		movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 2586808;
		movesSize = piece.countMoves(key, 10);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testPawn() {

		final Key key = keyPad.getKey(5);
		final Piece piece = PieceFactory.build(ChessPiece.Pawn);
		int expectedNumberMoves = 2; // ok
		long movesSize = piece.countMoves(key, 2);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 10; // ok
		movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 70; // ok
		movesSize = piece.countMoves(key, 4);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testTopPawn() {

		final Key key = keyPad.getKey(1);
		final Piece piece = PieceFactory.build(ChessPiece.Pawn);
		int expectedNumberMoves = 1; // ok
		long movesSize = piece.countMoves(key, 2);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 7; // ok
		movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 55; // ok
		movesSize = piece.countMoves(key, 4);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}

	@Test
	public void testBottomPawn() {

		final Key key = keyPad.getKey(0);
		final Piece piece = PieceFactory.build(ChessPiece.Pawn);
		int expectedNumberMoves = 6; // ok
		long movesSize = piece.countMoves(key, 3);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 18; // ok
		movesSize = piece.countMoves(key, 4);
		Assert.assertEquals(expectedNumberMoves, movesSize);

		expectedNumberMoves = 92; // ok
		movesSize = piece.countMoves(key, 5);
		Assert.assertEquals(expectedNumberMoves, movesSize);
	}
}
