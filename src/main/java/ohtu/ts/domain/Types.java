package ohtu.ts.domain;

/**
 * Type definitions for ReadingTips.
 * @author Joonas Häkkinen
 */
public enum Types {
    BOOK(1, "Kirja"),
    VIDEO(2, "Video");

    // enum fields
    int id;
    String name;

    Types(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Finds the type with the given code.
     * @param id type id to search with.
     * @return Type with the corresponding id or null if not found.
     */
    public static Types find(int id) {
        for (Types t : Types.values()) {
            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
