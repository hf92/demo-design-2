import java.util.*;

public class Form {
    List<Question> questions;
    String title;

    public Form() {
        questions = new ArrayList<Question>();
    }

    public void saveForm() {

    }

    public void setQuestion(Question question, int number) {
        questions.set(number - 1, question);
    }

    public Question getQuestion(int number) {
        return questions.get(number - 1);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String p_title) {
        title = p_title;
    }

    public void tabulateForm() {
        int TotalTrue;
        int TotalFalse;
        int TotalShort;
        int TotalChoice;
        for (int i = 0; i < this.questions.size(); i++) {
            TotalTrue = 0;
            TotalFalse = 0;
            TotalShort = 0;
            Question question = this.questions.get(i);
            if (question instanceof MultipleChoiceQuestion) {
                MultipleChoiceAnswer answer = (MultipleChoiceAnswer) question.getUserAnswer();
                if (((MultipleChoiceQuestion) question).tfquestion == true) {
                    if (answer.getAnswer().equals("true")) {
                        TotalTrue += 1;
                    } else {
                        TotalFalse += 1;
                    }
                } else {
                    int[] totalChoice = new int[((MultipleChoiceQuestion) question).getNumChoices()];
                    for (int j = 0; j < ((MultipleChoiceQuestion) question).getNumChoices(); j++) {
                        if (((MultipleChoiceQuestion) question).getChoice(Integer.toString(j + 1)).getAnswer()
                                .equals(answer.getAnswer())) {
                            totalChoice[j] += 1;
                        }
                    }
                }
            } else if (question instanceof MatchingQuestion) {
                MatchingAnswer answer = (MatchingAnswer) question.getUserAnswer();
                System.out.println(answer.getItems());
            } else if (question instanceof EssayQuestion) {
                EssayAnswer answer = (EssayAnswer) question.getUserAnswer();
                // short answer question
                if (((EssayQuestion) question).length < 60) {
                    TotalShort = TotalShort + answer.getAnswer().length();
                } else {
                    System.out.println(answer.getAnswer());
                }
            }
        }
    }
}
