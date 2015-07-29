package org.darkware.hero.language;

import org.darkware.hero.util.TextUtils;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class BaseLanguage
{


    public BaseLanguage()
    {

    }

    public String createName(Gender gender)
    {
        List<PhonemeTag> template = new ArrayList<PhonemeTag>();

        template.add(PhonemeTag.NAME_SUPER);
        template.add(PhonemeTag.NAME_SUFFIX);
        template.add(PhonemeTag.NAME_OBJ);

        List<Phoneme> phonemes = new ArrayList<Phoneme>();

        for (PhonemeTag tag : template)
        {
            Phoneme part = Phonemes.global().filter(gender).filter(tag).pickRandom();
            phonemes.add(part);
        }

        return TextUtils.join("-", phonemes).toString();
    }
}
