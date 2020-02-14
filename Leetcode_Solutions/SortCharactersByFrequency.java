// bucket sort
// Time: O(n)
class Solution 
{
	public String frequencySort(String s) 
	{
		Map<Character, Integer> freq_map = new HashMap<>();
		for (int i = 0; i < s.length(); i++)
		{
			freq_map.put(s.charAt(i), freq_map.getOrDefault(s.charAt(i), 0) + 1);
		}
		List<Character>[] buckets = new ArrayList[s.length() + 1];
		for (Character key: freq_map.keySet())
		{
			int frequency = freq_map.get(key);
			if (buckets[frequency] == null)
				buckets[frequency] = new ArrayList<>();
			buckets[frequency].add(key);
		}
		String result = "";
		for (int i = buckets.length - 1; i >= 0; i--)
		{
			if (buckets[i] == null)
				continue;
			for (Character key: buckets[i])
			{
				for (int j = i; j > 0; j--)
				{
					if (result.length() == s.length())
						return result;
					result += key;
				}   
			}
		}
		return result;
	}
}