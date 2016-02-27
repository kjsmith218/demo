package toy.chess;

public class PieceFactory {

	private PieceFactory() {
	}

	public static Piece build(final ChessPiece chessPiece) {

		if (chessPiece == ChessPiece.Pawn) {
			return new PawnPiece(chessPiece);
		}
		return new ConstantPiece(chessPiece);
	}
}
