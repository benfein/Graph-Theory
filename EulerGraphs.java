//A Java Program to Determine Whether a Graph is Euler Circuit or Euler Trail
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class EulerGraphs {
    private static int[][] adjMatrix;
    private static int[] nodeDegrees;
    private static final int size = 15;
    private static int oddDegreeCount=0, evenDegreeCount=0;
    public static void main(String[] args) throws Exception{
        importData();   
        setDegrees();   
        countOddEven(); 
        if(oddDegreeCount == 2){
System.out.println("There is a Euiler Trail");
} 
if(evenDegreeCount == size){
System.out.println("There is a Euler circuit");
}
if(oddDegreeCount != 2 && evenDegreeCount != size) {
    System.out.println("There is neither a euler circuit or euler trail");
}
    }
    
    public static void importData() throws Exception{
               adjMatrix = new int[size][size];

        Scanner sc = new Scanner(new File("demoFile.txt"));
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                adjMatrix[i][j] = sc.nextInt();
            }
        }
    }
    
    public static void setDegrees(){  
        nodeDegrees = new int[size];
        for(int i =  0; i < size; i++){
for(int j = 0; j < size; j++){
    if(adjMatrix[i][j] > 0) {
        nodeDegrees[i] = nodeDegrees[i] + 1;
    }
}
}
       System.out.println("There are " + size + " vertices");
    }
        public static void countOddEven(){
 for(int i = 0; i < size; i++){
 if(nodeDegrees[i] % 2 == 0){
 evenDegreeCount++;
 } else{
oddDegreeCount++;
 }
 }
    }
}
