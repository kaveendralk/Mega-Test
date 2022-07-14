@tag
Feature: File handling in cloud drive of MEGA.
  Create, delete and restore a file.

  @tag1 
  Scenario Outline: Test Case 1 - Create a text file
  	Given Open MEGA app
  	And User login to MEGA app using <email> and <password>
    And Navigate to Cloud Drive page
    When Create a text file named <fileName>
    And Type content as MEGATESTING in it and save
    Then Validate created <fileName> in cloud drive
    
   Examples: 
      | fileName  | email                 |password  |
      | a.txt     | kaveendralk@gmail.com |1Qaz2wsx@ |

  @tag2
  Scenario Outline: Test Case 2 - Delete the file
    When Delete the text file which is created in Test Case 1
    Then Validate file deletion in cloud drive

     Examples: 
      | fileName  | 
      | a.txt     |
      
  @tag2
  Scenario Outline: Test Case 3 - Resore the deleted file
    Given Navigate to rubbish bin
    When Select and restore <fileName>
    Then Validate restored <fileName> in cloud drive

     Examples: 
      | fileName  | 
      | a.txt     |