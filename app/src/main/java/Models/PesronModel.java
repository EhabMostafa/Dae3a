package Models;

public  class PesronModel {
    protected String fullName;
    protected String email;
    protected String password;
    protected boolean isAdmin;
    protected String phone;

    public void setEmail(String email) {
        this.email = email;
    }

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
