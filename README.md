## Program finds the longest digit sequence by representing six-digit numbers as graph nodes and connecting them based on matching two-digit overlaps, using Depth-First Search (DFS).

### DFS starts from each node and explores every possible path by moving to nodes whose first two digits match the current node’s last two digits. 
### It tracks visited nodes to prevent reusing the same number in a sequence and uses backtracking to explore alternative paths. 
### The longest path found is stored as the best result.
