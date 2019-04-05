package sudoku;

import java.util.*;


public class Solver 
{
	private Grid						problem;
	private ArrayList<Grid>				solutions;
	
	
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	// Standard backtracking recursive solver.
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			// Abandon evaluation of this illegal board.
			return;
		}
		else if (eval == Evaluation.ACCEPT)
		{
			// A complete and legal solution. Add it to solutions.
			solutions.add(grid);
		}
		else
		{
			// Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. 
			// Recursively call solveRecurse() on those grids.
			ArrayList<Grid> nextGrids = grid.next9Grids();
			for (Grid g : nextGrids){
				solveRecurse(g);
			}
		}
	}
	
	
	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	//
	public Evaluation evaluate(Grid grid)
	{
		if (!grid.isLegal()){ //illegal
			return Evaluation.ABANDON;
		}
		else if (grid.isLegal() && grid.isFull()){ //legal and complete
			return Evaluation.ACCEPT;
		}else{
			return Evaluation.CONTINUE; //legal and incomplete
		}

	}

	// Returns an ArrayList of solution
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle2();		// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("Will solve\n" + g);
		solver.solve();
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		Grid solution = TestGridSupplier.getSolution2();
		
		System.out.println("Backtracking - found " + solver.getSolutions().size() + " solutions");
		for (Grid grid : solver.getSolutions()){
			grid.print2dArray(grid);
			System.out.println("Equals? " + grid.equals(solution));
			System.out.println();
		}
		
		System.out.println("Solution\n" + solution);

	}
}
