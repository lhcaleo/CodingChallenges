# https://open.kattis.com/problems/color

def color():
	# S: number of socks
	# C: capacity of laundry machine
	# K: max colour difference
	S, C, K = [int(x) for x in input().split()] 
	# colour values Di of every stock
	colors = [int(x) for x in input().split()] 
	colors = sorted(colors)
	# Output: the number of machines to wash all his socks.
	machines = socks = 1
	lower = colors[0]

	for i in range(1,S):
		# if socks in the machine reach the capacity
		# use one more machine
		if socks == C:
			machines += 1
			socks = 0
			lower = colors[i]
		# if the sock is not suitable for the one in the machine
		# use one more machine
		if (colors[i] - lower) > K:
			machines += 1
			socks = 0
			lower = colors[i]
		socks += 1
	print(machines)
	
color_260711526()
