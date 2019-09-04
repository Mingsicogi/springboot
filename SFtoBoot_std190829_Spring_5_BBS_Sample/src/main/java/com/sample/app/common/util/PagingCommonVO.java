package com.sample.app.common.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingCommonVO {

	
	/** 검색조건. 0=제목, 1=내용 2=id*/
    private int cond;    
    
    /** 쿼리에 보낼 검색조건 문자열  */
    private String condquery = "";
    
    /** 검색어 */
    private String keyword;
    
    /** 현재페이지 */
    private int pageNum = 1;
    
    /** 페이지에 보여줄 데이터 갯수 */
    private int recordCountPerPage = 10;
        
    /** 현재 페이지의 시작 seq     */
    private int startSeq = 1;
    
    /** 현재 페이지의 끝 seq */
    private int endSeq = 10;
        
    /**총 페이지 수 */
    private int totalPage = 1;
 
    /** 현재 페이지 네비게이션 사이즈 */
    private int pageNavSize = 5;
    
    /** 최대 페이지 네비게이션 사이즈 */
    private int maxNavSize = 10;
 
    /** 페이지 네비게이션 첫 인덱스 */
    private int firstNavIndex = 1;
 
    /** 페이지 네비게이션 마지막 인덱스 */
    private int lastNavIndex = 1;  
    
    /**No args constructor
     * 
     */
    @Builder
    public PagingCommonVO() {
    	int totalSize = 15;
    	this.pageNum = 1;
    	this.setRecordCountPerPage(10);
        this.startSeq = ( ( pageNum - 1 ) * this.getRecordCountPerPage() ) + 1;
        this.endSeq = startSeq + this.getRecordCountPerPage() - 1;
        //페이지 네비게이션의 최대 사이즈
        this.maxNavSize = (totalSize % recordCountPerPage == 0) ? (totalSize / recordCountPerPage) : (totalSize / recordCountPerPage) + 1;
        this.setNav(totalSize);
    }
    
    /**현재 페이지 번호와 총 게시글의 수를 매개변수로 받아서 페이징 객체 생성
     * @param pageNum
     * @param totalSize
     */
    @Builder
    public PagingCommonVO(int pageNum, int totalSize) {
        super();
        this.pageNum = pageNum;
        this.setRecordCountPerPage(10);
        this.startSeq = ( ( pageNum - 1 ) * this.getRecordCountPerPage() ) + 1;
        this.endSeq = startSeq + this.getRecordCountPerPage() - 1;
        //페이지 네비게이션의 최대 사이즈
        this.maxNavSize = (totalSize % recordCountPerPage == 0) ? (totalSize / recordCountPerPage) : (totalSize / recordCountPerPage) + 1;
        this.setNav(totalSize);
    }
    
    /** All Args Constructor
     * @param pageIndex
     * @param recordCountPerPage
     * @param startSeq
     * @param endSeq
     * @param totalPage
     * @param pageSize
     * @param firstNavIndex
     * @param lastNavIndex
     */
    @Builder
    public PagingCommonVO(int pageNum, int recordCountPerPage, int startSeq, int endSeq, int totalPage, int pageSize,
            int firstNavIndex, int lastNavIndex) {
        super();
        this.pageNum = pageNum;
        this.recordCountPerPage = recordCountPerPage;
        this.startSeq = startSeq;
        this.endSeq = endSeq;
        this.totalPage = totalPage;
        this.pageNavSize = pageSize;
        this.firstNavIndex = firstNavIndex;
        this.lastNavIndex = lastNavIndex;
    }
    
    /**네비게이션 바 설정
     * 12345 : 1 ~ 5
     * 678910 : 6 ~ 10
     * (7/5)*5 +1
     * (3/5)*5 +1
     */
    public void setNav(int totalSize) {
        //페이지 네비게이션의 최대 사이즈
        this.maxNavSize = (totalSize % recordCountPerPage == 0) ? (totalSize / recordCountPerPage) : (totalSize / recordCountPerPage) + 1;
        this.firstNavIndex = (this.pageNum / pageNavSize) * pageNavSize + 1;
        //마지막 네비게이션 바 인덱스. 전체 글 수가 한 페이지 당 글 수로 나누어 떨어지면 -0 아니면 -1
        int temp = this.firstNavIndex + pageNavSize - 1 ;
        this.lastNavIndex = (temp > maxNavSize) ? maxNavSize : temp ;
        //System.out.println("totalSize : " + totalSize + " , recordCountPerPage : " + recordCountPerPage + " , temp : " + temp + " , ddd " +  (( (totalSize % recordCountPerPage) == 0 )?3:2 ) );
        //System.out.println("firstNavIndex : " + firstNavIndex + " , lastNavIndex : " + lastNavIndex + " , maxNavSize : " + maxNavSize);
    }
	
}
