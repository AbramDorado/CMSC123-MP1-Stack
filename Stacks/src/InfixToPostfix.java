public class InfixToPostfix {
	private String infix;

	public InfixToPostfix(String infix){
		this.infix = infix;
	}
	
	//auxiliary function to tell the signs and their precedence
	public static int sign(char operator) {
		if(operator=='+'||operator=='-')//lower precedence
			return 1;	
		else if (operator=='*'||operator=='/')//higher precedence
			return 2;
		else if (operator=='^'||operator=='%') //higher precedence
			return 3;
		else 
			return -1;
	}
	
	//a method to convert the infix expression to postfix expression
	//Note: this method converts the value of the instance variable infix
	public static String convertToPostFix(String equation){
		
		String output = ""; //where we will append the result
		Stack stacky = new ArrayStack(); //create stack
			
		for (int i = 0; i < equation.length() ; i++) {
            char symbol = equation.charAt(i); //check each symbol in the equation 
		
			//check if it is an operator
			if (sign(symbol) > 0) { // using the auxiliary function
				// if higher precedence
				while (stacky.isEmpty() == false 
					&& sign((Character)stacky.top()) >= sign(symbol)) {
					
					output += " "; //append spaces in the output
					output += stacky.top();
					stacky.pop();//pop symbols in the stack
				}
				stacky.push(symbol);//push in the stack
				output += " "; //append spaces in the output
			}	
			
			//check if the symbol is close parenthesis
			else if (symbol == ')') {
				// if higher precedence
				while(stacky.isEmpty() == false 
					&& ((Character)stacky.top() != '(')) {
					
					output += " ";//append spaces in the output
					output += stacky.top();
					stacky.pop();//pop symbols in the stack
				}
				stacky.pop();//pop symbols in the stack
			}
			
			//check if symbol is close parenthesis
			else if (symbol == '(')
				stacky.push(symbol);//push in the stack
			
			//check if its a character or number
			else if (Character.isLetterOrDigit(symbol)) {
				output += symbol;
			}
		}
		
		//pops the items in the stack
		while (stacky.isEmpty() == false) {
			
			output += " ";//append spaces in the output
			output += stacky.top();
			stacky.pop(); //pop symbols in the stack
		}	
		
		return output; //pass the output
	}
}

