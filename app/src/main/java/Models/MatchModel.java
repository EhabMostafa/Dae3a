package Models;

import java.util.Date;

public class MatchModel {
    private int ID;
    private String address;
    private Date foundedDate;
    private String additional_information;
    private boolean IsOrg;
    private PesronModel person;
    public void setID(int ID)
    {
        this.ID=ID;
    }
    public int getID()
    {
        return ID;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return address;
    }
    public void setFoundedDate(Date foundedDate)
    {
        this.foundedDate=foundedDate;
    }
    public Date getFoundedDate()
    {
        return foundedDate;
    }
    public void setAdditionalInformation(String additional_information)
    {
        this.additional_information=additional_information;
    }
    public String getAdditionalInformation()
    {
        return additional_information;
    }
    public void setPerson(PesronModel person)
    {
        this.person=person;
    }
    public PesronModel getPerson() {
        return person;
    }

    public void setOrg(boolean org) {
        IsOrg = org;
    }

    public boolean isOrg() {
        return IsOrg;
    }
}
