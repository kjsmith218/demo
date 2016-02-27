package toy.move;

import java.io.Serializable;

public class SizedCartesianMove implements Serializable {

	private static final long serialVersionUID = 1L;

	private CartesianMove legalMove;
	private int maxSteps;

	private SizedCartesianMove(final CartesianMove legalMove, final int maxSteps) {
		this.legalMove = legalMove;
		this.maxSteps = maxSteps;
	}

	private SizedCartesianMove(final CartesianMove legalMove) {
		this.legalMove = legalMove;
		this.maxSteps = 1;
	}

	public CartesianMove getLegalMove() {
		return legalMove;
	}

	public void setLegalMove(final CartesianMove legalMove) {
		this.legalMove = legalMove;
	}

	public int getMaxSteps() {
		return maxSteps;
	}

	public void setMaxSteps(final int maxSteps) {
		this.maxSteps = maxSteps;
	}

	@Override
	public String toString() {
		return "SizedCartesianMove [" + (legalMove != null ? "legalMove=" + legalMove + ", " : "") + "maxSteps="
				+ maxSteps + "]";
	}

	public static SizedCartesianMove of(final CartesianMove legalMove) {
		return new SizedCartesianMove(legalMove);
	}

	public static SizedCartesianMove of(CartesianMove legalMove, final int maxSteps) {
		return new SizedCartesianMove(legalMove, maxSteps);
	}

}
