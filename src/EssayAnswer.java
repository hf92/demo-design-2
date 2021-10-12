
public class EssayAnswer extends Answer implements java.io.Serializable{
	String answer;
	public EssayAnswer(){
		
	}
	public EssayAnswer(String p_answer){
		answer = p_answer;
	}
	public String getAnswer(){
		return answer;
	}
	public void setAnswer(String pAnswer){
		answer = pAnswer;
	}
}
