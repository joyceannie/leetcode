class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if k == 0:
            return 0
        
        max_length, left, right = 0, 0, 0
        hash_map = OrderedDict()
        while right < len(s):
            letter = s[right]
            
            if letter in hash_map:
                del hash_map[letter]
            hash_map[letter] = right
            
            
            if len(hash_map) == k+1:
                _, value = hash_map.popitem(last = False)
                left = value + 1
            
            max_length = max(max_length, right - left + 1)
            right += 1
            
        return max_length
