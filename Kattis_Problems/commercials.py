# maximum subarray prolbem
# https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
# https://open.kattis.com/problems/commercials

def commercials_260711526():
	N , P= [int(x) for x in input().split()] 
	# profit = income - cost
	sequences = list(map(lambda z: int(z) - P, input().split()))
	max_so_far = max_ending_here = sequences[0]
	for i in range(1,len(sequences)):
			max_ending_here = max(max_ending_here + sequences[i],sequences[i])
			max_so_far = max(max_so_far,max_ending_here) # keep updating the max sum
	print(max_so_far)

commercials_260711526()