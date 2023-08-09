import java.util.*;

class CompilationOrder {
    public static String repeat(String str, int pValue){
        String out = "";
        for(int i = 0; i < pValue; i++)
        {
            out += str;
        }
        return out;
    }
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies){
        List<Character> sortedOrder = new ArrayList<>();
        
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>(); 
        for( int x = 0; x < dependencies.size(); x++){
            char parent = dependencies.get(x).get(0);
            char child = dependencies.get(x).get(1);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }
        if(graph.size() <= 0){
            return sortedOrder;
        }

        for (int dependency = 0; dependency < dependencies.size(); dependency++){
            char parent = dependencies.get(dependency).get(1);
            char child = dependencies.get(dependency).get(0);
            graph.get(parent).add(child); 
            inDegree.put(child, inDegree.get(child) + 1);
        }
        Queue<Character> sources = new LinkedList<>();
        for(char key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                sources.add(key);
            }
        }

        while(!sources.isEmpty()){
            char vertex = sources.poll();
            
            sortedOrder.add(vertex);
            for(int child = 0; child < graph.get(vertex).size(); child++){
                inDegree.put(graph.get(vertex).get(child), inDegree.get(graph.get(vertex).get(child)) -1);
                if(inDegree.get(graph.get(vertex).get(child)) == 0){
                    sources.add(graph.get(vertex).get(child));
                }
            }
        }

        if(sortedOrder.size() != graph.size()){
            return new ArrayList<>();
        }
        return sortedOrder;
    }
    public static void main( String args[] ) {
        List<List<List<Character>>> inputs = Arrays.asList(
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'),Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
            Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
            Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
            Arrays.asList(Arrays.asList('C', 'C'))
        );
          ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>();
    for(int j = 0; j < inputs.size(); j++)
    {
      dependencies.add(new ArrayList<ArrayList<Character>>());
      for(int k = 0; k < inputs.get(j).size(); k++)
      {
        dependencies.get(j).add(new ArrayList<Character>());
        for(int g = 0; g < inputs.get(j).get(k).size(); g++)
        {
          dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
        }
      }
    }
        for(int i = 0; i < dependencies.size(); i++)
        {
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(repeat("-", 100));
        }
    }
}

// TC: O(V + E), SC: O(V)


/*
Algorithms:
    1. Build a graph from the dependencies list and keep track of the in-degrees of vertices in a hash map.
    2. Populate the sources deque with vertices with in-degrees 
    3. Add the sources to the sorted list.
    4. Remove the sources from the graph and update the in-degrees of their children. If the in-degree of a child becomes 0, it becomes a source in the next iteration.
    5. Repeat until all vertices are visited.
*/