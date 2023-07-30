#Task

Implement a library providing SortedLinkedList
(linked list that keeps values sorted). It should be
able to hold string or int values, but not both. Try to
think about what you'd expect from such library as a
user in terms of usability and best practices, and
apply those

##Prerequisites
###1.  Java version 17 and above
###2.  Maven version 3 and above

##Getting started
###1. Running the app
Use maven commands to run the app.

`mvn spring-boot:run "-Dspring-boot.run.arguments=given_list_of_elements"`

Using the command above you should see a result similar to this

`a2,
a0,
a1,
Given elements
a0,
a1,
a2,
Sorted elements`

###2. Running tests
`mvn test`