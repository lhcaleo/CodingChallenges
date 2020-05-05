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

