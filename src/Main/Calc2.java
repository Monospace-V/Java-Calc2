/*
 * Monospace.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author Monospace
 */
public class Calc2 {

    
    static void Addition(Scanner ma)
    {
	System.out.println("You chose addition. Naive.");
	System.out.println("Enter the first number");
	float a = ma.nextFloat();
	System.out.println("Enter the second number");
	float b = ma.nextFloat();
	System.out.println("The sum is " + (a + b));
    }
    
    static void Subtraction(Scanner ma)
    {
	System.out.println("You chose subtraction.");
	System.out.println("Enter the first number");
	float a = ma.nextFloat();
	System.out.println("Enter the number to be subtracted");
	float b = ma.nextFloat();
	System.out.println("The difference is " + (a - b));
    }
    
    static void Multiplication(Scanner ma)
    {
	System.out.println("You chose multiplication.");
	System.out.println("Enter the first number");
	float a = ma.nextFloat();
	System.out.println("Enter the second number");
	float b = ma.nextFloat();
	System.out.println("The product is " + (a * b));
    }
    
    static void Division(Scanner ma)
    {
	System.out.println("You chose division. Be careful around your zeroes!");
	System.out.println("Enter the dividend");
	float a = ma.nextFloat(); //Accept numerator.
	System.out.println("Enter the divisor");
	float b = ma.nextFloat(); //Accept denominator.
	if (b == 0) //The 0 check.
	{
	    System.out.println("Undefined. So sorry.");

	}
	else // if (b != 0) // non-zero check unnecessary.
	{
	    System.out.println("Answer: " + (a / b));
	}
    }
    
    static void PrimeCompo(Scanner ma)
    {
	System.out.println("You chose to check for whether your number's prime/composite. Input:");
	float a=ma.nextFloat(); //i=input
	float d=1; //d=divisor. Setting as 1 and adding 1 in while loop instead of doing d++
	//after condition. because that way, once the loop breaks I still have the
	//proper value of d to check d==n and not (d-1)==n.
	float r=1; //r=remainder checker
	if (a%1==0)
	{
	    while (r!=0) //Ends loop if we get a remainder 0, ie perfect division.
	    {
		d++; //Increment d on each loop. Done after 1 so starts at 2, cause 1 divides 'em all.
		r=a%d;
	    }
	    if (d==a)   //See if first available factor is the input.
			//If yes, nothing lesser than input divides it. Prime by definition.
	    {
		System.out.println("Prime");
	    }
	    else
	    {
		System.out.println("Composite");
	    }
	}
	else
	{
	    System.out.println("Invalid input.");
	}
    }

    static void Factorial(Scanner ma)
    {
	float c; //c is a counter
	float fact=1; //fact is the factorial
	System.out.println("Input the number whose factorial you want");
	float a=ma.nextFloat();
	if (a%1==0)
	{
	    for(c=a;c>1;c--) //c is just a placeholder counter.
	    {
		fact=fact*c;
	    }
	    System.out.println("Factorial is "+fact);
	}
	else
	{
	    System.out.println("Invalid input.");
	}
    }
    
    
    static void Calculator(Scanner ma)
    {
	System.out.println("A for Addition, S for subtraction, M for multiplication, D for division. P for prime/composite, F for factorial, E for exponential power. Any other input, the first letter will be checked.");
	System.out.println("Inputting a non-number value or a stupidly large value into a number's rightful position will break the program. Note.");
	String ip = ma.next(); //ma is the user requested action Token.
	/*
	On a related note. I used ma.next() instead of ma.nextLine(); because the latter broke the code because it put a whitespace into 
	a character editor because it https://web.archive.org/web/20200520132726/https://www.reddit.com/r/javahelp/wiki/scanner
	Also see line with "ma.useDelimiter"
	*/
	String er = ip.toUpperCase(); //Convert to uppercase so I can use only uppercase in checking statement for if(switch) instead of checking for both D AND d ('D', 'd')
	char fx = er.charAt(0); //Take first letter
	switch (fx) {
	    /* It occurs to me I can set a separate scanner for each function instead of cal for all.*/
	    case 'D': // D for division
	    {
		Division(ma);
	    }
	    break; //Prevent program from going to the next case even with a mismatch
	    case 'A': //Addition
	    {
		Addition(ma);
	    }
	    break; //Apparently a -> instead of : kills the need for a break statement after the case, when specifying the case qualifications.
	    case 'S': //Subtraction
	    {
		Subtraction(ma);
	    }
	    break; //unfortunately, trying to use a -> for onlinegdb and bluej throw errors.
	    case 'M': //Multiplication
	    {
		Multiplication(ma);
	    }
	    break; //So either NetBeans is different or syntax needs to be tighter there.
	    case 'P': //Prime/composite
	    {
		PrimeCompo(ma);
	    }
	    break;
	    case 'F': //Factorial
	    {
		Factorial(ma);
	    }
	    break;
	    
	    default: //Fallback if none of the above cases
	    {
		System.out.println("Sorry, you can't quite read.");
		//Calculator(ma); //Statement removed because anyone putting in the wrong input will do it again regardless of whether they want to. Also because it threw the infinite
		//recursion error. Eep.
	    }
	    break; //It's ok. I do need to use commonly usable code anyway. Standards and all that.

	}
	/* It occurs to me I can set a separate scanner for each function instead of cal for all.*/
	//cal.close(); //Don't close cal here:
	/*It was this line causing me problems, y'know, universe. Presumably because running the loop with y means that a closed scanner class is re-opened. Eep!*/

    }

