package User_Hompage;

class PriorityItem {
    private String content;
    private int priority;

    public PriorityItem(String content, int priority) {
        this.content = content;
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }
}

