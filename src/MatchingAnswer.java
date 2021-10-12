
public class MatchingAnswer extends Answer implements java.io.Serializable {
    String[] matched_items;

    public MatchingAnswer() {

    }

    public MatchingAnswer(String[] p_items) {
        matched_items = p_items;
    }

    public String[] getItems() {
        return matched_items;
    }

    public void setItems(String[] aItems) {
        matched_items = aItems;
    }
}
