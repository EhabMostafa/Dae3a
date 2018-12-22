package Models;

public  class PesronModel {
    private int ID;
    protected String fullName;
    protected String email;
    protected String password;
    protected boolean isAdmin;
    protected String phone;

    public String getEmail() {
        return email;
    }
}
