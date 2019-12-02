package ohtu.ts.ui;

/**
 * Command definitions with numbered shortcuts.
 *
 * @author Joonas Häkkinen
 * @author Arttu Mykkänen
 */
public enum Commands {
    ADD(1, "Lisää lukuvinkki"),
    LIST_ALL(2, "Selaa lukuvinkkejä"),
    QUIT(3, "Lopeta");

    // enum fields
    private int code;
    private String tooltip;

    /**
     * Named command with shortcut and tooltip text.
     *
     * @param code Numbered shortcut, user enters this as a command.
     * @param tooltip Text describing this command.
     */
    private Commands(int code, String tooltip) {
        this.code = code;
        this.tooltip = tooltip;
    }

    /**
     * Finds the command with the given code.
     *
     * @param code command code to search with.
     * @return Command with the corresponding code or null if not found.
     */
    public static Commands find(int code) {
        for (Commands cmd : Commands.values()) {
            if (cmd.getCode() == code) {
                return cmd;
            }
        }

        return null;
    }

    public int getCode() {
        return code;
    }

    public String getTooltip() {
        return tooltip;
    }
}
