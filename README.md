# Java-CS2-TopoSort


Programming Assignment #4: TopoPath COP 3503, Fall 2013
Due: Friday, October 25, 11:59 PM via Webcourses@UCF
Abstract
In this assignment, you will determine whether an arbitrary directed graph contains a topopath – an ordering of its vertices that simultaneously corresponds to a valid path in the graph and a valid topological sort.1
You will gain experience reading graphs from an input file, representing them computationally, and writing graph theory algorithms. You will also solidify your understanding of topological sorts, sharpen your problem solving skills, and get some practice at being clever, because your solution to this problem must be O(n2).
If you use any code that I have given you so far in class, you should probably include a comment to give me credit. The intellectually curious student will, of course, try to write the whole program from scratch.
Deliverables
TopoPath.java
 1 Topopath is a word I made up. Please don’t go out into the real world expecting other people to know what it means.
1. ProblemStatement
Given a directed graph, determine whether it has a topopath – an ordering of its vertices that simultaneously corresponds to a valid path in the graph and a valid topological sort. For example:
12121
2
(No topopath.) (No topopath.) (Contains a topopath.)
In G1, the vertex ordering 1, 2, 3, 4 is a valid topological, but does not correspond to a valid path in the graph (i.e., 1 → 2 → 3 → 4 is not a path in G1). In fact, none of the topological sorts for G1 correspond to actual paths through that graph.
In contrast, the vertex ordering 1, 2, 3, 4 corresponds to a valid path in G2 (i.e., 1 → 2 → 3 → 4 is an actual path in G2), but is not a valid topological sort for the graph. None of the paths in G2 correspond to a valid topological sort of that graph’s vertices.
In G3, the ordering 1, 2, 3 corresponds to both a valid path (1 → 2 → 3) and a valid topological sort. 2. InputFileFormat
Each input file contains a single digraph. The first line contains a single integer, n ≥ 2, indicating the number of vertices in the graph. (Vertices in these graphs are numbered 1 through n.) The following n lines are the adjacency lists for each successive vertex in the graph. Each adjacency list begins with a single non-negative integer, k, indicating the number of vertices that follow. The list of vertices that follows will contain k distinct integers (i.e., no repeats) on the range 1 through n. For example, the following text files correspond to the graphs G1, G2, and G3 that are pictured above:
g1.txt g2.txt g3.txt
3. RuntimeRequirements
Implement a solution that is O(n2), where n = |V|. Recall from our formal definition of Big-Oh that a faster solution is still considered O(n2).
                                    34343
G1 G2 G3
                4 13 23 4 14 0
4 12 13 14 12
3 12 13 0
       
4. MethodandClassRequirements
Implement the following methods in a class named TopoPath. Notice that these methods are static.
public static boolean hasTopoPath(String filename)
Open filename and process the graph it contains. If the graph has a topopath (explained above), return true. Otherwise, return false. The string filename will refer to an existing file, and it will follow the format indicated above. You may have your method throw exceptions as necessary.
public static double difficultyRating()
Return a double on the range 1.0 (ridiculously easy) to 5.0 (insanely difficult).
public static double hoursSpent()
Return an estimate (greater than zero) of the number of hours you spent on this assignment.
5. GradingCriteriaandMiscellaneousRequirements
The tentative scoring breakdown (not set in stone) for this programming assignment is:
80% program passes test cases
10% difficultyRating() and hoursSpent() return doubles in the specified ranges 10% adequate comments and whitespace
Programs that do not compile will receive zero credit. Please be sure to submit your .java file, not a .class file (and certainly not a .doc or .pdf file). Your best bet is to submit your program in advance of the deadline, then download the source code from Webcourses, re-compile, and re-test your code in order to ensure that you uploaded the correct version of your source code.
NEW! Please remove main() before submitting. A lot of main() methods are causing compilation issues because they include references to home-brewed classes that are not submitted with the assignment. Please remove.
Your program should not print anything to the screen. Extraneous output is disruptive to the TAs’ grading process and will result in severe point deductions. Please do not print to the screen.
Please do not create a java package. Articulating a package in your source code could be disruptive to the grading process and will result in severe point deductions.
Name your source file, class(es), and method(s) correctly. Minor errors in spelling and/or capitalization could be hugely disruptive to the grading process and may result in severe point deductions. Please double check your work!
Test your code thoroughly. Please be sure to create your own test cases and thoroughly test your code. Start early! Work hard! Ask questions! Good luck!
