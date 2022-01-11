package algo.graph.order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Indegree implements Ordering {

	@Override
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] adjList = (List<Integer>[]) new List[numCourses];
		int[] indegree = new int[numCourses];
		Arrays.setAll(adjList, ArrayList::new);

		List<Integer> ordering = new ArrayList<>();

		for (int[] edge : prerequisites) {
			int dependent = edge[0];
			int dependency = edge[1];
			adjList[dependency].add(dependent);
			indegree[dependent]++;
		}

		Queue<Integer> feasibleCourses = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				feasibleCourses.add(i);
			}
		}

		while (!feasibleCourses.isEmpty()) {
			int feasibleCourse = feasibleCourses.remove();
			ordering.add(feasibleCourse);
			for (int course : adjList[feasibleCourse]) {
				indegree[course]--;
				if (indegree[course] == 0) {
					feasibleCourses.add(course);
				}
			}
		}

		if (ordering.size() == numCourses) {
			return toArray(ordering);
		}
		return new int[] {};
	}

	int[] toArray(List<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
