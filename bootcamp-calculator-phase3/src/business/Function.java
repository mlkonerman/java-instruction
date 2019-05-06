package business;

public class Function {
	int firstNum, secondNum, answer;

	public int addition(int firstNum, int secondNum ){
	      return firstNum + secondNum;
    }

	public int subtraction(int firstNum, int secondNum ){
	      return firstNum - secondNum;
  }
    
	public int multiplication(int firstNum, int secondNum ){
	      return firstNum * secondNum;
  }

	public double division(int firstNum, int secondNum ){
	      return (double)firstNum / secondNum;
  }
    
	public int modulus(int firstNum, int secondNum ){
	      return firstNum % secondNum;
  }

}
