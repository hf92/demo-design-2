import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Test extends Form {
	int grade;
	
	public Test(){
		super();
	}
	
	public void setGrade(int num){
		grade = num;
	}
	
	public int getGrade(){
		return grade;
	}
	public void display(){
		for(int i = 0; i < this.questions.size(); i++){
			System.out.println("Question " + i + ": ");
			this.questions.get(i).display();
			System.out.println("The correct answer is: ");
			this.questions.get(i).getCorrectAnswer();
			
			System.out.println("");
		}
	}
	public void save(){
		/*
		 * Stores all questions and answers in a java serialized format
		 */
		try{
			File file = new File(this.getTitle() + ".ser");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream fileOut = new FileOutputStream(file, false);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for(int i = 0; i < this.questions.size(); i++){
				out.writeObject(this.questions.get(i));
			}
			out.close();
			fileOut.close();
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	public void gradeTest(){
		int numQuestions = this.questions.size();
		int numCorrect = 0;
		for(int i = 0; i < this.questions.size(); i++){
			Question question = this.questions.get(i);
			if(!(question instanceof EssayQuestion)){
				if(question.compareAnswers() == true){
					numCorrect += 1;
				}
			}else{
				numQuestions = numQuestions - 1;
			}
		}
		System.out.print("Your grade is: ");
		System.out.println(numCorrect * 10 + "/" + numQuestions*10);
	}
}
