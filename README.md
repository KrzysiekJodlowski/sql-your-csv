# Sql your csv
Assignment for 4rd self-instructed week in Advanced room at Codecool.

Your goal is to write a program which will allow users to query their csv files using SQL. CSV tables should act as tables in the RDBMS. The marketing has already prepared a pricing plan for the application. It will also serve as a list of requirements. Here's how it looks.

## Basic version (free)
Allows:
- querying single csv file.
- selecting which columns should be displayed (SELECT * FROM xyz.csv; should also work).
- filtering data (using WHERE, >, <, =, <>, LIKE, AND, OR)

## Pro version (15$/month)
Allows everything from the basic version plus:
- aggregating data using SUM, AVG MAX, MIN

## Enterprise version (30$/month)
Allows everything from the pro version plus:
- filtering aggregates using HAVING
- joining data between multiple .csv files. (using JOIN abc.csv ON ...)

## DeLuxe version (100$/month)
Allows everything from the pro version plus:
- updating data using UPDATE
- deleting data using DELETE

## Recommendations
Try to implement this program using as much functional approach as possible. Don't start this project if you don't feel comfortable with FP. Only basic version is required for the SI. You can finish advanced features in the TW.
- Use Spring for Dependency Injection.
- Write tests.
- Don't forget about OOP of course.
- Your program should actually do four things: parse query and say if it's correct, load data from file and check whether it's structure is correct, query the data, display the data
- It would be nice if it was a web app.
