package kids.common.utility ;

public class PagingRes{
	private int totalCount = 0 ; // 총 행(레코드)수
	private int totalPage = 0 ; // 전체 페이지 수
	
	private int pageNumber = 0 ; // 현재 페이지 번호
	private int pageSize = 10 ; // 한 페이지에 보여줄 건수
	private int beginRow = 0 ; // 현재 페이지의 시작 행(랭킹)
	private int endRow = 0 ; // 현재 페이지의 끝 행(랭킹)
	
	private int pageCount = 10 ; // 하단에 보여줄 페이지 링크 수
	private int beginPage = 0 ; // 페이징 처리 시작 페이지 번호
	private int endPage = 0 ; // 페이징 처리 끝 페이지 번호
	
	private String url = "" ; // 유알엘
	private String pagingHtml = "" ; // 하단의 숫자 페이지 링크(이전, 다음 링크 포함)  
	private String pagingStatus = "" ; // 상단 우측의 현재 페이지 위치 표시
	
	private String year = "";
	private String month = "";
	private String order = "";
	private String keyword = "";
	

	public PagingRes(String _pageNumber, int totalCount, String url,
			String year, String month, String order, String keyword) {
		
		if (_pageNumber==null || _pageNumber.equals("null") || _pageNumber.equals("") ) {
			_pageNumber = "1" ;
		}
		this.pageNumber = Integer.parseInt(_pageNumber) ;
		this.totalCount = totalCount ;
		this.url = url ;
		this.year = year;
		this.month = month;
		this.order = order;
		this.keyword = keyword ;
		
		// 계산이 필요한 나머지 변수들		
		this.totalPage = (int)Math.ceil((double)totalCount / pageSize) ;
		
		this.beginRow = (pageNumber - 1) * pageSize + 1 ; 
		this.endRow = pageNumber * pageSize ;
		
		this.beginPage = (pageNumber - 1) / pageCount * pageCount + 1  ;
		this.endPage = this.beginPage + pageCount - 1 ; 
		
		if(totalPage < endPage) {endPage = totalPage ; }
		
		// pagingHtml 변수는 코딩량이 길어서 별도의 메소드로 처리합니다.
		this.pagingHtml = this.getPagingHtml(url) ;
		this.pagingStatus = "총 " + totalCount + "건[" + pageNumber + "/" + totalPage + "]"  ;
		
		 this.Display();
	}
		public String getPagingHtml(String url) {
		String result = "" ;
		
		// 필드 검색을 위한 변수
		String field_search = "&year="+this.year+"&month="+this.month+"&order="+this.order+"&keyword=" + this.keyword ;
		
		// href_attr는 <a> 태그의 href 속성에 들어갈 값
		String href_attr = url + "&pageNumber=" + 100 + field_search ; 
		
		result += "<ul class=\"pagination\">" ;
		// part 맨처음, 이전 
		if (pageNumber <= pageCount) {
			System.out.println("맨처음과 이전이 없습니다."); 
		} else {
			result += "<li class=\"active page-link\"><a href=\"" + url + "&pageNumber=" + 1 + field_search + "\">" + "맨처음" + "</a></li>";			
			result += "<li class=\"active page-link\"><a href=\"" + url + "&pageNumber=" + (beginPage-1) + field_search + "\">" + "이전" + "</a></li>";
		}		
		// part 중간(beginPage부터 endPage까지)
		for (int i = beginPage; i <= endPage; i++) {
			if (i == pageNumber) { // 현재 페이지이면				
				result += "<li class=\"active page-link\"><a><font color='red'><b>" + i + "</b></font></a></li>";
			} else {
				result += "<li class=\"page-link\"><a href=\"" + url + "&pageNumber=" + i + field_search + "\">" + i + "</a></li>";
			}
		}		
		// part 다음, 끝
		if (pageNumber >= ((totalPage / pageCount * pageCount) + 1 )) {
			System.out.println("맨끝과 다음이 없습니다."); 
		} else {
			result += "<li class=\"page-link\"><a href=\"" + url + "&pageNumber=" + (endPage+1) + field_search + "\">" + "다음" + "</a></li>";
			result += "<li class=\"page-link\"><a href=\"" + url + "&pageNumber=" + totalPage + field_search + "\">" + "맨끝" + "</a></li>";
		}
		result += "</ul>" ;
		return result ;
	}

	private void Display() {
		System.out.println("totalCount : " + totalCount);
		System.out.println("totalPage : " + totalPage);
		System.out.println("pageNumber : " + pageNumber);
		System.out.println("pageSize : " + pageSize);
		System.out.println("beginRow : " + beginRow);
		System.out.println("endRow : " + endRow);
		System.out.println("pageCount : " + pageCount);
		System.out.println("beginPage : " + beginPage);
		System.out.println("endPage : " + endPage);
		System.out.println("url : " + url);
		System.out.println("pagingHtml : " + pagingHtml);
		System.out.println("pagingStauts : " + pagingStatus);
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("order : " + order);
		System.out.println("keyword : " + keyword);
	}

	public String getPagingHtml() { return pagingHtml;}
	public String getPagingStatus() { return pagingStatus;}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getKeyword() {
		return keyword;
	}

	public int getPageNumber() {return pageNumber;}
	public int getBeginRow() {return beginRow;}
	public int getEndRow() {return endRow;}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public void setPagingStatus(String pagingStatus) {
		this.pagingStatus = pagingStatus;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
//	
//	public int getTotalCount() {
//		return totalCount;
//	}
//
//	public int getTotalPage() {
//		return totalPage;
//	}
//
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public int getPageCount() {
//		return pageCount;
//	}
//
//	public int getBeginPage() {
//		return beginPage;
//	}
//
//	public int getEndPage() {
//		return endPage;
//	}
//
//	public String getUrl() {
//		return url;
//	}	
}