package designMode.behavior.interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {

	//表达式
	private final Expression expression;

	//构造函数
	public Calculator(String expStr) { // expStr = a+b

		Stack<Expression> stack = new Stack<>();

		char[] charArray = expStr.toCharArray();// [a, +, b]

		Expression left;
		Expression right;

		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
			case '+': //
				left = stack.pop();
				right = new VarExpression(String.valueOf(charArray[++i]));
				stack.push(new AddExpression(left, right));
				break;
			case '-': // 
				left = stack.pop();
				right = new VarExpression(String.valueOf(charArray[++i]));
				stack.push(new SubExpression(left, right));
				break;
			default: 

				stack.push(new VarExpression(String.valueOf(charArray[i])));
				break;
			}
		}
		this.expression = stack.pop();
	}

	public int run(HashMap<String, Integer> var) {

		return this.expression.interpreter(var);
	}
}