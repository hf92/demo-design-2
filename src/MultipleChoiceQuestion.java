import java.util.*;
public class MultipleChoiceQuestion extends Question implements java.io.Serializable{
	boolean hasSingleAnswer;
	MultipleChoiceAnswer[] choices;
	boolean tfquestion;
	String question;
	
	public MultipleChoiceQuestion(){
		
	}
	public MultipleChoiceQuestion(String prompt, boolean p_tfquestion, boolean p_hasSingleAnswer){
		super(prompt);
		tfquestion = p_tfquestion;
		hasSingleAnswer = p_hasSingleAnswer;
	}
	public boolean getLength(){
		return hasSingleAnswer;
	}
	public void setLength(boolean bool){
		hasSingleAnswer = bool;
	}
	public void setCorrectAnswer(MultipleChoiceAnswer  cAnswer){
		correctAnswer = cAnswer;
	}
	public void setUserAnswer(MultipleChoiceAnswer  uAnswer){
		userAnswer = uAnswer;
	}
	public MultipleChoiceAnswer getChoice(String s_answer){
		return choices[Integer.parseInt(s_answer)-1];
	}
	public int getNumChoices(){
		return choices.length;
	}
	public void setChoices(){
		Scanner scanner = new Scanner(System.in);
		int numChoices;
		if(tfquestion == false){
			System.out.println("How many choices?");
			try{
				numChoices = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Input Mismatch, returning");
				return;
			}
			choices = new MultipleChoiceAnswer[numChoices];
			for(int i = 0; i < numChoices; i++){
				System.out.println("Enter an answer option");
				String ans = scanner.next();
				choices[i] = new MultipleChoiceAnswer(ans);
			}
		}else{
			numChoices = 2;
			choices = new MultipleChoiceAnswer[numChoices];
			choices[0] = new MultipleChoiceAnswer("true");
			choices[1] = new MultipleChoiceAnswer("false");
		}
	}
	public void setCorrectAnswer(){
		Scanner scanner = new Scanner(System.in);
		int correctans;
		if(tfquestion = true){
			System.out.println("Which choice is the correct answer?((1)true/(2)false)");
			try{
				correctans = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Input Mismatch, returning");
				return;
			}
			correctAnswer = choices[correctans-1];	
		}else{
			System.out.println("Which choice is the correct answer?(number)");
			try{
				correctans = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Input Mismatch, returning");
				return;
			}
			correctAnswer = choices[correctans-1];
		}
		this.setCorrectAnswer(correctAnswer);
	}
	public void display(){
		System.out.println(prompt);
		for(int i = 0; i < choices.length; i++){
			System.out.println(i + 1 + ")" + choices[i].getAnswer());
		}
	}
}
