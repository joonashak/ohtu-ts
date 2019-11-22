package ohtu.ts.domain;

/**
 * Type definitions for ReadingTips. Note that id and name must be
 * identical to the database table Type.
 * @author Joonas Häkkinen
 */
public enum Types {
    BOOK(1, "Kirja");

    // enum fields
    int id;
    String name;

    Types(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
