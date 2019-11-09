# https://open.kattis.com/problems/kleptography
def kleptography():
	# readin inputs
	n, m = map(int, input().split())
	last_n_letters = input()        # last n letters of plain text
	b = input()   					# ciphered text
	
	# assign last_n_letters to plain text
	# initialize first m-n letters as empty character
	a = list(' '*(m-n) + last_n_letters)

	# a_i = k_n+i       for i >= 1
	# b_i = (a_i + k_i) mod 26
	# k_i = (b_i - a_i) mod 26
	# For i from m-n-1 to n-1-n -> letters at front,
	# a_i = k_i+n = (b_i+n - a_i+n) mod 26
	for i in range(m-1, n-1, -1):
		a[i-n] = chr( ord('a') + (26 + ord(b[i]) - ord(a[i])) % 26 )
	print(''.join(a))

kleptography()