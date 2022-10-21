package database;

import java.util.HashMap;
import java.util.Map;


public class SearchDatabase {
    private Map<String, Map> data = new HashMap<>();
    private static SearchDatabase database;

    public static SearchDatabase getInstance() {
        if (database == null) {
            database = new SearchDatabase();
            database.initialize();
        }
        return database;
    }

    private SearchDatabase() {}

    private void initialize() {
        data.put("200123", Map.of(
                "name",
                "나무위키",
                "owner",
                "namu.wiki",
                "URL",
                "https://namu.wiki/w/JSP",
                "contents",
                "자바 (Java)를 이용한 서버 사이드 스크립트 언어"));
        data.put("101234", Map.of(
                "name",
                "위키백과",
                "owner",
                "wikipedia",
                "URL",
                "https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%EC%84%9C%EB%B8%94%EB%A6%BF",
                "contents",
                "자바 서블릿 (Java Servlet)은 자바를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양을 말함"));
        data.put("101897", Map.of(
                "name",
                "나무위키",
                "owner",
                "namu.wiki",
                "URL",
                "https://namu.wiki/w/JavaScript",
                "contents",
                "Ecma International의 프로토타입 기반의 프로그래밍 언어로, 스크립트 언어에 해당함"));
        data.put("309138", Map.of(
                "name",
                "오라클",
                "owner",
                "oracle",
                "URL",
                "https://www.oracle.com/kr/java/",
                "contents",
                "Java는 세계 1위의 프로그래밍 언어이자 개발 플랫폼"));

    }

    public Map<String, Map> getData() {
        return data;
    }

    public static SearchDatabase getDatabase() {
        return database;
    }

    @Override
    public String toString() {
        return "Database{" +
                "data=" + data +
                '}';
    }
}
