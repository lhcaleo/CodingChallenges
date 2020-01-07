class Solution:    
	def permute(self, nums: List[int]) -> List[List[int]]:
		visited = set()
		result = []
		self.backtrack(nums, visited, [], result)
		return result
	
	def backtrack(self, nums, visited, subset, result): 
		if len(nums) == len(subset):
			result.append(subset)

		for i in range(len(nums)):
			if i not in visited:
				visited.add(i)
				self.backtrack(nums, visited, subset + [nums[i]], result)
				visited.remove(i)