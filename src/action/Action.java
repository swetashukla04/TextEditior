package action;

import java.time.LocalDateTime;

public class Action {

    private int actionId;
    private LocalDateTime localDateTime;
    private boolean isAddition;
    private int lineNumber;
    private String text;

    public Action(int actionId, LocalDateTime localDateTime, boolean isAddition, int lineNumber, String text) {
        this.actionId = actionId;
        this.localDateTime = localDateTime;
        this.isAddition = isAddition;
        this.lineNumber = lineNumber;
        this.text = text;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public boolean isAddition() {
        return isAddition;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getText() {
        return text;
    }

    

}
