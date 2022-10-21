package member;

public class Member {
//    private String uId;
    private String uPw;
    private String uEmail;

    public Member() {
    }

    public Member(String uPw, String uEmail) {
        this.uPw = uPw;
        this.uEmail = uEmail;
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
                "uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}