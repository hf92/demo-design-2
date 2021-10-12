
public class Question implements java.io.Serializable {
    String prompt;
    Answer userAnswer;
    Answer correctAnswer;

    public Question() {

    }

    public Question(String pPrompt) {
        prompt = pPrompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String newPrompt) {
        prompt = newPrompt;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer cAnswer) {
        correctAnswer = cAnswer;
    }

    public Answer getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Answer uAnswer) {
        userAnswer = uAnswer;
    }

    public boolean compareAnswers() {
        boolean bool = false;
        if (this instanceof MultipleChoiceQuestion) {
            MultipleChoiceAnswer userAns = (MultipleChoiceAnswer) userAnswer;
            MultipleChoiceAnswer corAns = (MultipleChoiceAnswer) correctAnswer;
            if (userAns.getAnswer().equals(corAns.getAnswer())) {
                bool = true;
            }
        } else if (this instanceof MatchingQuestion) {
            MatchingAnswer userAns = (MatchingAnswer) userAnswer;
            MatchingAnswer corAns = (MatchingAnswer) correctAnswer;
            if (userAns.getItems().equals(corAns.getItems()) || userAns.getItems().equals(corAns.getItems())) {
                bool = true;
            }
        }
        return bool;
    }

    public void display() {
        System.out.println(prompt);
    }
}
