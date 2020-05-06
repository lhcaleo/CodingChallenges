# String

## 28. Implement strStr (Easy)

### Description

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).

### Solution

```java
// Assume n = length of haystack, m = length of needle
// Time: O(nm) Space: O(1)
class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        if (needle.length() == 0)
            return 0;
        
        if (haystack.length() == 0 || haystack.length() < needle.length())
            return -1;
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            for (int j = 0; j < needle.length(); j++)
            {
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        
        return -1;
    }
}
```



## 344. Reverse String (Easy)

### Description

Write a function that reverses a string. The input string is given as an array of characters `char[]`.

Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.

You may assume all the characters consist of [printable ascii characters](https://en.wikipedia.org/wiki/ASCII#Printable_characters).

**Example 1:**

```
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

### Solution

```c++
class Solution {
public:
    void reverseString(vector<char>& s) 
    {
        for (int i = 0, j = s.size() - 1; i < j; i++, j--)
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
};
```

## 796. Rotate String (Easy)

### Description

We are given two strings, `A` and `B`.

A *shift on `A`* consists of taking string `A` and moving the leftmost character to the rightmost position. For example, if `A = 'abcde'`, then it will be `'bcdea'` after one shift on `A`. Return `True` if and only if `A` can become `B` after some number of shifts on `A`.

```
Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
```

### Solution

**Brute Force Solution O(n^2)**

```java
// Time: O(n^2) Space: O(1)
// Brute Force
// if we rotate A by s, then check that A[s] == B[0], A[s+1] == B[1], ...
class Solution 
{
    public boolean rotateString(String A, String B) 
    {
        if (A == null || B == null || A.length() != B.length())
            return false;
        
        if (A.length() == 0)
            return true;
        
        for (int i = 0; i < A.length(); i++)
        {

            boolean equal = true;
            
            for (int j = 0; j < A.length() && equal; j++)
            {
                if (B.charAt(j) != A.charAt((i+j) % A.length()))
                    equal = false;
            }
            // if each char at A and B is equal, then rotated is checked
            // otherwise, check new s
            if (equal)
                return true;
        }
        
        return false;     
    }
}
```

**One Line Solution O(n^2)**

```java
// Time: O(n^2) Space: O(N)
// if B can be found in (A + A), then rotated is true
// A = 'abcde' B = 'bcdea' A + A = 'abcdeabcde'
class Solution 
{
    public boolean rotateString(String A, String B) 
    {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
```

## 151. Reverse Words in a String (Medium)

### Description

Given an input string, reverse the string word by word.

**Example 1:**

```
Input: "the sky is blue"
Output: "blue is sky the"
```

**Example 2:**

```
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
```

**Example 3:**

```
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

**Note:**

- A word is defined as a sequence of non-space characters.
- Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
- You need to reduce multiple spaces between two words to a single space in the reversed string. 

### Solution

Idea: reverse each word, then reverse the whole string.

```java
// Two Pointer Solution
// Time: O(n) for array iteration  Space: O(n) for extra char array
class Solution 
{
    public String reverseWords(String s) 
    {
        if (s == null)
            return s;
        
        char[] a = s.toCharArray();
        
        // step 1: reverse each word
        reverse_words(a);
        
        // step 2: reverse the whole string
        reverse(0, a.length - 1, a);
        
        // step 3: clean multiple spaces
        return clean_spaces(a);
    }
    
    private void reverse_words(char[] a)
    {
        int i = 0;
        int j = 0;
        int len = a.length;
        
        while (i < len)
        {
            while (i < j || i < len && a[i] == ' ') i++; // skip spaces
            while (j < i || j < len && a[j] != ' ') j++; // skip non-spaces
            reverse(i, j - 1, a); // reverse this word
        }
    }
    
    private void reverse(int i, int j, char[] a)
    {
        while (i < j)
        {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
    
    private String clean_spaces(char[] a)
    {
        int len = a.length;
        int i = 0;
        int j = 0;
        
        while (j < len)
        {
            while (j < len && a[j] == ' ') j++; // skip leading spaces
            while (j < len && a[j] != ' ') a[i++] = a[j++]; // keep non-spaces
            while (j < len && a[j] == ' ') j++; // skip trailing spaces
            if (j < len) a[i++] = ' ';  // keep only one space
        }
        
        return new String(a).substring(0, i);
    }
}
```

## 242. Valid Anagram (Easy)

### Description

Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

**Note:**
You may assume the string contains only lowercase alphabets.

**Follow up:**
What if the inputs contain unicode characters? How would you adapt your solution to such case?

### Solution

**HashMap Solution O(n) space**

```java
// HashMap Solution
// Time: O(n) Space: O(n)
class Solution 
{
	public boolean isAnagram(String s, String t) 
	{
		if (s.length() != t.length())
			return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < t.length(); i++)
		{
			char c = t.charAt(i);
			if (map.get(c) == null)
				return false;
			else if (map.get(c) > 0)
				map.replace(c, map.get(c) - 1);
			else
				return false;
		}
		
		return true;
	}
}
```

**Array Solution Space: O(1)**

```java
// Use Array instead of HashMap 
// Time: O(n) Space: O(1) since array_size(26) is a constant
class Solution 
{
	public boolean isAnagram(String s, String t) 
	{
		if (s.length() != t.length())
			return false;
		
		int[] alphabets = new int[26];
		
		for (int i = 0; i < s.length(); i++)
		{
			alphabets[s.charAt(i) - 'a']++;
			alphabets[t.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < 26; i++)
		{
			if (alphabets[i] != 0)
				return false;
		}
		
		return true;
	}
}
```

## 409. Longest Palindrome (Easy)

### Description

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example `"Aa"` is not considered a palindrome here.

**Note:**
Assume the length of given string will not exceed 1,010.

**Example:**

```
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
```

### Solution

```java
// Time: O(n) Space: O(1) since array_size is a constant
class Solution 
{
    public int longestPalindrome(String s) 
    {
        // Since 'A' = 65 'z' = 122, array size is then 122 - 65 + 1 = 58
        int[] count = new int[58];
        
        // count # of appearance of each letter
        for (char c: s.toCharArray())
        {
            count[c - 'A']++;
        }
        
        int ans = 0;
        
        // for each letter appears t times, we can use it t / 2 * 2 times
        // t/2 times for left side of the palindrome, and t/2 times for right side
        // if one letter appears odd times, use it as the center of the palindrome
        // only one odd letter can be used as the center
        for (int t: count)
        {
            ans += (t / 2) * 2;
            // once found the center odd letter, if condition will never be executed anymore
            if (ans % 2 == 0 && t % 2 != 0)
                ans++;
        }
        
        return ans;
    }
}
```

## 205. Isomorphic Strings (Easy)

### Description

Given two strings **s** and **t**, determine if they are isomorphic.

Two strings are isomorphic if the characters in **s** can be replaced to get **t**.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

```
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
```

### Solution

```java
// Mapping two chars at the same position to the same value
class Solution 
{
    public boolean isIsomorphic(String s, String t) 
    {
        int len = s.length();
        int[] map_s = new int[128];
        int[] map_t = new int[128];
        
        for (int i = 0; i < len; i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (map_s[c1] != map_t[c2])
                return false;
            else
            {
                map_s[c1] = i + 1;
                map_t[c2] = i + 1;
            }
        }
        
        return true;   
    }
}

/*
The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'. Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.

So we use two arrays here m1 and m2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here). Traverse the character of both s and t on the same position, if their mapping values in m1 and m2 are different, means they are not mapping correctly, returen false; else we construct the mapping, since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
*/
```

