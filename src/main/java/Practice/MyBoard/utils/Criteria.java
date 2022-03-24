package Practice.MyBoard.utils;

import lombok.ToString;

//int page : 현재 페이지 번호
//int perPageNum : 한 페이지당 보여줄 게시글의 갯수
//int getPageStart() : 특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호
@ToString
public class Criteria {
    //현재 페이지 번호
    private int page;
    //한 페이지당 보여줄 게시글의 개수
    private int perPageNum;
    private String option;
    private String searchValue;

    //특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호, query 에 #{start}에 들어감
   public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    public Criteria() {
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if (pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
