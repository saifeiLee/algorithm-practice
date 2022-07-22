package graph.section1;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s]) {
                dfs(G, s, s);
            }

    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u) {
                // w是下一个与v连通的节点，u是上一个与v连通的节点，如果这两个不是同一个节点
                // 说明w,v,u这三个点之间应该有环存在
                hasCycle = true;
            }
    }
    public boolean hasCycle() {
        return hasCycle;
    }
}
