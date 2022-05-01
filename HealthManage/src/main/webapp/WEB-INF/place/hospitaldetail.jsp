<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1af4cb9e7ebf270f4eb2a68ba8dd54e0&libraries=services"></script>
<script> 
$(document).ready(function(){
    
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};
	//주소 생성
	var map = new kakao.maps.Map(container, options);
	
	var geocoder = new daum.maps.services.Geocoder();
	
	var meaddress = document.myform.address.value;
	myMarker(meaddress);
	
	function myMarker(address){
		geocoder.addressSearch(address, function(result, status){
			if(status === daum.maps.services.Status.OK){
				var coords = new daum.maps.LatLng(
						result[0].y, result[0].x);
				
				var content = '<div class="customoverlay">'
					+'	<span class="title">'
					+'<div class="fas fa-fw fa-map-marker-alt" style="font-style:normal; color:black; font-size:2.0em">'
					+ '</div>' + '</span>'
					+ '</div>';
				
				var position = new daum.maps.LatLng(
						result[0].y, result[0].x);
				
				var customOverlay = new daum.maps.CustomOverlay(
						{
							map:map,
							position:position,
							content:content,
							yAnchor:1
						});
				map.setCenter(coords);
			}
		});
	}
});
</script>
<style> 
#panel, #flip {
  padding: 5px;
  text-align: center;
  background-color: #e5eecc;
  border: solid 1px #c3c3c3;
}

#panel {
  padding: 50px;
  display: none;
}
</style>
</head>
<body>
<div class="container col-sm-12">
	<form id="myform" name="myform">
		<div class="row">
			<div class="col-sm-6">
				<input type="hidden" id="address" name="address" value="${bean.address}">
				<div id="map" style="width:800px;height:800px;"></div>
			</div>
			<div class="col-sm-6">
				<div class="card-header" align="center">
					<h3>${bean.name}</h3>
				</div>
				<div class="card-body" align="left">
					<h5>${bean.address}</h5>
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>
