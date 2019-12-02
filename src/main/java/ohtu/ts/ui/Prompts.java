package ohtu.ts.ui;

import ohtu.ts.domain.Types;
import ohtu.ts.io.IO;

/**
 * Collection of prompts to get input from the user.
 *
 * @author Joonas Häkkinen
 */
public class Prompts {

    /**
     * Get a command from the user. Lists possible commands and prompts user to
     * select one as a number. Repeats until a number is entered.
     *
     * @param io IO object for prompting the user.
     * @return Commands or null if not found.
     */
    public static Commands getCommandFromUser(IO io) {
        StringBuilder prompt = new StringBuilder("\nAnna haluamasi komennon numero:\n");

        for (Commands cmd : Commands.values()) {
            prompt.append(String.format("    %s.  %s\n", cmd.getCode(), cmd.getTooltip()));
        }

        prompt.append("\n>> ");

        // Handle invalid input (strings) recursively.
        try {
            int i = io.readInt(prompt.toString());
            return Commands.find(i);
        } catch (Exception e) {
            return getCommandFromUser(io);
        }
    }

    /**
     * Get a reading tip type from the user. Lists possible types and prompts
     * user to select one as a number. Repeats until a number is entered.
     *
     * @param io IO object for prompting the user.
     * @return Types or null if not found.
     */
    public static Types getTypeFromUser(IO io) {
        StringBuilder prompt = new StringBuilder("\nAnna lukuvinkin tyypin numero:\n");

        for (Types t : Types.values()) {
            prompt.append(String.format("    %s.  %s\n", t.getId(), t.getName()));
        }

        prompt.append("\n>> ");

        // Handle invalid input recursively.
        try {
            int i = io.readInt(prompt.toString());
            return Types.find(i);
        } catch (Exception e) {
            return getTypeFromUser(io);
        }
    }
}
