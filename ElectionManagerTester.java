/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Election Manager
// Course:   CS 300 Fall 2024
//
// Author:   Dillan Haran
// Email:    dharan2@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         N/A
// Online Sources:  https://apcentral.collegeboard.org/media/pdf/ap-computer-science-a-java-
//quick-reference_0.pdf
// -Used it as a reference for Java syntax (ex. compareTo)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
 * Class used to test each of the ElectionManager class methods
 */

public class ElectionManagerTester {
	
	/**
	 * Tests if candidate is found in an empty candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
    
  public static boolean testContainsEmpty() {
    // for your use: an "empty" candidate list
    String[][] candidateList = {null, null, null, null, null, null};
    int size = 0;
    String targetName = "Wooper";
    String targetParty = "Water";
    boolean expected = false;
    boolean actual = 
    		ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
    
    if (expected != actual) // checks if return value same as expected
    {
    	return false;  
    }
    return true;
  }
  
	/**
	 * Tests a candidate not found in the candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testDoesNotContain() {
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "127"},
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
	  int size = 3;
	  // test variables that are not in array
	  String targetName = "Test";
	  String targetParty = "TestParty";
	  boolean expected = false;
		    
	  boolean actual = 
			  ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
		    
	  if (expected != actual) return false; // checks if return value expected
		    
	  
	  // checks if array is changed
	  if (!Arrays.deepEquals(candidateList, candidateCopy)) return false; 
		    
	  return true;  
  }
  
  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a candidate has
   * already been added to the race.
   * 
   * NOTE: This method ONLY tests scenarios where the candidate IS PRESENT in the list;
   * situations where the candidate is not present or the list is empty should be
   * tested in the other contains tester methods.
   * 
   * @return false if any of the scenarios we test have results other than what we expect;
   * true ONLY if all of our expectations are met by the method we are testing
   */
  public static boolean testDoesContain() { 
    
    // (1a) set up the test variables
    String[][] candidateList = {
        {"Slowpoke", "Water", "3"},
        {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"},
        null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    String targetName = "Wooper";
    String targetParty = "Water";
    boolean expected = true;
    
    // (1b) call the method we are testing
    boolean actual = 
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
    
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual) return false;
    
    // (3) since THIS method should not modify the array, check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy)) return false;
    
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
    
  }
  
    
	/**
	 * Tests if candidate is added to an empty candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  public static boolean testAddToEmpty() {
	  // test with an empty array
	  String[][] candidateList = {
		        null, null, null};
	  String newName = "Goldeen";
	  String newParty = "Water";
	  int newVotes = 5;
		    
	  String[][] expectedList = {
		        {"Goldeen", "Water", "5"}, 
		        null, null};  
	  int size = 0;
	  int expected = 1;
		    
	  int actual = 
			  ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);  
	  if (expected != actual) return false; // checks if candidates count increased 
		    
	  if (!Arrays.deepEquals(candidateList, expectedList)) return false; // checks if array is updated
		    
	  return true;  
  }
  
  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a new candidate has
   * been added correctly to the race.
   * 
   * @return false if any of the scenarios we test have results other than what we expect;
   * true ONLY if all of our expectations are met by the method we are testing
   */
  public static boolean testAddToNonEmpty() {
    
    // (1a) set up the test variables
    String[][] candidateList = {
        {"Slowpoke", "Water", "3"},
        {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"},
        null, null, null};
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;
    
    String[][] expectedList = {
        {"Goldeen", "Water", "5"}, // alphabetically first, new candidate will be added here
        {"Slowpoke", "Water", "3"},
        {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"},
        null, null};  // now only TWO null values in this length-6 array!
    int size = 3;
    int expected = 4;
    
    // (1b) call the method we are testing
    int actual = 
        ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);  
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual) return false;
    
    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList)) return false;
    
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }
  
	/**
	 * Tests if candidate already existing or candidate with negative votes is added to candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testAddCandidateErrors() {
	  // test variables
	  String[][] candidateList = {
			  {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "127"},
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  String newName = "Slowpoke";
	  String newParty = "Water";
	  int newVotes = 3;
	  
	  // expected list, nothing should change
	  String[][] expectedList = {
			  {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "127"},
		        {"Wooper", "Water", "300"},
		        null, null, null};  
	  int size = 3;
	  int expected = 3;
		    
	  int actual = 
			  ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);  
	  if (expected != actual) return false; // checks if return value expected
		    
	  if (!Arrays.deepEquals(candidateList, expectedList)) return false; // checks if array unchanged
	  
	  // test adding a candidate with negative votes
	  String newName2 = "Slow";
	  String newParty2 = "Wat";
	  int newVotes2 = -3;
	  
	  int actual2 = 
			  ElectionManager.addCandidate(candidateList, size, newName2, newParty2, newVotes2);  
	  if (expected != actual2) return false; // checks return value expected
		    
	  if (!Arrays.deepEquals(candidateList, expectedList)) return false; // checks if array unchanged
		    
	  return true;
  }
  
  
	/**
	 * Tests if candidate is added to a full candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  public static boolean testAddToFull() {
	  // tests full array
	  String[][] candidateList = {
			  {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "127"},
		        {"Wooper", "Water", "300"}};
	  String newName = "Goldeen";
	  String newParty = "Water";
	  int newVotes = 5;
		    
	  String[][] expectedList = {
			  {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "127"},
		        {"Wooper", "Water", "300"}};  
	  int size = 3;
	  int expected = 3;
		    
	  int actual = 
			  ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);  
	  if (expected != actual) return false; // checks if number of candidates is unchanged
		    
	  if (!Arrays.deepEquals(candidateList, expectedList)) return false; // checks if array is changed
		    
	  return true; 
  }
  
	/**
	 * Tests if candidate dropped in a candidate list with one candidate
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testDropOnlyCandidate() {
	  // tests an array with only obe candidate
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "3"},
		        null, null, null};
	  String[][] candidateExpected = {null, null, null, null};
	  String name = "Slowpoke";
	  String party = "Water";
	  int size = 1;
	  int expected = 0;
	    
	  int actual =
	        ElectionManager.dropCandidate(candidateList, size, name, party);
	    
	  if (expected != actual) return false; // checks if return value expected
	    

	    
	  if (!Arrays.deepEquals(candidateList, candidateExpected)) return false; 
	  // checks if array is changed accordingly
	    
	  return true;
  }
  
	/**
	 * Tests if candidate is dropped when they are the first candidate in candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testDropFirstCandidate() {
	  
	  String[][] candidateList = {
	            {"Slowpoke", "Water", "3"},
	            {"Squirtle", "Water", "127"},
	            {"Wooper", "Water", "300"},
	            null, null, null};
	  // array where first candidate dropped
	  String[][] candidateExpected = {
			  {"Squirtle", "Water", "127"},
	            {"Wooper", "Water", "300"},
	            null, null, null, null};
	  String name = "Slowpoke";
	  String party = "Water";
      int size = 3;
      int expected = 2;
	  int actual =
	            ElectionManager.dropCandidate(candidateList, size, name, party);
	        
	  if (expected != actual) return false; // checks if return value is expected
	        
	  if (!Arrays.deepEquals(candidateList, candidateExpected)) return false; 
	  // checks if array is changed to expected
	        
	  return true;  }
  
  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether trying to drop a
   * candidate who is not running in the race correctly has NO effect on the candidate list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect;
   * true ONLY if all of our expectations are met by the method we are testing
   */
  public static boolean testDropCandidateNotRunning() {
    
    // (1a) set up the test variables
    String[][] candidateList = {
        {"Slowpoke", "Water", "3"},
        {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"},
        null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Goldeen";
    String party = "Water";
    int size = 3;
    int expected = 3;
    
    // (1b) call the method we are testing
    int actual =
        ElectionManager.dropCandidate(candidateList, size, name, party);
    
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual) return false;
    
    // (2a) sometimes you may want to REPEAT the process with slightly different variables:
    name = "Slowpoke";
    party = "Fire"; // try with a name that's present but a different PARTY; should still not drop
    actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    if (expected != actual) return false;
    
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy)) return false;
    
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
    
  }
  

  
	/**
	 * Tests if candidate is found to be the winner when they are uncontested
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  public static boolean testUncontestedWinner() {
	  String[][] candidateList = {
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
	  String expectedName = "Wooper";
	  String expectedParty = "(Water)";
	  double expectedVotePct = 300.0/(300)*100;
	  int size = 1;
		    
	  String result = ElectionManager.findWinner(candidateList, size);
		        
		    // (2) verify that the expected method return value and the actual return value match
		    // NOTE: for a String, this takes a little more processing to do sensitively.
		    // We expect this result to be "Wooper (Water) - 75.0%" but there may be some weirdness
		    // especially with that percentage. See how we do it here:
		    
	  String[] resultPieces = result.split(" "); // get the space-separated pieces of the string
		    
	  if (resultPieces.length != 4) return false; // incorrect formatting
	  if (!resultPieces[3].endsWith("%")) return false; // no % at the end
		    
	  if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
		      return false; // wrong name or wrong party
		    
	  if (!resultPieces[2].equals("-")) return false; // forgot the "-" between party and %
		    
		    // do a range check on the calculated vote percentage, since it's not always going to come out
		    // exactly the same:
	  double actualVotePct = Double.valueOf(resultPieces[3].substring(0,resultPieces[3].length()-1));
	  if (Math.abs(actualVotePct-expectedVotePct) > 0.01) return false;
		    
		    // (3) this scenario should NOT modify the input array; check it against a copy we made
	  if (!Arrays.deepEquals(candidateList, candidateCopy)) return false;
		    
		    // (4) if we have not yet returned false, we can now return true as all tests have passed!
	  return true;  
  }
  
  /**
   * PROVIDED TESTER METHOD: example test method for verifying the results of an election
   * where one candidate has received a clear majority of the votes cast.
   * 
   * @return false if any of the scenarios we test have results other than what we expect;
   * true ONLY if all of our expectations are met by the method we are testing
   */
  public static boolean testClearWinner() {
    
    String[][] candidateList = {
        {"Slowpoke", "Water", "3"},
        {"Squirtle", "Water", "97"},
        {"Wooper", "Water", "300"},
        null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Wooper";
    String expectedParty = "(Water)";
    double expectedVotePct = 300.0/(300+97+3)*100;
    int size = 3;
    
    String result = ElectionManager.findWinner(candidateList, size);
        
    
    String[] resultPieces = result.split(" "); // get the space-separated pieces of the string
    
    if (resultPieces.length != 4) return false; // incorrect formatting
    if (!resultPieces[3].endsWith("%")) return false; // no % at the end
    
    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party
    
    if (!resultPieces[2].equals("-")) return false; // forgot the "-" between party and %
    
    // do a range check on the calculated vote percentage, since it's not always going to come out
    // exactly the same:
    double actualVotePct = Double.valueOf(resultPieces[3].substring(0,resultPieces[3].length()-1));
    if (Math.abs(actualVotePct-expectedVotePct) > 0.01) return false;
    
    if (!Arrays.deepEquals(candidateList, candidateCopy)) return false;
    
    return true;
    
  }
  
	/**
	 * Tests if any candidate is found the winner when none have majority
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testContingentElection() {
	  // array with no one having majority of the votes
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "200"},
		        {"Squirtle", "Water", "301"},
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  int size = 3;
	  String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
	  String expected = "CONTINGENT";
		    
	  String result = ElectionManager.findWinner(candidateList, size);
		        
		    
		    


	  if (!expected.equals(result)) // checks if returns CONTINGENT
	  {
		  return false;
	  }
		    
	  if (!Arrays.deepEquals(candidateList, candidateCopy)) return false; // checks if array is changed
		    
	  return true;  
  }
  
  
	/**
	 * Tests if candidate is found to have the lowest votes when they are uncontested
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
    
  public static boolean testUncontestedLowestPolling() {
	  // array with only one candidate
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "3"},
		        null, null, null};
	  int size = 1;
	  String result = ElectionManager.findLowestPollingCandidate(candidateList,size);
	  String expected = "UNCONTESTED";
	  if (!result.equals(expected)) // checks if returns UNCONTESTED
	  {
	  	return false; 
	  }
	  return true;  
  }
  
  
	/**
	 * Tests if candidate is found to have the lowest votes when they have the least amount of 
	 * votes in the candidate list
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  public static boolean testLowestUniqueVoteCount() {
	  // array with "Slowpoke" having lowest vote count
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "97"},
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  int size = 3;
	  String result = ElectionManager.findLowestPollingCandidate(candidateList,size);
	  String expected = "Slowpoke (Water) - 3";
	  if (!result.equals(expected)) // checks if returns candidate with lowest votes
	  {
	  	return false; 
	  }
	  return true;
  }
  
  
	/**
	 * Tests if candidate found alphabetically first to have the lowest votes when 
	 * candidates are tied for it
	 * @return false if any of the scenarios we test have results other than what we expect;
	 * true ONLY if all of our expectations are met by the method we are testing
	 */
  
  
  public static boolean testLowestVoteCountTied() {
	  // array with two candidates tied for lowest
	  String[][] candidateList = {
		        {"Slowpoke", "Water", "3"},
		        {"Squirtle", "Water", "3"},
		        {"Wooper", "Water", "300"},
		        null, null, null};
	  int size = 3;
	  String result = ElectionManager.findLowestPollingCandidate(candidateList,size);
	  String expected = "Slowpoke (Water) - 3";
	  if (!result.equals(expected)) // checks if the first candidate with the lowest votes is returned
	  {
	  	return false; 
	  }
	  return true;  
  }

  /**
   * PROVIDED MAIN METHOD to manage the tester methods above.
   * 
   * We're getting a little esoteric here to take advantage of loops to keep the code short;
   * each pass through the loop could also be written as follows:
   * 
   *   boolean singleTest = testMethodCall();
   *   allPass &= singleTest;
   *   System.out.println("testMethodCall : " + singleTest);
   * 
   * @throws NoSuchMethodException if you spell a method name incorrectly
   * 
   * And a couple of other "checked" exceptions that should never happen with our usage here:
   * @throws IllegalAccessException
   * @throws java.lang.reflect.InvocationTargetException
   */
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, 
    java.lang.reflect.InvocationTargetException {
    boolean allPass = true, singlePass = true;
    String printFormat = "%-29s: %s\n";
    
    String[] containsTests = {"testContainsEmpty", "testDoesNotContain", "testDoesContain"};
    String[] addTests = {"testAddToEmpty", "testAddToNonEmpty", "testAddCandidateErrors",
        "testAddToFull"};
    String[] dropTests = {"testDropOnlyCandidate", "testDropFirstCandidate", 
        "testDropCandidateNotRunning"};
    String[] winTests = {"testUncontestedWinner", "testClearWinner", "testContingentElection"};
    String[] lowTests = {"testUncontestedLowestPolling", "testLowestUniqueVoteCount", 
        "testLowestVoteCountTied"};
    
    String[][] testNames = {containsTests, addTests, dropTests, winTests, lowTests};
    
    for (String[] testSet : testNames) {
      for (String name : testSet) {
        singlePass = (boolean) ElectionManagerTester.class.getDeclaredMethod(name).invoke(null);
        allPass &= singlePass;
        System.out.printf(printFormat, name, singlePass);
      }
      System.out.println();
    }
 
    System.out.println("ALL TESTS: "+allPass);

  }

}
