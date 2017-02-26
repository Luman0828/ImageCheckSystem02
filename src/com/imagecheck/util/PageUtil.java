package com.imagecheck.util;

public class PageUtil {
    public static Page createPage(int everyPage, int totalCount, int currentPage) {//鍒涘缓鍒嗛〉淇℃伅瀵硅薄
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        int beginIndex = getBeginIndex(everyPage, currentPage);
        boolean hasPrePage = getHasPrePage(currentPage);
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);
        return new Page(everyPage, totalCount, totalPage, currentPage,
                beginIndex, hasPrePage, hasNextPage);
    }

    private static int getEveryPage(int everyPage) {        //鑾峰緱姣忛〉鏄剧ず璁板綍鏁�
        return everyPage == 0 ? 10 : everyPage;
    }

    private static int getCurrentPage(int currentPage) {    //鑾峰緱褰撳墠椤�
        return currentPage == 0 ? 1 : currentPage;
    }

    private static int getTotalPage(int everyPage, int totalCount) {//鑾峰緱鎬婚〉鏁�
        int totalPage = 0;
        if (totalCount != 0 && totalCount % everyPage == 0) {
            totalPage = totalCount / everyPage;
        } else {
            totalPage = totalCount / everyPage + 1;
        }
        return totalPage;
    }

    private static int getBeginIndex(int everyPage, int currentPage) {//鑾峰緱璧峰浣嶇疆
        return (currentPage - 1) * everyPage;
    }

    private static boolean getHasPrePage(int currentPage) {//鑾峰緱鏄惁鏈変笂涓�椤�
        return currentPage != 1;
    }

    private static boolean getHasNextPage(int totalPage, int currentPage) {    //鑾峰緱鏄惁鏈変笂涓�椤�
        return !(currentPage == totalPage || totalPage == 0);
    }
}
