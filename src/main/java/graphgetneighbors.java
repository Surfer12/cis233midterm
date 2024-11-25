

import java.util.Set;

public interface graphgetneighbors<T> {

    void dfs(T node, Set<T> visited, Graph<T> graph);

}