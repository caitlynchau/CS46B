package sudoku;

import java.util.*;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by
	// TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You’ll call this 9 times in next9Grids.
	//
	Grid(Grid src) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++)
			for (int i = 0; i < 9; i++)
				values[j][i] = src.values[j][i];
	}

	// Finds an empty member of values[][]. Returns an array list of 9 grids
	// that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the
	// current grid is full. Don’t change
	// “this” grid. Build 9 new grids.
	//
	//
	// Example: if this grid = 1........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	//
	// Then the returned array list would contain:
	//
	// 11....... 12....... 13....... 14....... and so on 19.......
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	//
	public ArrayList<Grid> next9Grids() {
		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;

		// Find x,y of an empty cell.
		boolean found = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				while (!found && values[i][j] == 0) {
					xOfNextEmptyCell = i; 
					yOfNextEmptyCell = j; 
					//System.out.println("empty cell (row, col): " + xOfNextEmptyCell + "," + yOfNextEmptyCell);
					found = true;
				}
			}
		}

		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>();

		// Create 9 new grids as described in the comments above. Add them to
		// grids.
		for (int i = 1; i <= 9; i++) {
			Grid g = new Grid(this);
			g.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
			//print2dArray(g);
			grids.add(g);
		}

		return grids;
	}

	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal() {

		// Check every row. If you find an illegal row, return false.
		for (int i = 0; i < 9; i++) {
			if (containsNonZeroRepeat(getRow(i))) {
				return false;
			}
		}

		// Check every column. If you find an illegal column, return false.
		for (int i = 0; i < 9; i++) { // check every column
			if (containsNonZeroRepeat(getColumn(i))) {
				return false;
			}
		}

		// Check every block. If you find an illegal block, return false.
		if (containsNonZeroRepeat(getBlock(0, 0)) || containsNonZeroRepeat(getBlock(3, 0))
				|| containsNonZeroRepeat(getBlock(6, 0)) || containsNonZeroRepeat(getBlock(0, 3))
				|| containsNonZeroRepeat(getBlock(3, 3)) || containsNonZeroRepeat(getBlock(6, 3))
				|| containsNonZeroRepeat(getBlock(0, 6)) || containsNonZeroRepeat(getBlock(3, 6))
				|| containsNonZeroRepeat(getBlock(6, 6))) {
			return false;
		}

		// All rows/cols/blocks are legal.
		return true;

	}

	// Returns true if every cell member of values[][] is a digit from 1-9.
	public boolean isFull() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (values[i][j] < 1 || values[i][j] > 9) {
					return false;
				}
			}
		}
		return true;
	}

	// Returns true if x is a Grid and, for every (i,j),
	// x.values[i][j] == this.values[i][j].
	public boolean equals(Object x) {
		Grid that = (Grid) x;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (that.values[i][j] != this.values[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// Returns true if array contains a duplicate value
	// Implements a HashSet to check duplicates
	private boolean containsNonZeroRepeat(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			if (arr[i] != 0) {
				if (set.add(arr[i]) == false) { // duplicate found
					return true;
				}
			}
		}
		return false; // no repeats found
	}

	// Helper method gets the ith row of a 9x9 array
	private int[] getRow(int i) {
		int[] row = new int[9];
		for (int j = 0; j < 9; j++) {
			row[j] = values[i][j];
		}
		return row;
	}

	// Helper method gets the ith column of a 9x9 array
	// Returns an array of ints
	private int[] getColumn(int i) {
		int[] col = new int[9];
		for (int j = 0; j < 9; j++) {
			col[j] = values[j][i];
		}
		return col;
	}

	// Helper method gets three rows of three numbers
	// given an x and y coordinate to start at
	private int[] getBlock(int x, int y) {
		int block[] = new int[9];
		int count = 0;
		while (count < 9) {
			for (int i = 0; i < 3; i++) { // first 3 rows
				for (int j = 0; j < 3; j++) { // first 3 elements
					block[count] = values[i + x][j + y]; // start from x and y coordinate
					count++;
				}
			}
		}
		return block;
	}

	// Helper method returns values
	private int[][] getValue() {
		return values;
	}

	// Helper method for print a 2d array
	public void print2dArray(Grid g) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(g.getValue()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//Grid test1 = TestGridSupplier.getPuzzle1();
		//Grid test2 = TestGridSupplier.getSolution1();
		//Grid test3 = TestGridSupplier.getPuzzle2();
		//Grid test4 = TestGridSupplier.getSolution2();
		//test2.next9Grids();
	}
}
