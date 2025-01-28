/* @provengo summon selenium */
/* @provengo summon ctrl */


/**
 * BThread: Student Subscribes to a Forum Discussion
 * 
 * This thread simulates a student logging in, navigating to a test course,
 * and subscribing to a forum discussion.
 */
bthread("studentSubscribesToAForumDiscussion", function(){
  let session1 = new SeleniumSession('studentMoodleSession')
  session1.start(URL)
  sync({request: Event("End-findLoginPageAndLogin")}, findLoginPageAndLogin(session1, studentUsername, studentPassword))
  sync({request: Event("End-goToTestCourse")}, goToTestCourse(session1))
  sync({request: Event("End-enterToForumDiscussionAndSubscribe")},enterToForumDiscussionAndSubscribe(session1))
});

/**
 * BThread: Teacher Deletes a Forum Discussion
 * 
 * This thread simulates a teacher logging in, navigating to a test course,
 * and deleting a forum discussion.
 */
bthread("teacherDeletesTheForumDiscussion", function(){
  let session2 = new SeleniumSession('teacherMoodleSession')
  session2.start(URL)
  sync({request: Event("End-findLoginPageAndLogin")}, findLoginPageAndLogin(session2, teacherUsername, teacherPassword))
  sync({request: Event("End-goToTestCourse")}, goToTestCourse(session2))
  sync({request: Event("End-enterToForumDiscussion")}, enterToForumDiscussion(session2))
  sync({request: Event("End-deleteDiscussion")}, deleteDiscussion(session2))
});


/**
 * BThread: Teacher Deletes the Discussion While Student Is Waiting
 * 
 * Ensures that the teacher deletes the discussion before the student can subscribe,
 * simulating a race condition or concurrent interaction.
 */
bthread("teacherDeletesTheDiscussionWhileStudentIsWaiting", function(){
  sync({waitFor:Event("End-deleteDiscussion")})
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
