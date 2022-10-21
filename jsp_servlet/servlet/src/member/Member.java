package member;

public class Member {
    private String uId;
    private String uPw;
    private String uEmail;

    public Member() {
    }

    public Member(String uId, String uPw, String uEmail) {
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

    public String getuPw() {
        return uPw;
    }

    public void setuPw(String uPw) {
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
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}