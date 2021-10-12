import java.util.*;

public class MatchingQuestion extends Question implements java.io.Serializable {
    /**
     * 
     */
    int numRanks;
    String[] items;
    String[] matchingItems;
    int[] ranks;
    boolean matching;
    MatchingAnswer userAnswer;
    MatchingAnswer correctAnswer;

    public MatchingQuestion() {

    }

    public MatchingQuestion(String prompt, boolean p_matching) {
        super(prompt);
        matching = p_matching;
    }

    public int getNumRanks() {
        return numRanks;
    }

    public void setNumRanks(int num) {
        numRanks = num;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] p_items) {
        items = p_items;
    }

    public boolean getMatching() {
        return matching;
    }

    public MatchingAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(MatchingAnswer cAnswer) {
        correctAnswer = cAnswer;
    }

    public MatchingAnswer getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(MatchingAnswer uAnswer) {
        userAnswer = uAnswer;
    }

    public void setRanks() {
        Scanner scanner = new Scanner(System.in);
        if (matching == false) {
            System.out.println("How many ranks?");
            try {
                numRanks = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch, returning");
                return;
            }
            items = new String[numRanks];
            for (int i = 0; i < numRanks; i++) {
                System.out.println("Enter a ranked item");
                String ans = scanner.next();
                items[i] = ans;
            }
        } else {
            System.out.println("How many ranks?");
            try {
                numRanks = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch, returning");
                return;
            }
            items = new String[numRanks];
            matchingItems = new String[numRanks];
            for (int i = 0; i < numRanks; i++) {
                System.out.println("Enter a ranked item");
                String ans = scanner.next();
                items[i] = ans;
                System.out.println("Enter a matching item");
                String match = scanner.next();
                matchingItems[i] = match;
            }
        }
    }

    public void setCorrectAnswer() {
        Scanner scanner = new Scanner(System.in);
        if (matching == false) {
            for (int i = 0; i < numRanks; i++) {
                int num;
                System.out.println("Enter the rank for: ");
                System.out.println(items[i]);
                try {
                    num = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Input Mismatch, returning");
                    return;
                }
                ranks[i] = num;
            }
        } else {
            System.out.println("Items");
            for (int i = 0; i < numRanks; i++) {
                System.out.println(i + 1 + ")" + items[i]);
            }
            System.out.println("Matching items");
            for (int i = 0; i < numRanks; i++) {
                System.out.println(i + 1 + ")" + matchingItems[i]);
            }
            String[] tempMatching = new String[numRanks];
            for (int i = 0; i < numRanks; i++) {
                System.out.println("Enter the matching item number for item " + i + 1);
                tempMatching[i] = matchingItems[scanner.nextInt() - 1];
            }
        }
    }

    public void display() {
        System.out.println(this.prompt);
        if (matching == false) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + 1 + ")" + items[i]);
            }
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + 1 + ")" + items[i]);
            }
        }
        System.out.println("");
    }
}
