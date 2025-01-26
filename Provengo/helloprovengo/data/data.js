/* @provengo summon selenium */

/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/';
const studentUsername = 'student'
const studentPassword = 'Student123!'
const teacherUsername = 'teacher'
const teacherPassword = 'Teacher123!'

const xpaths = {
  loginWindowButton: "",

  loginWindow:{
    usernameInput: "",
    passwordInput: "",
    loginButton: "",
  },

  studentWindow:{
    studentCoursesButton: "",
    studentTestCourseButton: "",
    studentForumButton: "",
    DiscussionSubscriptionButton: "",
  },

  teacherWindow:{
    teacherCoursesButton: "",
    teacherTestCourseButton: "",
    teacherForumButton: "",
    deleteDiscussionFirstButton: "",
    deleteDiscussionSeconedButton: "",
  }

}

// const URL = 'https://www.google.com/?hl=en';

// const xpaths = {
//   searchWindow: {
//     searchInput: '//textarea[@aria-label="Search"]',
//     searchButton: '//input[@aria-label="Google Search"]',
//     feelingLuckyButton: '//input[@aria-label="I\'m Feeling Lucky"]'
//   }
// }

// const searchTerm = 'pizza'
