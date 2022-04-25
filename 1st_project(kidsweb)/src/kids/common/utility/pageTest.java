package kids.common.utility ;

public class pageTest {
	public static void main(String[] args) {
		String _pageNumber = "2" ;
		int totalCount = 250 ;
		String url = "/sales/salList.jsp" ;
		String mode = "all" ; // 검색 모드
		String keyword = "" ; // 검색 키워드 
		
		Paging pageInfo = new Paging(_pageNumber, totalCount, url, mode, keyword) ;
		
	}
}