<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <!-- Custom fonts for this template-->
    <link href="resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- <link href="./../bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"> -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	    <!-- Bootstrap core JavaScript-->
    <script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/bootstrap/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="resources/bootstrap/vendor/chart.js/Chart.min.js"></script>

     <!-- Page level custom scripts -->
    <script src="resources/bootstrap/js/demo/chart-area-demo.js"></script>
    <script src="resources/bootstrap/js/demo/chart-pie-demo.js"></script>
<script>

var sock = new SockJS("http://localhost:8989/replyEcho");

sock.onopen = function () {
    console.log('Info: connection opened.');
};

sock.onmessage = function (event) {
    console.log("ReceiveMessage", event.data+'\n');
};

sock.onclose = function (event) { 
	console.log('Info: connection closed.');
	/* setTimeout( function(){ connect(); }, 1000); // retry connection!! */
};
sock.onerror = function (err) { console.log('Error: ', err); };

var socket = null;

function connect(){

	
	
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
	<div class="card-header" align="center">
		<h3 style="color:red">상담 채팅창</h3>
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
</body>
</html>