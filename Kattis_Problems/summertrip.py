# https://open.kattis.com/problems/summertrip
def summertrip():
	s = input()
	ss = list(set(s))
	
	count = 0
	for alpha in ss:
		i = s.find(alpha)
		seq = set()
		for j in range(i+1,len(s)):
			if alpha == s[j]:
				# reset sequence
				seq = set()
			else:
				if s[j] in seq:
					continue
				else:
					seq.add(s[j])
					count += 1				
	print(count)
								
summertrip()

