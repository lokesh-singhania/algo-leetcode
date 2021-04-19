package algo.stack.medium.impl.bc2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

import algo.stack.medium.BasicCalculator2;

public class UnoptimisedBadApproach implements BasicCalculator2 {

	@Override
	public int calculate(String s) {
		Queue<Object> tokens = getTokens(s);
		Deque<Object> tokensPostHighPriorityOperations = performHighPriorityOperations(tokens);

		return performAdditionAndSubtraction(tokensPostHighPriorityOperations);
	}

	private int performAdditionAndSubtraction(Deque<Object> tokens) {
		if(tokens.isEmpty()) return 0;
		
		int value=(int) tokens.remove();
		while(!tokens.isEmpty()) {
			Object token = tokens.remove();
			if(token instanceof Integer) {
				throw new RuntimeException("Expected operator, Found Integer");
			}else if(token instanceof Operator){
				Operator op= (Operator)token;
				value=op.perform(value,(int)tokens.remove());
			}
		}
		return value;
	}

	private Deque<Object> performHighPriorityOperations(Queue<Object> tokens) {
		Deque<Object> deque=new ArrayDeque<>();
		while(!tokens.isEmpty()) {
			Object element = tokens.remove();
			if(element instanceof Integer) {
				deque.addLast(element);
			}else if(element instanceof Operator) {
				Operator operator = (Operator) element;
				if(operator.isHighPriority) {
					int value = operator.perform((int)deque.removeLast(),(int)tokens.remove());
					deque.addLast(value);
				}else {
					deque.addLast(operator);
				}
			}
		}
		return deque;
	}

	private Queue<Object> getTokens(String s) {
		int number = 0;
		Queue<Object> tokens = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				continue;
			}
			if (Character.isDigit(c)) {
				number = number * 10 + (c - '0');
			} else {
				tokens.add(number);
				tokens.add(Operator.get(c));
				number = 0;
			}
		}
		tokens.add(number);
		return tokens;
	}

	enum Operator {
		ADD('+', (a, b) -> a + b),
		SUBTRACT('-', (a, b) -> a - b),
		DIVIDE('/', (a, b) -> a / b,true),
		MULTIPLY('*', (a, b) -> a * b,true);

		private final char symbol;
		private final IntBinaryOperator operation;
		public final boolean isHighPriority;

		private static Map<Character, Operator> operatorsBySymbol = Arrays.stream(Operator.values())
				.collect(Collectors.toMap(o -> o.symbol, Function.identity()));

		public static Operator get(char c) {
			return operatorsBySymbol.get(c);
		}

		private Operator(char symbol, IntBinaryOperator integerOperation) {
			this.symbol = symbol;
			operation = integerOperation;
			isHighPriority=false;
		}

		private Operator(char symbol, IntBinaryOperator operation, boolean isHighPriority) {
			this.symbol = symbol;
			this.operation = operation;
			this.isHighPriority = isHighPriority;
		}

		public int perform(int a, int b) {
			return operation.applyAsInt(a, b);
		}

	}

}
