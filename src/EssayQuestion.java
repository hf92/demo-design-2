import java.util.*;
public class EssayQuestion extends Question implements java.io.Serializable{
	int length;
	EssayAnswer userAnswer;
	EssayAnswer correctAnswer;
	
	public EssayQuestion(){
		
	}
	public EssayQuestion(String prompt, int plength){
		super(prompt);
		length = plength;
	}
	public int getLength(){
		return length;
	}
	public void setLength(int num){
		length = num;
	}
	public EssayAnswer getCorrectAnswer(){
		return correctAnswer;
	}
	public void setCorrectAnswer(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the answer to the essay question: " + length + " words");
		String answer = scanner.next();
		correctAnswer = new EssayAnswer(answer);
	}
	public void setCorrectAnswer(EssayAnswer cAnswer){
		correctAnswer = cAnswer;
	}
	public EssayAnswer getUserAnswer(){
		return userAnswer;
	}
	public void setUserAnswer(EssayAnswer uAnswer){
		userAnswer = uAnswer;
	}
	public void display(){
		System.out.println(prompt);
	}
}
