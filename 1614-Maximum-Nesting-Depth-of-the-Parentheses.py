class Solution:
    def maxDepth(self, s: str) -> int:
        max_depth = 0
        stack = []
        for char in s:
            if char == '(':
                if not stack:
                    stack.append(1)
                else:
                    stack.append(stack[-1] + 1)
            elif char == ')':
                max_depth = max(max_depth, stack.pop())
                
        return max_depth
