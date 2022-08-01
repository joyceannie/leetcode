class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        
        all_pos_after_swap = {0: [1, 3], 1: [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}
        
        def get_neighbors(state):
            empty_pos = state.index("0")
            neighbors = []
            all_positions = all_pos_after_swap[empty_pos]
            #print(empty_pos, all_positions)
            for pos in all_positions:
                if empty_pos < pos:
                    #print(state[:empty_pos] + state[pos] + state[empty_pos+1: pos] + "0" + state[pos+1:])
                    neighbors.append(state[:empty_pos] + state[pos] + state[empty_pos+1: pos] + "0" + state[pos+1:]) 
                else:
                    #print(state[:pos] + "0" + state[pos+1: empty_pos] + state[pos] + state[empty_pos+1:])
                    neighbors.append(state[:pos] + "0" + state[pos+1: empty_pos] + state[pos] + state[empty_pos+1:])
            return neighbors
          
        queue = []
        initial_state = "".join(str(c) for row in board for c in row)      
        final_state = "123450"
        queue.append([initial_state, 0])
        visited = set()
        visited.add(initial_state)
        
        while queue:
            current_state, moves = queue.pop(0) 
            if current_state == final_state:
                return moves
            neighbors = get_neighbors(current_state)
            for neighbor in neighbors:
                if neighbor not in visited:
                    queue.append([neighbor, moves + 1]) 
                    visited.add(neighbor)
        return -1
