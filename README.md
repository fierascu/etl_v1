# etl_v1
Extract, Transform, Load some input files


## Synopsis

This project is a java implementation used for extractintg multiple date from cvs filse, transforme it and wrtite it back on another csv format.
Many lines of code are from https://github.com/fierascu/blrParseSitemap


## Used

- IntelliJ IDE,
- Maven for dependencies,
- Opencsv library for csv support, but also use lambda functions for reading data,
- Log4j for logging,
- Yahoo currency api for RON/EUR/USD values.

## Installation and build

Just run it from intelliJ or use  maven "package" target.
Use "java -jar target/etl_v1-1.0-SNAPSHOT-jar-with-dependencies.jar" to run resulted fat jar.

## Tests

Used local files for multiple parsing test.

## Possible future improvements

Automate reading columns names, and create java classes at runtime from csv files

## License

Released under Apache License