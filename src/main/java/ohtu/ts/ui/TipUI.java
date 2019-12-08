package ohtu.ts.ui;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;

/**
 * Interface specification for classes responsible for providing user prompts
 * and object construction to read and write differents types of reading tips.
 * @author Joonas Häkkinen
 */
public interface TipUI {

    /**
     * Get reading tip data from the user.
     * Prompt the user for the fields relating to a specific type of ReadingTip
     * specified by the class implementing this interface.
     * @param io IO object to use in prompting.
     * @return populated ReadingTip object.
     */
    public ReadingTip getTipFromUser(IO io);

    /**
     * Textual representation of ReadingTip.
     * This text should be in a format that can be used for output printing.
     * @param readingTip ReadingTip instance matching the class implementing TipUI.
     * @return Textual representation of given readingTip.
     */
    public String toString(ReadingTip readingTip);
}