    static void Repeat(Scanner ma, int invalid) {
	//Repeat/end:
	{
	    System.out.println("Would you like to do that again? y/n");
	    String rptIn = ma.next(); //Accept repeat y/n input, or RePeaT Input.
	    String rbaby = rptIn.toLowerCase();
	    /*Convert input to lowercase so the y/n check can be done without checking both cases.
						Is a placeholder between "accept input" and "take first character."*/
	    char r = rbaby.charAt(0); //Declate and initialize r as first character of rbaby (converted input)
	    switch (r) {
		case 'y': // Yes: redirect to re-running execution script again. Additionally reset invalid repeat counter to 0.
		{
		    //main(null); //using main(null) instead of Calculator(ma) because I want it to ask for repeat later.
		    Execute(ma); //using Execute(ma) instead of main(null) because I don't want it saying "Calculator!" again and re-opening Scanner ma.
		}
		break; //But apparently the -> case switches are called rule switches.
		case 'n': // No: end the program, continue with execute() which continues over to main() which ends the program.
		{
		    // System.out.print(""); //Empty print statement. I need it to continue to end.
		}
		break; //You learn something new every day.
		default: // In case of a non-valid y/n input,
		{
		    if (invalid < 5) //If <5 repeats re-run the method to repeat, which then re-asks user if they wanna repeat.
		    {
			System.out.println("Sorry, invalid input. From an invalid. Heheh.");
			invalid++;
			//System.out.println(invalid); //Placeholder to check value of invalid to ensure it worky.
			Repeat(ma, invalid);

		    } else // End if repeat counter hits 5. ie, invalid input five times in a row.
		    {
			System.out.println("You know what, you're tiring me out. Forget it.");
		    }
		}
		break; //btw because they have a name there must be a way to use 'em elsewhere.
	    }
	}
    }

    static void Execute(Scanner ma) //The main execution script.
    {
	int invalid = 0; //int invalid checks how many times the "Repeat" script has run. It's the invalid repeat counter.
	/*Note, int invalid=0 placed here because I want it to reset each time "y" is selected on "do again?"
	so that the program doesn't abruptly stop on an invalid input WITHOUT the user having run invalid repeat 5 times in a row and triggering invalid++.*/
	Calculator(ma); //Run the method Calculator with scanner ma as a parameter.
	Repeat(ma, invalid); //Run method to repeat
    }

    
    public static void main(String[] args) {
	System.out.println("Calculator!");
	//Scanner cal=new Scanner(System.in); //Creation of scanner class specifically for calculator
	Scanner ma = new Scanner(System.in); //Create scanner class for program.
//	ma.useDelimiter(System.lineSeparator()); //So that program doesn't break if I input as nextLine instead
		    //of next throwing a \n into the checker. In combination with the fix on line 19.
		    //Delimiter statement stops program at input?
	Execute(ma); //Proxy script that runs the Calculator script and the repeat script.
	ma.close(); //Close scanner ma
	System.out.println("Hate to see you go... love to watch you leave!"); //Have you forgotten it's me making the program? I hope not.
    }

}
