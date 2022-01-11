package algo.graph.equation;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraph implements EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Graph graph = new Graph();
		for (int i = 0; i < equations.size(); i++) {
			var equation = equations.get(i);
			String num = equation.get(0);
			String den = equation.get(1);
			graph.addEdge(new Edge(num, den, values[i]));
			graph.addEdge(new Edge(den, num, 1 / values[i]));
		}

		double[] result = new double[queries.size()];
		Path pathFinder = new Path(graph);
		int i = 0;
		for (var query : queries) {
			List<Edge> p = pathFinder.path(query.get(0), query.get(1));

			if (p == null) {
				result[i] = -1;
			} else {
				double res = 1;
				for (Edge e : p) {
					res *= e.weight;
				}
				result[i] = res;
			}

			i++;
		}
		return result;
	}

	class Edge {
		final String from;
		final String to;
		final double weight;

		Edge(String f, String t, double w) {
			from = f;
			to = t;
			weight = w;
		}
	}

	class Graph {
		Map<String, List<Edge>> adj;

		Graph() {
			adj = new HashMap<>();
		}

		void addEdge(Edge e) {
			adj.computeIfAbsent(e.from, k -> new LinkedList<>()).add(e);
		}

		List<Edge> adj(String v) {
			return adj.getOrDefault(v, Collections.emptyList());
		}

		boolean has(String a) {
			return adj.containsKey(a);
		}
	}

	class Path {
		Graph g;

		Path(Graph g) {
			this.g = g;
		}

		List<Edge> path(String source, String dest) {
			if (!g.has(source))
				return null;
			return path(source, dest, new LinkedList<>(), new HashSet<>());
		}

		List<Edge> path(String start, String end, LinkedList<Edge> path, Set<String> visited) {
			if (start.equals(end)) {
				return path;
			}

			for (Edge e : g.adj(start)) {
				if (visited.contains(e.to)) {
					continue;
				}
				visited.add(e.to);
				path.add(e);
				if (path(e.to, end, path, visited) != null) {
					return path;
				}
				path.removeLast();
			}
			return null;
		}
	}

}
