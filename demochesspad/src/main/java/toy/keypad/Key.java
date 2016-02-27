package toy.keypad;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import toy.move.CartesianMove;

public class Key implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Map<CartesianMove, Move> neighbourMoves = new HashMap<>();
	private final String name;
	private final byte value;
	private final boolean isTopKey;
	private final boolean isBottomKey;

	public static Key build(final String name) {
		return new Key(name, false, false);
	}

	public static Key buildTop(final String name) {
		return new Key(name, true, false);
	}

	public static Key buildBottom(final String name) {
		return new Key(name, false, true);
	}

	private Key(final String name, final boolean isTopKey, final boolean isBottomKey) {
		this.name = name;
		this.value = Byte.parseByte(name);
		this.isTopKey = isTopKey;
		this.isBottomKey = isBottomKey;
	}

	public void addMoves(final Move... moveArray) {
		neighbourMoves.clear();
		for (final Move m : moveArray) {
			neighbourMoves.put(m.getMove(), m);
		}
	}

	public String getName() {
		return name;
	}

	public byte getValue() {
		return value;
	}

	public boolean has(final CartesianMove legalMove) {
		return neighbourMoves.containsKey(legalMove);
	}

	public Key get(final CartesianMove legalMove) {

		final Move m = neighbourMoves.get(legalMove);
		return (m != null) ? m.getKey() : null;
	}

	public boolean isTopKey() {
		return isTopKey;
	}

	public boolean isBottomKey() {
		return isBottomKey;
	}

	@Override
	public String toString() {
		return "Key [" + (neighbourMoves != null ? "neighbourMoves=" + neighbourMoves + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + "value=" + value + ", isTopKey=" + isTopKey
				+ ", isBottomKey=" + isBottomKey + "]";
	}

}
