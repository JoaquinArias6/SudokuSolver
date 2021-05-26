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
  and comprobing that the Hash does not have a list within itself that repeats any row 
  number, column number, and subgrid number. Otherwise, the placement is invalid.

