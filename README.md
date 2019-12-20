# ohtu-ts

[![CircleCI](https://circleci.com/gh/joonashak/ohtu-ts.svg?style=svg)](https://circleci.com/gh/joonashak/ohtu-ts)
[![codecov](https://codecov.io/gh/joonashak/ohtu-ts/branch/master/graph/badge.svg)](https://codecov.io/gh/joonashak/ohtu-ts)
[![Maintainability](https://api.codeclimate.com/v1/badges/ab2398877100ad796899/maintainability)](https://codeclimate.com/github/joonashak/ohtu-ts/maintainability)

## Installation

Database migrations must be run before the first time this app is used and if the schema has changed. (Yes, this is inconvenient, but the migration library in use doesn't really support terminal interfaces...)

```bash
gradle run --args=--migrate
```

JAR:

```bash
java -jar ohtu-ts.jar --migrate
```

## Usage

### Run unit tests

```bash
gradle test
```

### Generate code coverage report

```bash
gradle jacocoTestReport
```

## Documentation

[Sprint backlog](https://docs.google.com/spreadsheets/d/1Ac3qACtyknZ2TekVcMgAAftpzhx3A5oApzwwDwFgvnk/edit#gid=7)

[User manual](docs/user_manual.md)

[Definition of done](docs/definition_of_done.md)

## Raport
[Course raport](https://docs.google.com/document/d/1f2tpWt6j93Y3QFlxFU5uYJwoz97w6mu9JaoNEV8iOyk/edit#heading=h.ij4zqwxjnfdn)
