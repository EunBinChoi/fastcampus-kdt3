package member;

public class Member {
    private String uId;
    private Password uPw;
    private String uEmail;

    public Member() {
    }


    public Member(String uId, Password uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public Member(String uId, Password uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Password getuPw() {
        return uPw;
    }

    public void setuPw(Password uPw) {
        this.uPw = uPw;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "Member{" +
                "uId='" + uId + '\'' +
                ", uPw=" + uPw +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}