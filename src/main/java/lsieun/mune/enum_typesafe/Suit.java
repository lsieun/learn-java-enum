package lsieun.mune.enum_typesafe;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Suit implements Comparable<Suit>, Serializable {
    private final String name;

    // Ordinal of next suit to be created
    private static int nextOrdinal = 0;

    // Assign an ordinal to this suit
    private final int ordinal = nextOrdinal++;

    private Suit(String name) { this.name = name; }

    public String toString()  { return name; }

    @Override
    public int compareTo(Suit another) {
        return this.ordinal - another.ordinal;
    }

    private Object readResolve() throws ObjectStreamException {
        return PRIVATE_VALUES[ordinal]; // Canonicalize
    }

    public static final Suit CLUBS    = new Suit("clubs");
    public static final Suit DIAMONDS = new Suit("diamonds");
    public static final Suit HEARTS   = new Suit("hearts");
    public static final Suit SPADES   = new Suit("spades");

    private static final Suit[] PRIVATE_VALUES = { CLUBS, DIAMONDS, HEARTS, SPADES };
    public static final List<Suit> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
}