Gig Scheduler is made up of two parts. Below is some general background information that applies to both parts.

Database Requirements
  1. We're going to call our concerts "Gigs."

Gigs have:
  1. a name (less than or equal to 100 chars),
  2. a start date/time,
  3. a description (less than or equal to 1,000 chars),
  4. a ticket cost,
  5. a link to an external site (e.g., Ticketmaster) to buy tickets (optional) (less than or equal to 100 chars),
     and a generic notes field, that will handle any other misc. details (e.g., "Get $1 off ticket price at the door when you bring a canned food item for the food bank.") (less than or equal to 500 chars).

A gig may have any number (0 or more) of associated Bands. Associated Bands are either "headliners" or not headliners (a boolean distinction between the two is sufficient). A headliner is the primary band (usually the biggest band and the last to play) playing at a gig. Sometimes a gig has multiple headliners, but usually it's just one.

A band has: - a unique name (less than or equal to 50 chars), - a hometown (less than or equal to 50 chars), - a website URL (optional) (less than or equal to 500 chars), - and the URL to an image with a picture of that band (optional) (less than or equal to 500 chars).

The optional fields are not always required (they can be null), but are rarely empty.

Appropriate foreign keys are used.


Scheduling System Requirements
The scheduling system requirements agreed upon by your team are as follows:
  1. The scheduling system must run in the command line.
  2. The user should be able to choose between figuring out how to operate the application (a help menu of some kind), adding a new Gig, viewing the entire schedule, and quitting the application.
  3. If the user chooses to add a new gig, they need to be able to enter all of the required information about the new gig with a separate prompt for each piece of information (not just a single super-prompt          that includes all the details).
  4. Bands should be added at Gig creation. If a Band with the name given by the user already exists in the database, the user does not need to be prompted to enter all the extra info, but if the Band name does       not already exist, the user does need to be prompted to enter all the other Band info.
  5. The contracts signed by the bands are legally binding, and the consequences for canceling a concert are extreme, so deleting/editing Gigs and Bands is not necessary.
  6. If the user chooses to view the entire schedule, the system should ask for a start date (default is no start date) and an end date (inclusive, default is no end date).
  7. All results on the "entire schedule" should appear in chronological order (the gigs that will happen first should appear first).
  8. When displaying results on the "entire schedule," if there are two Gigs which start at the same time, the ordering of the two Gigs does not matter.
  9. When displaying results on the "entire schedule" headliner bands should always be listed before any other bands. If there is more than one headliner for a Gig, the order of the headliners does not matter.
  10. The output for each Gig should be organized, should include all of the non-null information, should not include any of the null information, and should be easy to read.
  11. Requests for input should always include examples of what the user should type (e.g. MM/DD/YY or e.g. 02/12/2021).
  12. User input for date and time fields can be defined however you like, but should be consistent & easy for the user to communicate. No weird or contrived formats. The database should make use of built-in           types for storing dates and times.
  13. The system must utilize a local MySQL server (with an easily accessible connection string), the Java programming language, and JDBC.
  14. The database should include foreign keys between the appropriate tables.
  15. The program should accept no command-line arguments on startup.

Step 1: Database Design:

Step 2: Database Implementation, Seeding, & Script Writing Add:

6 bands (both with and without null values in optional fields),
  1. a Gig that has no bands,
  2. a Gig that has 3 bands (no headliner),
  3. a Gig that has 5 bands (one headliner),
  4. a Gig that has 4 bands (three headliners),
  5. and a Gig with NULL values in every optional field and a single headlining band.

Step 3: Model and Accessor Classes: Add the following classes:

A "model" class for every major table. Add class variables and getters/setters for every column in the database table for that particular model. Relationships between models (e.g., a gig can have many bands) should be modeled appropriately according to object-oriented programming principles. For each class:
Create/implement appropriate constructors.
Create/implement necessary getters/setters.
Create a toString method. Test your function.
Create a static collectionToString method that accepts a list of objects of that type (e.g., a list of Bands) and returns a String including representations of each object in the list. Test your function.
An "accessor" interface for every model class. Each interface needs at least:
a Type getTypeByID(int id) function (e.g., Band getBandByID(int id)), and
a Type saveType(Type type) function (e.g., Band saveBand(Band band))
Comb through the requirements and add any additional functions you deem necessary for your accessor interfaces.
Step 4: Write/Test 1 Function with Input/Output Mocks

Create an interface and a mock class to automate user input for testing purposes. (Follow the same steps discussed in class.)
Create an interface and a mock class to automate console output for testing purposes. (Follow the same steps discussed in class.)
Create the GigScheduler class that depends on these two interfaces. Create appropriate constructors. (Remember: objects that utilize dependency injection require dependencies upon instantiation.)
Add a Band createBandFromInput() function in the GigScheduler class.
Prompt the user for the necessary information.
Provide input validation where relevant.
return a Band object.
Write thorough unit tests for createBandFromInput().
Gig Scheduler Part 2
Users should be able to input custom start and end dates. Implement any remaining features specified in the requirements (above) and connect their functions to the application loop.

Writing a User Manual Write a brief user manual so other Kauffman Koncerts team members can operate your application. You DO NOT want to be the only one who knows how to use your system. Nobody's got time for that. Ensure that the user manual is included in the top-level directory of your git repository with the filename USER_MANUAL. This file can have extension: .txt, .md, .pdf, .doc, .html, or .docx. No other file types will be allowed.
