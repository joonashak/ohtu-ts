CREATE TABLE NewReadingTip (
  id INTEGER PRIMARY KEY,
  type_id INTEGER,
  title TEXT,
  author TEXT,
  isbn TEXT
);

INSERT INTO NewReadingTip(id, type_id, title, author, isbn)
SELECT id, type_id, title, author, isbn
FROM ReadingTip;

DROP TABLE Type;
DROP TABLE ReadingTip;

ALTER TABLE NewReadingTip RENAME TO ReadingTip;
