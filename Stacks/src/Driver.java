//import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
//		Scanner keyboardInput = new Scanner(System.in);
//		System.out.print("Type your equation: ");
//		String equation = keyboardInput.next();
		String equation = "(11 /(AD+ b))* 2^C% (45)";
		
        System.out.println("Infix: " + equation);
        System.out.println("Postfix: " + InfixToPostfix.convertToPostFix(equation));

	}

}
