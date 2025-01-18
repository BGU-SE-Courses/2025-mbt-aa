# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [Moodle](https://address-of-the-project.com).

Moodle is a learning platform designed to provide educators, administrators, and learners with a single robust, secure, and integrated system to create personalized learning environments. 

## Installation
$$*TODO* Write instructions on how to install the software and prepare the testing environment$$

## What we tested
We tested the Forum discussion module, which enables both students and teachers to have discussions and post comments, but is managed by the teacher only, and the students can subscribe to the discussion for notifications.
We chose to test the following user stories: 

User story 1: The student subscribes to a forum discussion.

Preconditions: There is a course which is managed by a teacher, There is a student which is signed up to the course, The course contains a forum, The forum contains a discussion.

Expected outcome: The student is subscribed to the discussion.

User story 2: The teacher deletes the discussion.

Preconditions: There is a course which is managed by the teacher, The course contains a forum, The forum contains a discussion.

Expected outcome: The discussion is deleted successfully.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

## Detected Bugs
We detected the following bugs:

1. Bug 1: 
   1. General description: ...
   2. Steps to reproduce: ...
   3. Expected result: ...
   4. Actual result: ...
   5. Link to the bug report: (you are encouraged to report the bug to the developers of the software)
2. Bug 2: ...

$$*TODO* if you did not detect the bug, you should delete this section$$  
