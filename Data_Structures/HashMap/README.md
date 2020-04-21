# Hash Table

https://www.hackerearth.com/zh/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial/

**Hash Table = an array of linked lists + a hash code function.**

[HashMap Implementation](https://dzone.com/articles/custom-hashmap-implementation-in-java)

## Insert a (key, value) pair into Hash Table

1. <u>Compute the key’s hash code</u>

   note: 2 keys could have the same hash code

2. <u>Map the hash code to an index in the array</u>

   eg: `hash(key) % array.length` 

   note: 2 hash code could map to the same index

3. At each index, there is a linked list of keys and values

   note: we must use linked list because of hash collisions, then you could have two different keys with the same hash code, or two different hash codes that map to the same index

## Retrive the value pair by its key?

1. <u>Compute the hash code from the hash code</u>

   `hashcode = hash(key)`

2. <u>Compute the index from the hash code</u>

   `index = hash(key) % array.length `

3. <u>Search through the linked list for the value with this key</u>

## Hash Collision

- Hash Collision occurs when two different keys are mapped to the same index
- If # of collison is high, the worest time is O(N), otherwise the lookup time is O(1)
- Solve hash collision by using linked list, where the `node = (pair, next)` 
  - `pair = key, value`

![image-20200210131235458](https://tva1.sinaimg.cn/large/0082zybpgy1gbrutb74pmj30xg0me41f.jpg)

