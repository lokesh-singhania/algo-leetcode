package algo.stack.medium.impl.bc2;

import java.util.ArrayDeque;
import java.util.Deque;

import algo.stack.medium.BasicCalculator2;

public class UsingStack implements BasicCalculator2 {

	@Override
	public int calculate(String s) {
		Deque<Integer> numbers=new ArrayDeque<>();
		int number=0;
		char operation='+';
		for(char c:s.toCharArray()) {
			if(Character.isWhitespace(c)) {
				continue;
			}
			if(Character.isDigit(c)) {
				number = number*10 + (c-'0');
			}else {
				performAndAppend(numbers, number, operation);
				number=0;
				operation=c;
			}
		}
		performAndAppend(numbers, number, operation);
		
		return numbers.stream().mapToInt(Integer::intValue)
				.sum();
	}

	private void performAndAppend(Deque<Integer> numbers, int number, char operation) {
		switch(operation) {
		case '+':
			numbers.push(number);
			break;
		case '-':
			numbers.push(-number);
			break;
		case '/':
			numbers.push(numbers.pop()/number);
			break;
		case '*':
			numbers.push(numbers.pop()*number);
			break;
		}
	}

}
