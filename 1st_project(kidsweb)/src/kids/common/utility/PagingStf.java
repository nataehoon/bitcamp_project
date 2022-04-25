package kids.common.utility;

public class PagingStf extends Paging {
	private String month;
	private String paid;
	private String class_name;
	
	
	public PagingStf(String _pageNumber, int totalCount, String url,
			String month, String paid, String class_name, int pageSize) {
		super(_pageNumber, totalCount, url,
			 null, null); 
		
		this.month = month ;
		this.paid = paid ;
		this.class_name = class_name ;
		System.out.println(month +"/"+ paid+"/"+class_name);
		// 계산이 필요한 나머지 변수들		
		
		// pagingHtml 변수는 코딩량이 길어서 별도의 메소드로 처리합니다.
		super.setPagingHtml(this.getPagingHtml(super.getUrl()));
		super.setPagingStatus("총 " + super.getTotalCount() + "건[" + super.getPageNumber() + "/" + super.getTotalPage() + "]" );
		
		 this.Display();
	}
	
	private String getPagingHtml(String url) {
		String result = "" ;
		
		// 필드 검색을 위한 변수
		String field_search = "&month=" + this.month + "&paid=" + this.paid + "&class_name=" + this.class_name ;
		
		// href_attr는 <a> 태그의 href 속성에 들어갈 값
		String href_attr = url + "&pageNumber=" + 100 + field_search ; 
		
		result += "<ul class=\"pagination\">" ;
		// part 맨처음, 이전 
		if (super.getPageNumber() <= super.getPageCount()) {
			System.out.println("맨처음과 이전이 없습니다."); 
		} else {
			result += "<li><a href=\"" + url + "&pageNumber=" + 1 + field_search + "\">" + "맨처음" + "</a></li>";			
			result += "<li><a href=\"" + url + "&pageNumber=" + (super.getBeginPage()-1) + field_search + "\">" + "이전" + "</a></li>";
		}		
		// part 중간(beginPage부터 endPage까지)
		for (int i = super.getBeginPage(); i <= super.getEndPage(); i++) {
			if (i == super.getPageNumber()) { // 현재 페이지이면				
				result += "<li class=\"active\"><a><font color='red'><b>" + i + "</b></font></a></li>";
			} else {
				result += "<li><a href=\"" + url + "&pageNumber=" + i + field_search + "\">" + i + "</a></li>";
			}
		}		
		// part 다음, 끝
		if (super.getPageNumber() >= (super.getTotalPage() / super.getPageCount() * super.getPageCount() + 1 )) {
			System.out.println("맨끝과 다음이 없습니다."); 
		} else {
			result += "<li><a href=\"" + url + "&pageNumber=" + (super.getEndPage()+1) + field_search + "\">" + "다음" + "</a></li>";
			result += "<li><a href=\"" + url + "&pageNumber=" + super.getTotalPage() + field_search + "\">" + "맨끝" + "</a></li>";
		}
		result += "</ul>" ;
		return result ;
	}


	private void Display() {
		System.out.println("totalCount : " + super.getTotalCount());
		System.out.println("totalPage : " + super.getTotalPage());
		System.out.println("pageNumber : " + super.getPageNumber());
		System.out.println("pageSize : " + super.getPageSize());
		System.out.println("beginRow : " + super.getBeginRow());
		System.out.println("endRow : " + super.getEndRow());
		System.out.println("pageCount : " + super.getPageCount());
		System.out.println("beginPage : " + super.getBeginPage());
		System.out.println("endPage : " + super.getEndPage());
		System.out.println("url : " + super.getUrl());
		System.out.println("pagingHtml : " + super.getPagingHtml());
		System.out.println("pagingStauts : " + super.getPagingStatus());
		System.out.println("month : " + month);
		System.out.println("paid : " + paid);
		System.out.println("class_name : " + class_name);
	}
	
	
}
