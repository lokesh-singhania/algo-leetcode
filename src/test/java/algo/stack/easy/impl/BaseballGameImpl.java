package algo.stack.easy.impl;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import algo.stack.easy.BaseballGame;
//Learnings
// ArrayDeque
// Deque
public class BaseballGameImpl implements BaseballGame {

	@Override
	public int calPoints(String[] ops) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String op : ops) {
			switch (op) {
			case "+":
				int a = stack.pop();
				int b = stack.peek();
				stack.push(a);
				stack.push(a + b);
				break;
			case "D":
				stack.push(2 * stack.peek());
				break;
			case "C":
				stack.pop();
				break;
			default:
				stack.push(Integer.parseInt(op));
				break;
			}
		}
		return sum(stack);
	}

	private int sum(Collection<Integer> stack) {
		return stack.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}

}
