# Find-It-Buddy  

Progress Report #2, 11/27

Paul:  
Fixed database components, added HistoryActivity functionality and UI, refactoring.  
Integrated all team members' changes, runs without error.   
WordCursorAdapter.java WordContract.java  
WordDBHelper.java  WordProvider.java  
HistoryActivity.java Strings.xml  
activity_history.xml list_item.xml  

Ron:
I used the google vision api and edited it to search for a term inside the textblocks.
Added:
OcrCaptureActivity.java
This is the activity that scans for the term the user is searching for.
OcrDetectorProcessor.java
Processes the image in the camerasource to see if there is any text in the frame.
OcrGraphic.java
Draw a box around the text that was being searched for.

Nil:
dataEntry.java
Allows the user to add information about terms searched. This includes feilds for the source of the term, description of why the
user searched for the term, and an optional definition field for vocab words.
DataHolder.java
This is a class that contains static fields to hold the string the user would like to search for. It is accessed by a number of different classes to find out what the user would like to search for.
Working on adding the ability to send a frame to the cloud and return more accuratly marked up version of the pictuere and words location. Java files for this will come in next upadted
