
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
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
// Online Sources:  https://apcentral.collegeboard.org/media/pdf/ap-computer-science-a-java-quick-reference_0.pdf
// -Used it as a reference for Java syntax (ex. compareTo)
//
///////////////////////////////////////////////////////////////////////////////



/**
 * Class that contains methods to check if candidate is there, to add candidate, to drop candidate, 
 * to determine who has the lowest votes, and who is the winner
 */

 public class ElectionManager {
	
	/**
	 * Determines whether the given candidate, specified uniquely by name and party, 
	 * is present in the given list of candidates.
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @param name The name of the candidate to search for
	 * @param party The party affiliation of the candidate to search for
	 * @return true if a candidate with the given name AND party affiliation is present in the list; 
	 * false otherwise

	 */
	public static boolean containsCandidate(String[][] candidates, int numCandidates, 
			String name, String party)
	{
		//loops through the valid candidates in the array and checks if candidate is there
		for(int i = 0; i < numCandidates; i++) 
		{
			if (candidates[i][0].equals(name) && candidates[i][1].equals(party))
			{
				return true;
			}

		}
		return false;
	}

	
	/**
	 * Adds a candidate with the given name, party affiliation, and vote count to the given list of candidates, 
	 * maintaining the candidate list in alphabetical order by NAME, and returns the new total number 
	 * of candidates in the array. Does NOT add the candidate if another candidate with the same name and party 
	 * affiliation is already present in the list, or if the provided vote count is a negative value, or if the 
	 * input array has no room to add another candidate.
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @param name The name of the candidate to add
	 * @param party The party affiliation of the candidate to add
	 * @oaram numVotes The number of votes the candidate to add has received
	 * @return The size of the candidates oversize array after this method has completed. 
	 * This value will be either the same as numCandidates or one larger

	 */
	
	public static int addCandidate(String[][] candidates, int numCandidates, 
			String name, String party, int numVotes)
	{
		//checks if candidate is already there, an invalid # of votes, or candidate array is full
		if (containsCandidate(candidates, numCandidates, name, party) || numVotes < 0 
				|| candidates.length == numCandidates) 
		{
			return numCandidates;
		}
		int indexOfNew = numCandidates;
		String[][] newCandidates = new String [candidates.length][3]; // temp array 

		for (int i = 0; i < numCandidates; i++)
		{
			// use compareTo to sort and see which index to insert new candidate
			if (name.compareTo(candidates[i][0]) < 0) 
			{
				indexOfNew = i;
				break;
			}

		}
		for (int firstPart = 0; firstPart < indexOfNew; firstPart++) // first half of the array
		{
			newCandidates[firstPart] = candidates[firstPart];
		}
		newCandidates[indexOfNew][0] = name; // insert the information of new candidate at index
		newCandidates[indexOfNew][1] = party;
		newCandidates[indexOfNew][2] = Integer.toString(numVotes);
		// second half of array after new candidate
		for (int secondPart = indexOfNew + 1; secondPart < numCandidates + 1; secondPart++) 
		{
			newCandidates[secondPart] = candidates[secondPart-1];
		}
		
		for (int j = 0; j <= numCandidates; j++) // updates candidate parameter
		{
			candidates[j] = newCandidates[j];
		}
		numCandidates += 1;
		return numCandidates;
	}

	
	
	/**
	 * Removes the candidate specified uniquely by name and party from the given array of candidates,
	 * maintaining the candidates array in alphabetical order by name.
	 * Does not modify the array if the candidate specified is not present in the list.
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @param name The name of the candidate to drop from the list
	 * @param party The party affiliation of the candidate to drop from the list
	 * @return The size of the candidates oversize array after this method has completed.
	 * This value will be either the same as numCandidates or one smaller.

	 */

	public static int dropCandidate(String[][] candidates, 
			int numCandidates, String name, String party)
	{
		int indexOfRemove = 0;
		// checks if there is candidate to remove
		if (containsCandidate(candidates, numCandidates, name, party)) 
		{
			
			for(int i = 0; i < numCandidates; i++) // locates index of candidate to drop
			{
				if (candidates[i][0].equals(name) && candidates[i][1].equals(party))
				{
					indexOfRemove = i;
				}

			}
			// updates the candidate param by shifting to the left removing the candidate specified
			for (int x = indexOfRemove; x < numCandidates - 1; x++) 
			{
				candidates[x] = candidates[x + 1];
			}
			candidates[numCandidates - 1] = null;
			numCandidates -= 1;

		}
		return numCandidates;
	}
	
	
	/**
	 * Finds the candidate with the majority (that is, >50%) of total votes cast. 
	 * If no candidate in the list has received more than 50% of the total votes, 
	 * returns the string "CONTINGENT". This method will NOT be tested with a numCandidates of 0. 
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @return A string containing the "name (party) - votePct%" values of the candidate receiving 
	 * a majority of the votes, or the string "CONTINGENT" if no single candidate has received 
	 * more than half of the votes.
	 */
	
	public static String findWinner(String[][] candidates, int numCandidates)
	{
		int totalVotes = 0;
		int highestVotes = 0;
		int indexOfHighest = 0;
		for (int i = 0; i < numCandidates; i++)
		{
			// converts the votes of each candidate to an int and adds them all
			totalVotes += Integer.parseInt(candidates[i][2]); 
			// keep updating highestVotes when there is a cvote count higher found
			if (Integer.parseInt(candidates[i][2]) > highestVotes) 
			{
				highestVotes = Integer.parseInt(candidates[i][2]);
				indexOfHighest = i;
			}
		}
		// checks if the highest votes is majority
		if ((double) (highestVotes)/(double) (totalVotes) <= 0.5) 
		{
			return "CONTINGENT";
		}
		else
		{
			// returns string that contains name, party, and percent of votes received
			return candidates[indexOfHighest][0] + " (" + candidates[indexOfHighest][1] + ")"  
					+ " - " + (double) (highestVotes)/(double) (totalVotes) * 100 + "%";  
		}
	}
	
	
	/**
	 * Finds the candidate with the smallest number of votes cast. If there are multiple candidates with 
	 * the same smallest number of votes, this method returns the one whose name is closest to the 
	 * beginning of the alphabet (smallest index). If there are fewer than two candidates
	 *  in the election, this method returns the string "UNCONTESTED".
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @return A string containing the "name (party) - numVotes" values of the lowest-index 
	 * candidate receiving the smallest number of votes, or "UNCONTESTED" if there are one or 
	 * zero candidates in the list.
	 */
	
	public static String findLowestPollingCandidate(String[][] candidates, int numCandidates)
	{
		int indexOfLowest = 0;
		if (numCandidates == 0 || numCandidates == 1) // checks if empty array or contains one
		{
			return "UNCONTESTED";
		}
		for (int i = 0; i < numCandidates; i++)
		{
			if (Integer.parseInt(candidates[i][2]) < Integer.parseInt(candidates[indexOfLowest][2]))
			{
				indexOfLowest = i; // updates the index when a lower vote count is found
			}

		}

		return (candidates[indexOfLowest][0] + " (" + candidates[indexOfLowest][1] + ")"
				+ " - " + candidates[indexOfLowest][2]);
		
	}

}
