import java.io.*;
import java.util.*;
import java.text.*;
public class DFS{
    private static int[][] adjMatrix;
    private static final int size = 15;	
    private static boolean[] visitedNodes = new boolean[size];
    private static char[] vertices = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'};
    public static void main(String s[]){
        importData();
        System.out.println("Depth First Search ...\n");
        DFS(adjMatrix);
    }
    public static void DFS(int[][] graphMatrix) {
        Stack<Integer> dfsStack = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        dfsStack.push(0);
        System.out.print(vertices[dfsStack.peek()] + " ");
        visited.add(dfsStack.peek());
        int i;
        boolean next;
        while(!dfsStack.empty())
        {
        	i = 0;
        	next = false;
        	while(i < size && next == false) {
        		if(graphMatrix[dfsStack.peek()][i] > 0 && visited.contains(i) == false && i != dfsStack.peek()) {
        			dfsStack.push(i);
        			System.out.print(vertices[dfsStack.peek()] + " ");
        			visited.add(dfsStack.peek());
        			next = true;
        		}
        		i++;
        	}
        	if(!next) {
        		dfsStack.pop();
        	}
        }
    }
    public static void importData(){
        try{
            FileReader reader = new FileReader("demo.txt");
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
