/* @provengo summon selenium */

function findLoginPageAndLogin(session, username, password){
  sync({request: Event("Start-findLoginPageAndLogin")})
  session.click(xpaths.loginWindowButton)
  session.writeText(xpaths.loginWindow.usernameInput, username)
  session.writeText(xpaths.loginWindow.passwordInput, password)
  session.click(xpaths.loginWindow.loginButton)
  sync({request: Event("End-findLoginPageAndLogin")})
}

function goToTestCourse(session){
  sync({request: Event("Start-goToTestCourse")})
  session.click(xpaths.studentWindow.studentCoursesButton)
  session.click(xpaths.studentWindow.studentTestCourseButton)
  sync({request: Event("End-goToTestCourse")})
}

function enterToForumDiscussionAndSubscribe(session){
  sync({request: Event("Start-enterToForumDiscussionAndSubscribe")})
  session.click(xpaths.studentWindow.studentForumButton)
  session.click(xpaths.studentWindow.DiscussionSubscriptionButton)
  sync({request: Event("End-enterToForumDiscussionAndSubscribe")})
}

function enterToForumDiscussionAndDeleteDiscussion(session){
  sync({request: Event("Start-enterToForumDiscussionAndDeleteDiscussion")})
  session.click(xpaths.teacherWindow.teacherForumButton)
  session.click(xpaths.teacherWindow.teacherEnterDiscussion)
  session.click(xpaths.teacherWindow.teacherDeleteDiscussion)
  session.click(xpaths.teacherWindow.teacherConfirmDelete)
  sync({request: Event("End-enterToForumDiscussionAndDeleteDiscussion")})
}


//
// function composeQuery(session, data) {
//   session.writeText(xpaths.searchWindow.searchInput, data.text)
// }
//
// function startSearch(session) {
//   with(session) {
//     click(xpaths.searchWindow.searchButton)
//   }
// }
//
// function feelLucky(session) {
//   with(session) {
//     click(xpaths.searchWindow.feelingLuckyButton)
//   }
// }
