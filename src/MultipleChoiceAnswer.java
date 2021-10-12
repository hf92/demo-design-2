
public class MultipleChoiceAnswer extends Answer implements java.io.Serializable{
	String answer;
	
	public MultipleChoiceAnswer(){
		answer = "";
	}
	public MultipleChoiceAnswer(String p_answer){
		answer = p_answer;
	}
	
	public String getAnswer(){
		return answer;
	}
	public void setAnswer(String ans){
		answer = ans;
	}
}
