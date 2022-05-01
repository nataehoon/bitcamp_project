<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var socket = null;
function connect(){
	var ws = new WebSocket("ws://localhost:8989/replyEcho");

	ws.onopen = function () {
	    console.log('Info: connection opened.');
	};

	ws.onmessage = function (event) {
	    console.log("ReceiveMessage", event.data+'\n');
	};

	ws.onclose = function (event) { 
		console.log('Info: connection closed.');
		/* setTimeout( function(){ connect(); }, 1000); // retry connection!! */
	};
	ws.onerror = function (err) { console.log('Error: ', err); };
}

$(document).ready( function() {
	
	$('#btnSend').on('click', function(evt) {
	  evt.preventDefault();
	  if (socket.readyState !== 1) return;
	
	  let msg = $('input#msg').val();
	  socket.send(msg);
	});
	
	connect();
});
</script>
</head>
<body>
<div class="container col-sm-12" >
	<div class="row">
		<div class="col-sm-4">
			<table class="table table-bordered">
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%;border:thick;margin-left:5%">신장(키)</span>
						<span style="float:right;margin-right:14%">${hbean.height}cm</span>
					</td>
					<td width="25%">
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">몸무게</span>
						<span style="float:right;margin-right:14%">${hbean.weight}kg</span>
					</td>
					<td width="25%">
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">지방량</span>
						<span style="float:right;margin-right:14%">${hbean.fat}kg</span>
					</td>
					<td width="25%">
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">근육량</span>
						<span style="float:right;margin-right:14%">${hbean.muscle}kg</span>
					</td>
					<td width="25%">
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">체지방률</span>
						<span style="float:right;margin-right:14%">${perfat1}%</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.totalco < 201}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.totalco > 200}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">HDL</span>
						<span style="float:right;margin-right:14%">${hbean.hdl}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.hdl > 39}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.hdl < 40}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">LDL</span>
						<span style="float:right;margin-right:14%">${hbean.ldl}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.ldl < 141}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.ldl > 140}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">총 콜레스테롤</span>
						<span style="float:right;margin-right:14%">${hbean.totalco}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.totalco < 201}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.totalco > 200}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">AST</span>
						<span style="float:right;margin-right:14%">${hbean.ast}IU/L</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.ast < 41}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.ast > 40}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">ALT</span>
						<span style="float:right;margin-right:14%">${hbean.alt}IU/L</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.alt < 41}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.alt > 40}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<span style="color:black;border:thick;margin-left:5%">GGT</span>
						<span style="float:right;margin-right:14%">${hbean.ggt}IU/L</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.ggt > 40}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.ggt < 40}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">BUN</span>
						<span style="float:right;margin-right:14%">${hbean.bun}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.bun > 5 || hbean.bun < 21}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.bun > 20 || hbean.bun < 6}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<span style="color:black;border:thick;margin-left:5%">CREATININE</span>
						<span style="float:right;margin-right:14%">${hbean.creatin}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.creatin > 0.80 || hbean.creatin < 1.45}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.creatin < 0.81 || hbean.creatin > 1.44}">
						<span style="float:right;color:red">위험</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">Glucose Fasting</span>
						<span style="float:right;margin-right:14%">${hbean.fbs}mg/dl</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.fbs < 100}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.fbs < 125 && hbean.fbs > 99}">
						<span style="float:right;color:red">공복혈당장애</span>
						</c:if>
						<c:if test="${hbean.fbs > 125}">
						<span style="float:right;color:red">당뇨</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">수축기 혈압</span>
						<span style="float:right;margin-right:14%">${hbean.systolic}mmHg</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.systolic < 121}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.systolic > 120 && hbean.systolic < 130}">
						<span style="float:right;color:blue">주의혈압</span>
						</c:if>
						<c:if test="${hbean.systolic > 130 && hbean.systolic < 140}">
						<span style="float:right;color:blue">고혈압 전단계</span>
						</c:if>
						<c:if test="${hbean.systolic > 139}">
						<span style="float:right;color:red">고혈압</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<span style="color:black;border:thick;margin-left:5%">이완기 혈압</span>
						<span style="float:right;margin-right:14%">${hbean.diastolic}mmHg</span>
					</td>
					<td width="25%">
						<c:if test="${hbean.diastolic < 81}">
						<span style="float:right;color:blue">정상</span>
						</c:if>
						<c:if test="${hbean.diastolic < 90 && hbean.diastolic > 80}">
						<span style="float:right;color:blue">고혈압 전단계</span>
						</c:if>
						<c:if test="${hbean.diastolic > 89}">
						<span style="float:right;color:red">고혈압</span>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-sm-4">
			<div class="card-header">
				<h5>상담 채팅창</h5>
			</div>
			<div id="messages" class="card-body" style="height:600px;">
			
		    </div>
			<div class="row card-body">
				<div class="col-sm-9">
					<input type="text" id="msg" placeholder="메세지를 입력하세요." class="form-control"/>
				</div>
				<div class="col-sm-3">
					<button id="bthSend" class="btn btn-danger">전송</button>
				</div>
			</div>
		</div>
		<c:if test="${pbean.pono != null}">
		<div class="col-sm-4">
			<table class="table table-bordered"> 
				<tr>
					<td>
						<img src="./upload/${pbean.image2}" class="img-rounded" 
										alt="전면" width="220" height="500">		
					</td>
					<td>
						<img src="./upload/${pbean.image2}" class="img-rounded" 
										alt="후면" width="220" height="500">		
					</td>
				</tr>
				<tr>
					<td>
						<img src="./upload/${pbean.image3}" class="img-rounded" 
										alt="측면(좌)" width="100" height="500">	
					</td>
					<td>
						<img src="./upload/${pbean.image4}" class="img-rounded" 
										alt="측면(우)" width="100" height="500">		
					</td>
				</tr>
			</table>
		</div>
		</c:if>
	</div>
</div>
</body>
</html>