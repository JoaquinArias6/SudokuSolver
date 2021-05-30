# SudokuSolver
Project's description:
- The project consists in a simple GUI built in Java, using the Swing library,
  that verifies if the placing of certain digits provided by an user is valid 
  to end up constructing an unique sudoku or not, following the basic rules of 
  sudoku.
  
  
An insight of the logic behind the problem:
- First of all, one thing that comes to mind when solving sudokus is what amount 
  of digits ables the solution to be unique, because as we know, if we place, for example, 
  only one number on the grid, there will be a lot of possible solutions.
  Doing a little research, I've found out that the minimum amount of numbers
  that need to be placed on the grid layout, must be at least 17. Due to this fact, 
  having a placement of less than 17 numbers on the grid results in a sudoku with 
  multiple solutions.

- Secondly, we need to make sure that the placement provided is, indeed, following the 
  rules of sudoku. This means that the numbers must differ from each other on each row, 
  column and sub-grid.
  To verify the previous conditions, we can use Hashing considering the digits as keys 
  and comprobing that the Hash map does not have a list within itself that repeats any row 
  number, column number, or subgrid number. Otherwise, the placement is invalid.

- Finally, in case that the first and second step were executed and the input is still valid, 
  we need to check if the placement can end up in a valid solution or not.
  In order to do the previous check, we could consider two options:
    - The first one is to simple use backtracking. If we place a digit on the grid following
      the rules of sudoku, we can continue placing another ones until we reach a dead end, 
      meaning that we cannot keep placing anything on the grid to complete succesfully the
      sudoku. When reaching this mentioned "dead point" we can change the digit of the last cell 
      we filled in, for another digit as long as the placement does not break the rules. If there
      is not even one that allows us to achieve a valid solution, then it is possible to leave that
      cell empty and change the number of the previous one, and so on.
      This way, we can complete the grid succesfully.
    - The other way to resolve this problem is to change a little bit the first option to our favor.
      Placing a number without a clear methodology could be a bit inefficient, so to solve this issue 
      we can make the placement while listening to the probability of it's validity. 
      For example, if there is three consecutive cells in a row that could be filled in with a three
      and two of the same cells could contain a two, then it is wiser to place the two rather than the 
      three, simply because that the probability that it's placement is right is significally higher than 
      the probability of making a right placement of the three.
  Both options are valid. The first one is quite inefficient but it requires less code and the second one, 
  even if it requires more coding and thinking, it's more efficient.
