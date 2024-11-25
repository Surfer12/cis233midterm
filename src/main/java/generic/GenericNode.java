package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericNode<T> {
    T data;
    List<GenericNode<T>> neighbors;

    public GenericNode(T data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GenericNode<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GenericNode<T> neighbor) {
        if (neighbor != null && !neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public void removeNeighbor(GenericNode<T> neighbor) {
        neighbors.remove(neighbor);
    }
}
