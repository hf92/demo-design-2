import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class Interface {
    static ArrayList<Form> savedForms;

    public static void main(String[] args) {
        savedForms = new ArrayList();
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        Survey newSurvey = new Survey();
        Test newTest = new Test();
        while (quit != true) {
            try {
                System.out.println("1) Create a new Survey");
                System.out.println("2) Create a new Test");
                System.out.println("3) Display Survey");
                System.out.println("4) Display a Test");
                System.out.println("5) Save a Survey");
                System.out.println("6) Save a Test");
                System.out.println("7) Modify an Existing Survey");
                System.out.println("8) Modify an Existing Test");
                System.out.println("9) Load a Survey");
                System.out.println("10) Load a Test");
                System.out.println("11) Take a Survey");
                System.out.println("12) Take a Test");
                System.out.println("13) Grade a Test");
                System.out.println("14) Tabulate a Survey");
                System.out.println("15) Tabulate a Test");
                System.out.println("16) Quit");
                int num = scanner.nextInt();
                String file_name;
                switch (num) {
                    case 1:
                        newSurvey = createSurvey();
                        break;
                    case 2:
                        newTest = createTest();
                        break;
                    case 3:
                        newSurvey.display();
                        break;
                    case 4:
                        newTest.display();
                        break;
                    case 5:
                        newSurvey.save();
                        savedForms.add(newSurvey);
                        break;
                    case 6:
                        newTest.save();
                        savedForms.add(newTest);
                        break;
                    case 7:
                        modifyForm();
                        break;
                    case 8:
                        modifyForm();
                        break;
                    case 9:
                        System.out.println("Enter the file name of a Survey you want to load.");
                        file_name = scanner.nextLine();
                        loadForm(file_name);
                        break;
                    case 10:
                        System.out.println("Enter the file name of a Survey you want to load.");
                        file_name = scanner.nextLine();
                        loadForm(file_name);
                        break;
                    case 11:
                        newSurvey = (Survey) takeForm(newSurvey);
                        break;
                    case 12:
                        newTest = (Test) takeForm(newTest);
                        break;
                    case 13:
                        newTest.gradeTest();
                        break;
                    case 14:
                        newSurvey.tabulateForm();
                        break;
                    case 15:
                        newTest.tabulateForm();
                        break;
                    default:
                        System.out.println("Quitting");
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch, quitting");
                quit = true;
            }
        }
    }

    public static Survey createSurvey() {
        /*
         * Creates a survey
         */
        Survey survey = new Survey();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Enter the name of the survery.");
        String name = scanner.next();
        survey.setTitle(name);
        while (quit != true) {
            try {
                System.out.println("1) Add a new T/F question");
                System.out.println("2) Add a new multiple choice question");
                System.out.println("3) Add a new short answer question");
                System.out.println("4) Add a new essay question");
                System.out.println("5) Add a new ranking question");
                System.out.println("6) Add a new matching question");
                System.out.println("7) Quit");
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(enterQuestion(), true, true);
                        question1.setChoices();
                        survey.addQuestion(question1);
                        break;
                    case 2:
                        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(enterQuestion(), false, true);
                        question2.setChoices();
                        survey.addQuestion(question2);
                        break;
                    case 3:
                        EssayQuestion question3 = new EssayQuestion(enterQuestion(), 60);
                        survey.addQuestion(question3);
                        break;
                    case 4:
                        EssayQuestion question4 = new EssayQuestion(enterQuestion(), 120);
                        survey.addQuestion(question4);
                        break;
                    case 5:
                        MatchingQuestion question5 = new MatchingQuestion(enterQuestion(), false);
                        question5.setRanks();
                        survey.addQuestion(question5);
                        break;
                    case 6:
                        MatchingQuestion question6 = new MatchingQuestion(enterQuestion(), true);
                        question6.setRanks();
                        survey.addQuestion(question6);
                        break;
                    default:
                        System.out.println("Quitting");
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch, Quitting");
                quit = true;
            }
        }
        return survey;
    }

    public static Test createTest() {
        /*
         * Creates a test
         */
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Enter the name of the test.");
        String name = scanner.next();
        test.setTitle(name);
        while (quit != true) {
            try {
                System.out.println("1) Add a new T/F question");
                System.out.println("2) Add a new multiple choice question");
                System.out.println("3) Add a new short answer question");
                System.out.println("4) Add a new essay question");
                System.out.println("5) Add a new ranking question");
                System.out.println("6) Add a new matching question");
                System.out.println("7) Quit");
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(enterQuestion(), true, true);
                        question1.setChoices();
                        question1.setCorrectAnswer();
                        test.addQuestion(question1);
                        break;
                    case 2:
                        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(enterQuestion(), false, true);
                        question2.setChoices();
                        question2.setCorrectAnswer();
                        test.addQuestion(question2);
                        break;
                    case 3:
                        EssayQuestion question3 = new EssayQuestion(enterQuestion(), 60);
                        question3.setCorrectAnswer();
                        test.addQuestion(question3);
                        break;
                    case 4:
                        EssayQuestion question4 = new EssayQuestion(enterQuestion(), 120);
                        question4.setCorrectAnswer();
                        test.addQuestion(question4);
                        break;
                    case 5:
                        MatchingQuestion question5 = new MatchingQuestion(enterQuestion(), false);
                        question5.setRanks();
                        question5.setCorrectAnswer();
                        test.addQuestion(question5);
                        break;
                    case 6:
                        MatchingQuestion question6 = new MatchingQuestion(enterQuestion(), true);
                        question6.setRanks();
                        question6.setCorrectAnswer();
                        test.addQuestion(question6);
                        break;
                    default:
                        System.out.println("Quitting");
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch, quitting");
                quit = true;
            }
        }
        return test;
    }

    public static String enterQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your question");
        return scanner.next();
    }

    public static void modifyForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the survey you wish to modify");
        String name = scanner.next();
        Form form = null;
        /*
         * this is where I would deserialize the survey/test try { FileInputStream fis =
         * new FileInputStream(new File(name + ".ser")); ObjectInputStream in = new
         * ObjectInputStream(fis); try{ form = (Form) in.readObject(); }catch
         * (ClassCastException e){ e.printStackTrace(); } } catch (FileNotFoundException
         * e) { System.out.println("File not found."); e.printStackTrace(); } catch
         * (IOException e) { e.printStackTrace(); } catch (ClassNotFoundException e){
         * e.printStackTrace(); }
         */
        for (int i = 0; i < savedForms.size(); i++) {
            Form s_form = savedForms.get(i);
            if (s_form.getTitle().equals(name)) {
                form = savedForms.get(i);
            }
        }
        boolean quit = false;
        while (quit != true && form != null) {
            Question question = null;
            System.out.println("Enter existing question(number or q to quit)");
            int q_num = -1;
            try {
                q_num = (Integer.parseInt(scanner.next()));
            } catch (NumberFormatException nfe) {
                quit = true;
            }
            if (q_num != -1) {
                question = form.getQuestion(q_num);
            } else {
                System.out.println("Number format not correct");
            }
            if (question != null) {
                form.setQuestion(modifyQuestion(form, question), q_num);
            }
        }
    }

    public static Question modifyQuestion(Form form, Question p_question) {
        Scanner scanner = new Scanner(System.in);
        String input;
        p_question.display();
        System.out.println("Modify the prompt?(y/n)");
        input = scanner.next();
        if (input.equals("y")) {
            System.out.println("Enter new prompt.");
            input = scanner.next();
            p_question.setPrompt(input);
            System.out.println("Prompt: " + p_question.getPrompt());
        }
        if (p_question.getClass().getName().equals("MultipleChoiceQuestion")) {
            MultipleChoiceQuestion question = (MultipleChoiceQuestion) p_question;
            System.out.println("Modify the choices?(y/n)");
            input = scanner.next();
            if (input.equals("y")) {
                question.setChoices();
            }
            if (form.getClass().getName().equals("Test")) {
                System.out.println("Modify the correct answer?(y/n)");
                if (input.equals("y")) {
                    question.setCorrectAnswer();
                }
            }
            return question;
        } else if (p_question.getClass().getName().equals("EssayQuestion")) {
            EssayQuestion question = (EssayQuestion) p_question;
            // Short answer being defined as a EssayQuestion with length <= 60
            if (form.getClass().getName().equals("Test") && question.getLength() <= 60) {
                System.out.println("Modify the correct answer?(y/n)");
                if (input.equals("y")) {
                    question.setCorrectAnswer();
                }
            }
            return question;
        } else if (p_question.getClass().getName().equals("RankingQuestion")) {
            MatchingQuestion question = (MatchingQuestion) p_question;
            System.out.println("Modify the Items?(y/n)");
            input = scanner.next();
            if (input.equals("y")) {
                question.setRanks();
            }
            if (form.getClass().getName().equals("Test")) {
                System.out.println("Modify the correct answer?(y/n)");
                if (input.equals("y")) {
                    question.setCorrectAnswer();
                }
            }
            return question;
        }
        return p_question;
    }

    public static void loadForm(String file_name) {
        try {
            FileInputStream fis = new FileInputStream(file_name);
            ObjectInputStream in = new ObjectInputStream(fis);
            Object obj = in.readObject();
            if (obj instanceof Form) {
                System.out.println("Form");
            }
        } catch (Exception e) {
            System.out.println("Could not load an object");
        }
    }

    public static Form takeForm(Form form) {
        System.out.println(form.getTitle());
        List<Question> questions_list = form.getQuestions();
        Question question;
        Scanner scanner = new Scanner(System.in);
        String s_answer;
        for (int i = 0; i < questions_list.size(); i++) {
            question = questions_list.get(i);
            question.display();
            if (question instanceof EssayQuestion) {
                EssayAnswer answer = new EssayAnswer();
                System.out.println("answer: ");
                s_answer = scanner.nextLine();
                answer.setAnswer(s_answer);
                question.setUserAnswer(answer);
            } else if (question instanceof MatchingQuestion) {
                String[] rank = new String[((MatchingQuestion) question).getNumRanks()];
                String[] item = new String[((MatchingQuestion) question).getNumRanks()];

                for (int j = 0; j < ((MatchingQuestion) question).getNumRanks(); j++) {
                    System.out.println("Enter a rank");
                    rank[j] = scanner.nextLine();
                    System.out.println("Enter matching item");
                    item[j] = scanner.nextLine();
                }
                question.setUserAnswer(new MatchingAnswer(rank));
            } else if (question instanceof MultipleChoiceQuestion) {
                MultipleChoiceAnswer answer = new MultipleChoiceAnswer();
                System.out.println("answer(number): ");
                s_answer = scanner.nextLine();
                answer.setAnswer(((MultipleChoiceQuestion) question).getChoice(s_answer).getAnswer());
                question.setUserAnswer(answer);
            }
        }
        return form;
    }
}
