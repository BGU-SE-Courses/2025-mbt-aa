# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [Moodle](https://moodle.org).

Moodle is a learning platform designed to provide educators, administrators, and learners with a single robust, secure, and integrated system to create personalized learning environments. 

## Installation
To use this project, follow these steps:


1. **Clone the Repository**  
   Begin by cloning this repository to your local machine.

2. **Navigate to the Project Directory**  
   Move into the project's directory using your terminal or file explorer.

3. **Install Provengo**  
   Follow the [Provengo Installation Guide](https://docs.provengo.tech/ProvengoCli/0.9.5/installation.html) to install and validate Provengo.

4. **Ensure Selenium Server is Running**  
   Verify that the Selenium Server is operational. For more information, refer to the `Selenium/README.md` file in the project directory.

5. **Install Graphviz**  
   Install Graphviz to generate PDF graphs. Visit [Graphviz.org](https://graphviz.org/) to download it.

6. **Install Moodle**
   Install [Moodle](https://download.moodle.org/releases/latest/) on your local host by completing the following steps:

   Download the latest version suitable for your operating system from the Moodle Installation page.
   Extract the downloaded zip file to your Desktop.
   Run the setup process as described in the README.txt file included with the Moodle package.
7. **Cucumber** use the cucumber files in the repository
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

