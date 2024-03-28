package utils;

import org.json.JSONObject;

public class TestPojo {


    private int memberId;
    private int size;
    private int currentPage;

    @Override
    public String toString() {
        return "TestPojo{" +
                "memberId=" + memberId +
                ", size=" + size +
                ", currentPage=" + currentPage +
                ", keyword='" + keyword + '\'' +
                ", isApplied=" + isApplied +
                '}';
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    private String keyword;
    private boolean isApplied;


    // 3. Parametreli Constructor olusturduk
    public TestPojo(int memberId, int size, int currentPage, String keyword, boolean isApplied) {
        this.memberId = memberId;
        this.size = size;
        this.currentPage = currentPage;
        this.keyword = keyword;
        this.isApplied = isApplied;

    }

    public TestPojo() {
    }


}








