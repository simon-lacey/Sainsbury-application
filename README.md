groceries site scraper

Sainsbury-application is a console application that scrapes a number of pages in the Sainsbury’s fruit grocery site and
prints out a JSON array of the scraped information (title, calories, unit price and product description)..

GitHub project repository:
source tree

Project's source tree looks like:

.
|-- nbproject
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- sainsbury
    |               `-- scraper
    `-- test
        `-- java
            `-- com
                `-- sainsbury
                    `-- scraper

As you can see, the code resides in the com.sainsbury.scraper package (both testing, and regular).
dependencies

scraper depends on just few popular libraries/frameworks:

    json-simple - for JSON data manipulation.
    jsoup - for HTML parsing and DOM manipulation as well as web connections.
    junit and hamcrest - for testing.

running the application

The simplest way to run the application is to clone the repository, and use Maven to install and then run it through an
IDE like IntelliJ:

mvn install

This will allow you to run it from a console
mvn exec:java

I have also configured maven to package all dependencies in a single, executable JAR. To generate this JAR file execute

mvn package

After that you can run the application with simple:

java -jar target/scraper-1.0-SNAPSHOT.jar

To execute tests run:

mvn test

Here is an example output:

.
.
.
------------------------------------------------------
 T E S T S
-------------------------------------------------------
Picked up _JAVA_OPTIONS: -Dsun.java2d.noddraw=true -Dsun.java2d.xrender=true
Running com.sainsbury.scraper.SiteScraperTest
ProductInfo{title=Sainsbury's Avocado Ripe & Ready XL Loose 300g, size=35.0, unitPrice=1.5, description=Avocados}
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.648 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
