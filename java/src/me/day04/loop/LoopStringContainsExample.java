package me.day04.loop;

public class LoopStringContainsExample {
    static int restorationIdx = 0;
    public static void main(String[] args) {
        String original = "helllo";
        String target = "llo";
        System.out.println(isMember(original, target));
        System.out.println(original.contains(target));
    }
    public static boolean isMember(String origin, String target) {
        if (origin == null || target == null) return false;
        if (origin.isBlank() || target.isBlank()) return false;
        if (origin.length() < target.length()) return false;

        String substring = "";
        int targetIdx = 0;
        for (int originIdx = 0; originIdx < origin.length(); originIdx++) {
            if (origin.charAt(originIdx) == target.charAt(targetIdx)) {
                saveRestorationIndex(originIdx, targetIdx);
                substring += origin.charAt(originIdx);
                targetIdx++;
            } else {
                if (canRestore()) {
                    originIdx = getRestorationIdx();
                    resetRestorationIndex();
                }
                substring = "";
                targetIdx = 0;
            }
            if (substring.equals(target)) return true;
        }
        return false;
    }

    public static int getRestorationIdx() {
        return restorationIdx;
    }

    public static void setRestorationIdx(int restorationIdx) {
        LoopStringContainsExample.restorationIdx = restorationIdx;
    }

    public static void saveRestorationIndex(int originIdx, int targetIdx) {
        if (targetIdx == 0) restorationIdx = originIdx;
    }
    public static void resetRestorationIndex() {
        restorationIdx = 0;
    }
    public static boolean canRestore() {
        return restorationIdx != 0;
    }
}
