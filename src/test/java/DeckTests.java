import org.darkware.hero.base.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jeff
 * @since 2015-08-17
 */
public class DeckTests
{
    @Test
    public void manipulationTests()
    {
        Deck<String> d = new Deck();

        d.add("A");

        assertEquals(1, d.size());
        assertEquals("A", d.take());

        d.clear();

        assertEquals(0, d.size());

        d.add("A", "B", "C");

        assertEquals(3, d.size());

        String[] a1 = { "D", "E" };
        d.add(a1);

        assertEquals(5, d.size());

        List<String> a2 = new ArrayList<String>();
        a2.add("F");
        a2.add("G");
        d.add(a2);

        assertEquals(7, d.size());
        assertEquals("A", d.peek());
        d.take();
        assertEquals("B", d.take());
        assertEquals(5, d.size());
    }

    @Test
    public void shuffleTests()
    {
        // We can't assume any position after a shuffle is either good or bad
        // so we only test the things that we can prove are invariant.

        Deck<String> d = new Deck<String>();
        d.add("A", "B", "C", "D");

        assertEquals(4, d.size());

        d.shuffle();

        assertEquals(4, d.size());

        d.add("E", "F");
        d.shuffle();

        assertEquals(6, d.size());
    }

    @Test
    public void invalidStates()
    {
        Deck<String> d = new Deck<String>();

        try
        {
            d.take();
            Assert.fail("Allowed take on an empty deck.");
        }
        catch (IllegalStateException e)
        {
            // Expected
        }

        try
        {
            d.pick();
            Assert.fail("Allowed pick on an empty deck.");
        }
        catch (IllegalStateException e)
        {
            // Expected
        }

        try
        {
            d.peek();
            Assert.fail("Allowed peek on an empty deck.");
        }
        catch (IllegalStateException e)
        {
            // Expected
        }
    }
}
