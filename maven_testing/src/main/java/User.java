import java.io.Serializable;

public class User implements Serializable {
    private int idUser;
    private String fnUser;
    private String lnUser;
    private String unUser;
    private String pwUser;

    public User(int idUser, String fnUser, String lnUser, String unUser, String pwUser) {
        this.idUser = idUser;
        this.fnUser = fnUser;
        this.lnUser = lnUser;
        this.unUser = unUser;
        this.pwUser = pwUser;
    }

    public User() {
        idUser = 0;
        fnUser = "";
        lnUser = "";
        unUser = "";
        pwUser = "";
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFnUser() {
        return fnUser;
    }

    public void setFnUser(String fnUser) {
        this.fnUser = fnUser;
    }

    public String getLnUser() {
        return lnUser;
    }

    public void setLnUser(String lnUser) {
        this.lnUser = lnUser;
    }

    public String getUnUser() {
        return unUser;
    }

    public void setUnUser(String unUser) {
        this.unUser = unUser;
    }

    public String getPwUser() {
        return pwUser;
    }

    public void setPwUser(String pwUser) {
        this.pwUser = pwUser;
    }
}
