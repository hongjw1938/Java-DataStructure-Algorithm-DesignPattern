package problem_solve.dfs.maze_solve;

public class MazeSolver {
    private int rowSize;
    private int colSize;
    private int[][] maze;

    MazeSolver(int[][] maze){
        this.maze = maze;
        rowSize = maze.length;
        colSize = maze[0].length;
    }

    public void dfs(int row, int col){
        if(0 > row || row >= rowSize){
            return;
        }

        if(0 > col || col >= colSize){
            return;
        }

        if(maze[row][col] == 1){
            return;
        }

        if(maze[row][col] == 3){
            throw new RuntimeException();
        }
        maze[row][col] = 1;
        System.out.println("Current Point : (" + row + ", " + col +")");

        dfs(row, col + 1); // go right
        dfs(row + 1, col); // go down
        dfs(row, col - 1); // go left
        dfs(row - 1, col); // go up


    }
}
