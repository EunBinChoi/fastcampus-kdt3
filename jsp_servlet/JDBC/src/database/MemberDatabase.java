package database;

import member.Member;
import member.Password;

import java.util.HashMap;
import java.util.Map;

public class MemberDatabase {
    private Map<String, Member> data = new HashMap<>();

    private static MemberDatabase database;

    public static MemberDatabase getInstance() {
        if (database == null) {
            database = new MemberDatabase();
            database.initialize();
        }
        return database;
    }

    private MemberDatabase() {}

    private void initialize() {
        data.put("a", new Member("a", new Password("a1234"), "qweqwe@naver.com"));
        data.put("b", new Member("b", new Password("b1234"), "b1sad@gmail.com"));
        data.put("c", new Member("c", new Password("c1234"), "ccasq@gmail.com"));
        data.put("d", new Member("d", new Password("d1234"), "basdya@yahoo.com"));
        data.put("e", new Member("e", new Password("e1234"), "eeadwe@gmail.com"));
    }

    public Member select(String uId) {
        if (data.containsKey(uId)) {
            return data.get(uId);
        } else {
            return null;
        }
    }

    public boolean insert(Member member) {
        if (!data.containsKey(member.getuId())) {
            data.put(member.getuId(), member);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Member> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MemberDatabase{" +
                "data=" + data +
                '}';
    }
}
