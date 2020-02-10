// bucket sort
// Time: O(n) Space: O(n)
class Solution 
{
	public List<Integer> topKFrequent(int[] nums, int k) 
	{
		Map<Integer, Integer> frequencyForNum = new HashMap<>();
		// for all the numbers in nums
		// key: number, value: frequency
		for (int num: nums)
		{   
			// if no key, add the key,value with key, 0
			frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1); 
		}
		// create an array of arraylists with size = nums + 1 (for zero frenquency)
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		// for each number in the hashmap
		for (int key: frequencyForNum.keySet())
		{
			int frequency = frequencyForNum.get(key);
			if (buckets[frequency] == null)
				buckets[frequency] = new ArrayList<>();
			// for each frequency, there is a bucket(list)
			// add the key into the bucket
			buckets[frequency].add(key);
		}
		
		// Last, return the topK frequent elements as a list
		List<Integer> topK = new ArrayList<>();
		// iterate the bucket from end to front
		// the first k numbers got, are what we want
		for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--)
		{
			if (buckets[i] == null) continue;
			// if # of numbers in the bucket <= # of spots available in the topK list 
			// else just insert as much as possible to the topK list
			if (buckets[i].size() <= (k - topK.size()))
			{
				topK.addAll(buckets[i]);
			} else {
				topK.addAll(buckets[i].subList(0, k - topK.size()));
			}
		}
		return topK;
	}
}