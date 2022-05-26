class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-stone for stone in stones]
        heapq.heapify(stones)
        print(stones)
        while len(stones) > 1:
            x = heapq.heappop(stones)
            y = heapq.heappop(stones)
            #print(x, y)
            if x != y:
                heapq.heappush(stones, x - y)
        return abs(stones[0]) if len(stones)==1 else 0
