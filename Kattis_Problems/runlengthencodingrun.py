# https://open.kattis.com/problems/runlengthencodingrun
def encode(msg):
	result = ''
	i = 0
	for _ in range(len(msg)):
		curr = msg[i]
		count = 0
		for j in range(i+1, len(msg)):
			if curr == msg[j]:
				count += 1
			else:
				break
		count += 1
		result += curr + str(count)
		i += count
		if i >= len(msg):
			break
	print(result)
		
	
def decode(msg):
	result = ''
	for i in range(len(msg)):
		if(i % 2 == 0):
			result += msg[i]
			i += 1
			for j in range(int(msg[i])-1):
				result += msg[i-1]
	print(result)


letter, message = input().split()
if(letter == 'E'):
	encode(message)
if(letter == 'D'):
	decode(message);

