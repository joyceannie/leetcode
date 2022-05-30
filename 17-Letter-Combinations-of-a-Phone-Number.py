class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        digit_to_letter_map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
            
        }
        
        def get_combinations(index, combination):
            if index == len(digits):
                combinations.append("".join(combination))
                return
            possible_letters = digit_to_letter_map[digits[index]]
            for letter in possible_letters:
                combination.append(letter)
                get_combinations(index + 1, combination)
                combination.pop()
        
        if len(digits) == 0:
            return []
        combinations = []
        get_combinations(0, [])
        return combinations
