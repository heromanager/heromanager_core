import org.darkware.hero.util.TextUtils;
import org.junit.Test;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created: 2015-08-18
 */
public class TextUtilsTests
{
    @Test
    public void stripWhitespaceTests()
    {
        assertEquals("ABC", TextUtils.stripWhitespace("A B C"));
        assertEquals("ABC", TextUtils.stripWhitespace("    A BC"));
        assertEquals("ABC", TextUtils.stripWhitespace("ABC"));
        assertEquals("", TextUtils.stripWhitespace(""));
        assertEquals("ABC", TextUtils.stripWhitespace("A\rB\nC"));
        assertEquals("ABC", TextUtils.stripWhitespace("A\tB\tC"));
    }

    @Test
    public void joinTests()
    {
        assertEquals("A:B:C", TextUtils.join(":", "A", "B", "C").toString());
        assertEquals("A", TextUtils.join(":", "A").toString());
        assertEquals("ABC", TextUtils.join("", "A", "B", "C").toString());

        String[] a1 = { "A", "B", "C" };
        assertEquals("A:B:C", TextUtils.join(":", a1).toString());

        List<String> c1 = new ArrayList<String>();
        Collections.addAll(c1, a1);
        assertEquals("A:B:C", TextUtils.join(":", c1).toString());

        String[] a2 = { };
        assertEquals("", TextUtils.join(",", a2).toString());

        List<String> c2 = new ArrayList<String>();
        assertEquals("", TextUtils.join("?", c2).toString());
    }
}
