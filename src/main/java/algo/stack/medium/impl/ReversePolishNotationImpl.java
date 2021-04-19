package algo.stack.medium.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import algo.stack.medium.ReversePolishNotation;
import algo.util.ArrayUtil;

public class ReversePolishNotationImpl implements ReversePolishNotation{

	@Override
	public int evaluate(String[] tokens) {
		if(ArrayUtil.isEmpty(tokens)) {
			return 0;
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		for(String token : tokens) {
			switch(token) {
			case "+":
				stack.push(stack.pop()+stack.pop());
				break;
			case "-":
				int b= stack.pop();
				int a = stack.pop();
				stack.push(a-b);
				break;
			case "/":
				b= stack.pop();
				a = stack.pop();
				stack.push(a/b);
				break;
			case "*":
				stack.push(stack.pop()*stack.pop());
				break;
			default:
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}

}
