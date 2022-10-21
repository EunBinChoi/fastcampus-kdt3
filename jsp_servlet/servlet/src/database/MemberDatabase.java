package database;

import member.Member;

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
        data.put("a", new Member("sally","a1234", "qweqwe@naver.com"));
        data.put("b", new Member("kelly","b1234", "b1sad@gmail.com"));
        data.put("c", new Member("john","c1234", "ccasq@gmail.com"));
        data.put("d", new Member("smith","d1234", "basdya@yahoo.com"));
        data.put("e", new Member("philip","e1234", "eeadwe@gmail.com"));
    }

    public Member select(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        } else {
            return null;
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
