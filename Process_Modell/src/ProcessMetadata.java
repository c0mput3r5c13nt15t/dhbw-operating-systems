public class ProcessMetadata {
    private int parentProcessID;

    private int userID;
    private int groupID;

    public ProcessMetadata(int parentProcessID, int userID, int groupID) {
        this.parentProcessID = parentProcessID;
        this.userID = userID;
        this.groupID = groupID;
    }

    public int getParentProcessID() {
        return parentProcessID;
    }

    public int getUserID() {
        return userID;
    }

    public int getGroupID() {
        return groupID;
    }
}
