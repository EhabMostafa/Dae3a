package Models;

public  class PesronModel {
    private int ID;
    protected String fullName;
    protected String email;
    protected String password;
    protected boolean isAdmin;
    protected String phone;

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;

    }

    public String getFullName() {

        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
