//Jorge Berroa
//COP3503c
//J3354457



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class TopoPath {

	// Credits to Professor Szumlanski for providing the toposort method 
	public static boolean topoSort(boolean matrix[][]) {
		int[] incoming = new int[matrix.length];
		int cnt = 0;
		ArrayList<Integer> sort = new ArrayList<Integer>();

		// Count the number of incoming edges incident to each vertex. For
		// sparse
		// graphs, this could be made more efficient by using an adjacency list.
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				incoming[j] += (matrix[i][j] ? 1 : 0);

		Queue<Integer> q = new ArrayDeque<Integer>();

		// Any vertex with zero incoming edges is ready to be visited, so add it
		// to
		// the queue.
		for (int i = 0; i < matrix.length; i++)
			if (incoming[i] == 0) {
				q.add(i);
			}

		while (!q.isEmpty()) {
			// Pull a vertex out of the queue and add it to the topological
			// sort.
			int node = q.remove();
			sort.add(node);
			// System.out.print(node);

			// Count the number of unique vertices we see.

			++cnt;

			// All vertices we can reach via an edge from the current vertex
			// should
			// have their incoming edge counts decremented. If one of these hits
			// zero, add it to the queue, as it's ready to be included in our
			// topological sort.
			for (int i = 0; i < matrix.length; i++)
				if (matrix[node][i] && --incoming[i] == 0)
					q.add(i);
		}
		// If we pass out of the loop without including each vertex in our
		// topological sort, we must have a cycle in the graph.
		if (cnt != matrix.length) {
			return false;
		}
		return determine_path(sort, matrix);
	}
	// by checking each index with its adjacent index from the array list given to us form toposort we have a topoogical sort sequence 
	//we can determine  if that vertex has an edge from the first index to the next by checking those values in our boolean array if they all have a 
	//an edge between one another then we know there is a path in the topological sort .

	public static boolean determine_path(ArrayList<Integer> sort, boolean[][] matrix) {
		for (int i = 0; i < sort.size() - 1; i++) {

			if (matrix[sort.get(i)][sort.get(i + 1)] != true) {

				return false;
			}

		}
		return true;

	}
	public static double hoursSpent(){
		return 6.2;
	}

public static double difficultyRating(){
	return 3.7;
}

	public static boolean hasTopoPath(String filename) {
														// Initialize 'matrix' from input file
		Scanner in;
		try { 											// initializing boolean board and checking for exception handling
			in = new Scanner(new File(filename));

			int N = in.nextInt();
			boolean matrix[][] = new boolean[N][N];
			int cnt = 0;
			while (N > 0) {
				int num_inserting = in.nextInt();
				while (num_inserting > 0) {
					int index = in.nextInt();
					matrix[cnt][index - 1] = true;
					--num_inserting;
				}

				++cnt;
				--N;
			}

			return topoSort(matrix);

		} catch (FileNotFoundException e) {

		}
		return false;

	}

}
