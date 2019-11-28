package ohtu.ts.domain;

/**
 * Command definitions with numbered shortcuts.
 * @author Joonas Häkkinen
 */
public enum Commands {
    ADD(1, "Lisää lukuvinkki"),
    LIST_ALL(2, "Selaa lukuvinkkejä"),
    QUIT(3, "Lopeta");

    // enum fields
    int code;
    String tooltip;

    /**
     * Named command with shortcut and tooltip text.
     * @param code Numbered shortcut, user enters this as a command.
     * @param tooltip Text describing this command.
     */
    private Commands(int code, String tooltip) {
        this.code = code;
        this.tooltip = tooltip;
    }

    public int getCode() {
        return code;
    }

    public String getTooltip() {
        return tooltip;
    }
}
