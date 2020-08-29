package com.algorithm.problem_solve.dfs.maze_solve;

public class App {

    public static void main(String[] args){
        Maze mazeInstance = new Maze();

        int[][] maze = mazeInstance.getMaze();

        int startRow = mazeInstance.getStartRow();
        int startCol = mazeInstance.getStartCol();

        MazeSolver mazeSolver = new MazeSolver(maze);
        try{
            mazeSolver.dfs(startRow, startCol);
            System.out.println("Ooops.. There is no Exit! :(");
        } catch(RuntimeException e){
            System.out.println("Okay! There is Exit!");
        }


    }
}
