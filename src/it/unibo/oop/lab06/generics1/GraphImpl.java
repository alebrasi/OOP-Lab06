package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphImpl<N> implements Graph<N>{

	private final Map<N, HashSet<N>> nodes;
	
	public GraphImpl() {
		nodes = new HashMap<N, HashSet<N>>();
	}
	
	public void addNode(N node) {
		if(node != null && !nodes.containsKey(node)) {
			nodes.put(node, new HashSet<N>());
		}
	}

	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			nodes.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return nodes.keySet();
	}

	public Set<N> linkedNodes(N node) {
		return nodes.get(node);
	}

	//Implemented as a DFS
	public List<N> getPath(N source, N target) {
		
		List<N> path = new ArrayList<>();
		Set<N> discoveredNodes = new HashSet<>();
		Stack<N> stack = new Stack<>();
		
		stack.push(source);
		while(!stack.isEmpty()) {
			N node = stack.pop();
			path.add(node);
			if(!discoveredNodes.contains(node)) {
				if(node.equals(target)) {
					break;
				}
				discoveredNodes.add(node);
				for (N n : linkedNodes(node)) {
					stack.push(n);
				}
			}
		}
		
		if(stack.isEmpty()) {
			path.add(target);
		}
		
		return path;
	}

}
