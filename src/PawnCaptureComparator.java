import java.util.Comparator;

/**
 * Compares two {@code Pawn}s according to order specified in part 2 section s of the assignment.
 */
public class PawnCaptureComparator implements Comparator<Pawn> {
    private final Player winner;
    /**
     * Constructs a new comparator with a specified winner, the identity of the winner has implications for the
     * comparison.
     * @param w the winner
     */
    public PawnCaptureComparator(Player w) {
        winner = w;
    }
    /**
     * Compare two pawns according to the following rules:
     * <br>First, reverse order by number of captures.
     * <br>If they are equal, forward order by their IDs.
     * <br>If they are also equal, piece whose owner is the winner comes first.
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @return integer according to order definition
     */
    @Override
    public int compare(Pawn o1, Pawn o2) {
        int cComp = Integer.compare(o2.getCaptures(), o1.getCaptures());
        if (cComp != 0) return cComp;
        int iComp = Integer.compare(o1.id, o2.id);
        if (iComp != 0) return iComp;
        if (o1.getOwner() == o2.getOwner()) return 0;   // should be unreachable
        if (o1.getOwner() == winner) return -1;
        return 1;
    }
}
