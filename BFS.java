import java.io.*;
import java.util.*;
import java.text.*;
public class BFS{
    private static int[][] adjMatrix;
    private static final int size = 7;	
    private static boolean[] visitedNodes = new boolean[size];
    private static char[] vertices = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'};
    public static void main(String s[]){
        importData();
        System.out.println("Breadth First Search ...");
        DFS(adjMatrix, 0);
    }
    public static void DFS(int[][] graphMatrix, int currentNode) {
    	Queue<Integer> bfsQueue = new LinkedList<Integer>();
    	ArrayList<Integer> visited = new ArrayList<Integer>();
        bfsQueue.add(currentNode);
        visited.add(currentNode);
        while(!bfsQueue.isEmpty()) {
        	System.out.print(vertices[bfsQueue.peek()] + " ");
        	currentNode = bfsQueue.poll();
        	for(int i = 0; i < size; i++) {
        		if(graphMatrix[currentNode][i] > 0 && visited.contains(i) == false) {
        			bfsQueue.add(i);
        			visited.add(i);
        		}
        	}
        }
    }
    public static void importData(){
        try{
            FileReader reader = new FileReader("inputDataDFS1.txt");
            Scanner inFile = new Scanner(reader);
            adjMatrix = new int[size][size];
            for(int i=0;i<size; i++)
                for(int j=0; j<size; j++)
                    adjMatrix[i][j] = inFile.nextInt(); 
            inFile.close();
            reader.close();
        }catch(IOException ioe){
            System.out.println("file error");
        }
        for(int i = 0; i<size; i++){
            for(int j=0;j<size; j++) System.out.print(adjMatrix[i][j]+" ");
            System.out.println();
        }
    }

}
