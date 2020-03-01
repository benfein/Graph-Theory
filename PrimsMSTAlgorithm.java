public class PrimsMSTAlgorithm {
    final static int VERTICES = 6;
    public static void main(String[] args) {
        int graph[][] = {
                {0, 16, 5, 0, 7, 0},
                {16, 0, 0, 7, 0, 0},
                {5, 0, 0, 27, 15,11},
                {0, 7, 27, 0, 0, 0},
                {7, 0, 15, 0, 0, 0},
                {0, 0, 11, 0, 0 ,0}};
        System.out.println(findSumOfMst(graph));
    }

    public static int findSumOfMst(int[][] graph) {
        int tempI = 0;
        int tempJ = 0;
        boolean[] visited = new boolean[VERTICES];
        int min = 9999;
        int currentNode = 0;
        visited[0] = true;

        int sum = 0;
        while (currentNode < VERTICES - 1) {
            for (int i = 0; i < VERTICES; i++) {
                if (visited[i] == true) {
                    for (int j = 0; j < VERTICES; j++) {
                        if (visited[j] == false && graph[i][j] > 0) {
                            if (graph[i][j] < min)
                                if (graph[i][j] > 0) {
                                    tempI = i;
                                    tempJ = j;
                                    min = graph[i][j];
                                }
                        }
                    }
                }

            }
            visited[tempJ] = true;
            sum = sum + graph[tempI][tempJ];
            System.out.println(tempI + "\t --> " + tempJ + " \t = \t" + " " + graph[tempI][tempJ]);
            tempI = 0;
            tempJ = 0;
            min = 9999;
            currentNode++;
        }
        return sum;
    }
}
