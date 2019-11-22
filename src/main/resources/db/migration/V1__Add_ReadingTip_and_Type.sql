CREATE TABLE Type (
  id INTEGER PRIMARY KEY,
  name TEXT
);

INSERT INTO Type (id, name)
VALUES (
  1,
  "Kirja"
);

CREATE TABLE ReadingTip (
  id INTEGER PRIMARY KEY,
  title TEXT,
  author TEXT,
  isbn TEXT,
  type_id INTEGER NOT NULL,
  FOREIGN KEY (type_id)
    REFERENCES Type (id)
    ON DELETE RESTRICT
);
