package toy.keypad;

import static toy.keypad.Key.build;
import static toy.keypad.Key.buildBottom;
import static toy.keypad.Key.buildTop;
import static toy.keypad.Move.of;
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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("boxing")
public class KeyPad implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Map<Integer, Key> keys = new HashMap<>();

	public Key getKey(final int number) {
		return keys.get(number);
	}

	private Key key(final int number) {
		return keys.get(number);
	}

	public KeyPad() {
		init();
		mapNeighbouringMovesOntoKeys();
	}

	// 1 2 3
	// 4 5 6
	// 7 8 9
	// * 0 #

	private void init() {

		final Key key1 = buildTop("1"), key2 = buildTop("2"), key3 = buildTop("3"),

				key4 = build("4"), key5 = build("5"), key6 = build("6"),

				key7 = buildBottom("7"), key8 = buildBottom("8"), key9 = buildBottom("9"),

				key0 = buildBottom("0");

		keys.put(1, key1);
		keys.put(2, key2);
		keys.put(3, key3);
		keys.put(4, key4);
		keys.put(5, key5);
		keys.put(6, key6);
		keys.put(7, key7);
		keys.put(8, key8);
		keys.put(9, key9);
		keys.put(0, key0);
	}

	public void mapNeighbouringMovesOntoKeys() {

		key(1).addMoves(of(NONE, key(1)), of(SOUTH, key(4)), of(EAST, key(2)),

				of(SOUTHEAST, key(5)), of(L4, key(6)), of(L5, key(8)));

		key(2).addMoves(of(NONE, key(2)), of(SOUTH, key(5)), of(WEST, key(1)),

				of(EAST, key(3)), of(SOUTHWEST, key(4)), of(SOUTHEAST, key(6)),

				of(L5, key(9)), of(L7, key(7)));

		key(3).addMoves(of(NONE, key(3)), of(SOUTH, key(6)), of(WEST, key(2)),

				of(SOUTHWEST, key(5)), of(L7, key(8)), of(L8, key(4)));

		key(4).addMoves(of(NONE, key(4)), of(NORTH, key(1)), of(EAST, key(5)),

				of(SOUTH, key(7)), of(SOUTHEAST, key(8)), of(NORTHEAST, key(2)),

				of(L1, key(3)), of(L4, key(9)));

		key(5).addMoves(of(NONE, key(5)), of(NORTH, key(2)), of(NORTHWEST, key(1)),

				of(NORTHEAST, key(3)), of(SOUTH, key(8)), of(SOUTHWEST, key(7)),

				of(SOUTHEAST, key(9)), of(WEST, key(4)), of(EAST, key(6)));

		key(6).addMoves(of(NONE, key(6)), of(NORTH, key(3)), of(SOUTH, key(9)),

				of(WEST, key(5)), of(NORTHWEST, key(2)), of(SOUTHWEST, key(8)),

				of(L7, key(7)), of(L11, key(1)));

		key(7).addMoves(of(NONE, key(7)), of(NORTH, key(4)), of(EAST, key(8)),

				of(NORTHEAST, key(5)), of(SOUTHEAST, key(0)), of(L1, key(2)),

				of(L2, key(6)));

		key(8).addMoves(of(NONE, key(8)), of(NORTH, key(5)), of(SOUTH, key(0)),

				of(WEST, key(7)), of(EAST, key(9)), of(NORTHWEST, key(4)),

				of(NORTHEAST, key(6)), of(L1, key(3)), of(L11, key(1)));

		key(9).addMoves(of(NONE, key(9)), of(NORTH, key(6)), of(WEST, key(8)),

				of(NORTHWEST, key(5)), of(SOUTHWEST, key(0)), of(L10, key(4)),

				of(L11, key(2)));

		key(0).addMoves(of(NONE, key(0)), of(NORTH, key(8)), of(NORTHWEST, key(7)),

				of(NORTHEAST, key(9)), of(L1, key(4)), of(L11, key(6)));
	}

}
