def main():
	# read in two lines
	width,partitions = [int(x) for x in input().split()] 
	locations = [0] + [int(x) for x in input().split()]  + [width]
	result = []
	# brute force to find all possible distances
	for i in range(len(locations)):
		for j in range(i+1,len(locations)):
			distance = locations[j]-locations[i]
			if distance not in result:              # avoid duplicates
				result += [distance]
	result.sort()
	print(*result)     # use * to unpack collection into positional arguments

if __name__ == '__main__':
	main()

