import org.darkware.hero.base.Range;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author jeff
 * @since 2015-08-16
 */
public class RangeTests
{
    @Test
    public void constructorTests()
    {
        Range r1 = new Range(7, 14);

        assertEquals(7, r1.getStart());
        assertEquals(14, r1.getEnd());
    }

    @Test
    public void illegalValues()
    {
        try
        {
            Range r1 = new Range(20, 18);
        }
        catch (IllegalArgumentException e)
        {
            return;
        }

        Assert.fail();
    }

    @Test
    public void equalityTests()
    {
        Range r1 = new Range(1, 50);

        assertEquals(new Range(1, 50), r1);
        assertNotEquals(new Range(1, 40), r1);
    }

    @Test
    public void parseTests()
    {
        Range r1 = new Range(1, 10);

        Range p1 = new Range("1..10");
        assertEquals(r1, p1);

        Range p2 = new Range("[1..10]");
        assertEquals(r1, p2);

        Range p3 = new Range("<1..10>");
        assertEquals(r1, p3);

        Range p4 = new Range("  < 1.. 10>");
        assertEquals(r1, p4);

        Range p5 = new Range("1-10");
        assertEquals(r1, p5);

        Range p6 = new Range(" 1-10 ");
        assertEquals(r1, p6);

        Range p7 = new Range("-10-1");
        assertEquals(new Range(-10, 1), p7);

        Range p8 = new Range("-10..-1");
        assertEquals(new Range(-10, -1), p8);

        Range p9 = new Range("-10--1");
        assertEquals(new Range(-10, -1), p9);
    }

    @Test
    public void parseFailureTests()
    {
        Range r1 = new Range(1, 10);

        final String[] invalid = { "", "1-", "[1-10)", "10-3", "[1-5" };

        for (String s : invalid)
        {
            try
            {
                Range r = new Range(s);
                Assert.fail();
            }
            catch (IllegalArgumentException e)
            {
                // Expected
            }
        }
    }
}
