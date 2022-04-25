<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>아이하루 어린이집</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/bootstrap2/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/bootstrap2/css/styles.css" rel="stylesheet" />
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  		<script>
$(document).ready(function(){
  $(".nav-tabs a").click(function(){
    $(this).tab('show');
  });
});
</script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
    </head>
<body>

<!-- tab -->
<div class="container mt-3">
  <h2>Dynamic Tabs</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" href="#home">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#menu1">Menu 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#menu2">Menu 2</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="container tab-pane fade"><br>
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="container">
  <h2>Modal Example</h2>
  <!-- Button to Open the Modal -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Open modal
  </button>

  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          Modal body..
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
</div>


<!-- 3 -->
<div class="container">
  <h2>Toggleable Pills</h2>
  <br>
  <!-- Nav pills -->
  <ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="pill" href="#home">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#menu1">Menu 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#menu2">Menu 2</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="container tab-pane fade"><br>
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
  </div>
</div>


<div class="container mt-3">
  <h2>Modal Example</h2>
  <p>The modal "fades in" with the .fade class. Remove this class to remove the animation.</p>
  
  <!-- Button to Open the Modal -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Open modal
  </button>

  <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          Modal body..
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
</div>

<div class="container mt-3">
  <h2>Filterable Table</h2>
  <p>Type something in the input field to search the table for first names, last names or emails:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@mail.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@greatstuff.com</td>
      </tr>
      <tr>
        <td>Anja</td>
        <td>Ravendale</td>
        <td>a_r@test.com</td>
      </tr>
    </tbody>
  </table>
  
  <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>


                        <form>
                        	<table class="table table-dark" border="1" cellpadding="5" cellspacing="10" >
                        		<tr>
                        			<td width="30%" align="center" style="vertical-align:middle;">희망 학급</td>
                        			<td width="70%" style="vertical-align:middle;">	
                        				
			                        	<div class="form-row" align="center">
										  <!-- Nav pills -->
										  <ul class="nav nav-pills" role="tablist">
										    <li class="nav-item">
										      <a class="nav-link active" data-toggle="pill" href="#class1">햇님반</a>
										    </li>
										    <li class="nav-item">
										      <a class="nav-link" data-toggle="pill" href="#class2">달님반</a>
										    </li>
										    <li class="nav-item">
										      <a class="nav-link" data-toggle="pill" href="#class3">별빛반</a>
										    </li>
										  </ul>
										
										  <!-- Tab panes -->
										  <div class="tab-content">
										    <div id="class1" class="container tab-pane active">
										    	<input type="hidden" name="myclass" value="">
										    </div>
										    <div id="class2" class="container tab-pane fade">
										   		 <input type="hidden" name="myclass" value="">
										    </div>
										    <div id="class3" class="container tab-pane fade">
										    	<input type="hidden" name="myclass" value="">
										    </div>
										  </div>
			                        	</div>
			                        </td>
                        		</tr>
                        		
		                        <tr>
                        			<td width="30%" style="vertical-align:middle;">원생이름</td>
                        			<td width="40%">
                        				<input type="text" name="stname" class="form-control">
                        			</td>
                        		</tr>
                        		 <tr>
                        			<td width="30%" style="vertical-align:middle;">보호자명</td>
                        			<td width="40%">
                        				<input type="text" name="pname" class="form-control">
                        			</td>
                        		</tr>
                        		 <tr>
                        			<td width="30%" style="vertical-align:middle;">휴대폰번호</td>
                        			<td width="40%">
                        				<div class="form-row">
                        					<div class="col-3">
	                        					<input type="text" name="hp1" class="form-control">
	                        				</div>
	                        				<div class="col-1">
	                        					<label for="hp1" class="form-control-label">-</label>
	                        				</div>
	                        				<div class="col-3">
	                        					<input type="text" name="hp2" class="form-control">
	                        				</div>
	                        				<div class="col-1">
	                        					<label for="hp2" class="form-control-label">-</label>
	                        				</div>
	                        				<div class="col-3">
	                        					<input type="text" name="hp3" class="form-control">
	                        				</div>
                        				</div>
                        			</td>
                        		</tr>
                        		 <tr>
                        			<td width="30%" style="vertical-align:middle;">상담예약일자</td>
                        			<td width="40%">
                       					<input type="date"class="form-control">
                        			</td>
                        		</tr>
                        		 <tr>
                        			<td width="30%" style="vertical-align:middle;">문의 내용</td>
                        			<td width="40%">
                        				<textarea style="resize: none;" class="form-control" name="textarea" cols="100%" rows="10" id="textarea"></textarea>
                        			</td>
                        		</tr>
                        		<tr>
                        			<td colspan="2">
                        				<input type="submit" class="form-control" value="문의 등록">
                        			</td>
                        		</tr>
                        	</table>
                        </form>
                        
<ul class="pagination"><li class="active page-link page-item "><a><font color='red'><b>1</b></font></a></li><li class="page-link page-item "><a href="/kids/Kids?command=reList&pageNumber=2&year=2021&month=05&order=desc&keyword=all">2</a></li></ul>


<div class="container">
  <h2>Accordion Example</h2>
  <p><strong>Note:</strong> The <strong>data-parent</strong> attribute makes sure that all collapsible elements under the specified parent will be closed when one of the collapsible item is shown.</p>
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          Collapsible Group Item #1
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-parent="#accordion">
        <div class="card-body">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
        Collapsible Group Item #2
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-parent="#accordion">
        <div class="card-body">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
          Collapsible Group Item #3
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
      </div>
    </div>
    
  </div>
</div>
    

</body>
</html>