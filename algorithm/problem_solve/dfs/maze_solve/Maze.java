package problem_solve.dfs.maze_solve;

public class Maze {
    private int[][] maze = {{1, 1, 1, 1, 1, 1},
                            {1, 2, 0, 0 ,0, 1},
                            {1, 1, 1, 0, 1, 1},
                            {1, 1, 0, 0, 0, 1},
                            {1, 1, 1, 3, 1, 1}};
    private int row;
    private int col;

    private int startRow = -1;
    private int startCol = -1;

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    Maze(){
        row = maze.length;
        col = maze[0].length;

        for(int i=0; i < maze.length; i++){
            for(int j=0; j < maze[i].length; j++){
                if(maze[i][j] == 2){
                    this.startRow = i;
                    this.startCol = j;
                    break;
                }
            }
            if(startRow != -1 && startCol != -1){
                break;
            }
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
