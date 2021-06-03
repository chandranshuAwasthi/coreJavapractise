package chandranshu.algorithms.practise;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {

    private int v;


    private LinkedList<Integer>[] linkedNodes;


    public BFSGraph(int v) {
        v = v;
        linkedNodes = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            linkedNodes[i] = new LinkedList<>();
        }
    }
    public void addEdges(int aarayIndex, int addElement) {
        linkedNodes[aarayIndex].add(addElement);


    }


    public void BFSpath(int initialValue) {
        boolean []visted=new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(initialValue);
        while (queue.size() != 0) {
            int n=queue.poll();
            visted[n]=true;
            Iterator<Integer> iyt = linkedNodes[initialValue].listIterator();
            while (iyt.hasNext()) {
               int k= iyt.next();
                if(!visted[k])
                queue.add(k);
            }
        }

    }
}