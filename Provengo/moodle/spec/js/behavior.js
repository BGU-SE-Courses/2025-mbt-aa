/* @provengo summon selenium */
/* @provengo summon ctrl */


bthread("studentSubscribesToAForumDiscussion", function(){
  let session1 = new SeleniumSession('studentMoodleSession')
  session1.start(URL)
  sync({request: Event("End-findLoginPageAndLogin")}, findLoginPageAndLogin(session1, studentUsername, studentPassword))
  sync({request: Event("End-goToTestCourse")}, goToTestCourse(session1))
  sync({request: Event("End-enterToForumDiscussionAndSubscribe")},enterToForumDiscussionAndSubscribe(session1))
});


bthread("teacherDeletesTheForumDiscussion", function(){
  let session2 = new SeleniumSession('teacherMoodleSession')
  session2.start(URL)
  sync({request: Event("End-findLoginPageAndLogin")}, findLoginPageAndLogin(session2, teacherUsername, teacherPassword))
  sync({request: Event("End-goToTestCourse")}, goToTestCourse(session2))
  sync({request: Event("End-enterToForumDiscussionAndDeleteDiscussion")}, enterToForumDiscussionAndDeleteDiscussion(session2))
});

// this bthread assures that after the teacher deleted the discussion, the student cant subscribe to it
bthread("teacherDeletesTheDiscussionWhileStudentIsWaiting", function(){
  sync({waitFor:Event("End-enterToForumDiscussionAndDeleteDiscussion")})
  sync({block: Event("Start-enterToForumDiscussionAndSubscribe")})
});



// /**
//  * This story opens a new browser window, goes to google.com, and searches for "Pizza".
//  */
// bthread('Search', function () {
//   let s = new SeleniumSession('search');
//   s.start(URL)
//   composeQuery(s, { text: 'Pizza' })
//   startSearch(s)
// })

// /**
//  * This story opens a new browser window, goes to google.com, and searches for "Pasta" using the "I Feel Lucky" feature.
//  */
// bthread('Feeling lucky', function () {
//   let s = new SeleniumSession('lucky');
//   s.start(URL)
//   composeQuery(s, { text: 'Pasta' })
//   feelLucky(s)
// })
