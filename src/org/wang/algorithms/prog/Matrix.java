/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.prog;

/**
 *
 * @author wang
 */
public class Matrix {
	private int[][] matrix;
	
	private int rows;
	
	private int cols;
	
	public Matrix(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		matrix = new int[rows][cols];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
	
	public int getCell(int row, int col){
		return matrix[row][col];
	}
	
	public void setCell(int row, int col, int value){
		matrix[row][col] = value;
	}
	
	public void print(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void accept(MatrixFiller mf){
		mf.fill(this);
	}
	
	public static void main(String[] args){
		Matrix m = new Matrix(10,10);
		m.accept(new ClockwiseFill());
		m.print();
	}
}
