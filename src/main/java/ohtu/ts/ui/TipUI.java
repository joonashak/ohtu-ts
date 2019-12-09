package ohtu.ts.ui;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
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

    /**
     * Find a TipUI by type.
     * @param type Types to choose TipUI class by.
     * @return instance of a class implementing TipUI.
     */
    public static TipUI selectTipUI(Types type) {
        switch (type) {
            case BOOK:
                return new BookTipUI();
            case VIDEO:
                return new VideoTipUI();
            case BLOG:
                return new BlogTipUI();
            default:
                return null;
        }
    }

    /**
     * Find a TipUI for give ReadingTip.
     * This is a convenience method for using TipUI.selectTipUI(Types) with
     * a ReadingTip instance rather than type id.
     * @param readingTip ReadingTip to choose TipUI class by.
     * @return instance of a class implementing TipUI.
     */
    public static TipUI selectTipUi(ReadingTip readingTip) {
        return selectTipUI(readingTip.getType());
    } 
}
