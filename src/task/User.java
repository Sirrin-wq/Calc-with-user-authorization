package task;

public class User {
    private String login = "empty";
    private String password = "empty";
    private boolean returnIndicator = false;

    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isReturnIndicator() {
        return returnIndicator;
    }

    public void setReturnIndicator(boolean returnIndicator) {
        this.returnIndicator = returnIndicator;
    }
}
