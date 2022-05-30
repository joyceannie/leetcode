class Solution:
    def reverseParentheses(self, s: str) -> str:
        if len(s) == 0:
            return s
        stack = []
        for i in range(len(s)):
            if s[i] != ')':
                stack.append(s[i])
            else:
                reversed_part = ""
                while stack[-1] != '(' :
                    letter = stack.pop()
                    reversed_part += letter
                stack.pop()
                for letter in reversed_part:
                    stack.append(letter)
                
        return "".join(stack)
