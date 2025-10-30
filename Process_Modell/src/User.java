import java.util.UUID;

public class User {
    private String name;
    private int userID;
    private int groupID;

    public User(String name, int userID, int groupID) {
        this.name = name;
        this.userID = userID;
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public int getGroupID() {
        return groupID;
    }
}
