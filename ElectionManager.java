
public class ElectionManager {
	
	/**
	 * Determines whether the given candidate, specified uniquely by name and party, 
	 * is present in the given list of candidates.
	 * 
	 * @param candidates A two-dimensional oversize array containing the current
	 * list of candidates as [name, party, numVotes]. This input value is assumed to
	 * conform to the standards of oversize arrays, and is assumed to be in alphabetical
	 * order by candidate name.
	 * 
	 * @param numCandidates The current size of the candidates oversize array at the time of input.
	 * This value is assumed to be accurate.
	 * @param name The name of the candidate to search for
	 * @param party The party affiliation of the candidate to search for
	 * @return true if a candidate with the given name AND party affiliation is present in the list; 
	 * false otherwise

	 */
	public static boolean containsCandidate(String[][] candidates, int numCandidates, String name, String party)
	{
		for(int i = 0; i < numCandidates; i++)
		{
			if (candidates[i][0].equals(name) && candidates[i][1].equals(party))
			{
				return true;
			}

		}
		return false;
	}

	
//	public static int addCandidate(String[][] candidates, int numCandidates, String name, String party, int numVotes)
//	{
//		
//	}


	public static int dropCandidate(String[][] candidates, int numCandidates, String name, String party)
	{
		String[] candidateToRemove = null;
		if (ElectionManager.containsCandidate(candidates, numCandidates, name, party))
		{
			
			for(int i = 0; i < numCandidates; i++)
			{
				if (candidates[i][0].equals(name) && candidates[i][1].equals(party))
				{
					candidateToRemove = candidates[i];
				}

			}
			String[][] updatedCandidates = new String[candidates.length][3];
			for (int z = 0; z < numCandidates - 1; z++)
			{
				if (!candidates[z].equals(candidateToRemove))
				{
					updatedCandidates[z] = candidates[z];
				}
			}
			candidates = updatedCandidates;
			numCandidates -= 1;
		}
		return numCandidates;
	}
	
	public static String findWinner(String[][] candidates, int numCandidates)
	{
		int totalVotes = 0;
		int highestVotes = 0;
		int indexOfHighest = 0;
		for (int i = 0; i < numCandidates; i++)
		{
			totalVotes += Integer.parseInt(candidates[i][2]);
			if (Integer.parseInt(candidates[i][2]) > highestVotes)
			{
				highestVotes = Integer.parseInt(candidates[i][2]);
				indexOfHighest = i;
			}
		}
		if ((double) (highestVotes)/(double) (totalVotes) <= 0.5)
		{
			return "CONTINGENT";
		}
		else
		{
			return candidates[indexOfHighest][0] + " (" + candidates[indexOfHighest][1] + ")"
					+ " - " + (double) (highestVotes)/(double) (totalVotes) * 100 + "%";
		}
	}
	
	
	public static String findLowestPollingCandidate(String[][] candidates, int numCandidates)
	{
		int indexOfLowest = 0;
		if (numCandidates == 0 || numCandidates == 1)
		{
			return "UNCONTESTED";
		}
		for (int i = 0; i < numCandidates; i++)
		{
			if (Integer.parseInt(candidates[i][2]) < Integer.parseInt(candidates[indexOfLowest][2]))
			{
				indexOfLowest = i;
			}

		}

		System.out.println(candidates[indexOfLowest][0] + " (" + candidates[indexOfLowest][1] + ")"
				+ " - " + candidates[indexOfLowest][2]);
		return (candidates[indexOfLowest][0] + " (" + candidates[indexOfLowest][1] + ")"
				+ " - " + candidates[indexOfLowest][2]);
		
	}

}
