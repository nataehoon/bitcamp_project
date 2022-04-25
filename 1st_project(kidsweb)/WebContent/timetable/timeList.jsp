<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <!-- Custom fonts for this template -->
    <link href="./../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./../css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="./../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<style>
	.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}
</style>
</head>

<body id="page-top">

   

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">오늘은 하루를 어떻게 보낼까요~</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <div class="dropdown">
							  <h6 class="m-0 font-weight-bold text-primary">어느 반</h6>
							  <div class="dropdown-content">
							  <p>1</p>
							  <p>2</p>
							  <p>3</p>
							  </div>
							</div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="2">
                                    <thead>
                                        <tr>
                                            <th>몇시에요</th>
                                            <th>무엇을 할까요</th>
                                            <th>어떤 선생님이에요</th>
                                        </tr>
                                        <tr>
                                            <th>09:00 ~ 10:00</th>
                                            <th>             </th>
                                            <th>             </th>
                                        </tr>
                                        <tr>
                                            <td>10:00 ~ 12:00</td>
                                            <td>             </td>
                                            <td>             </td>
                                        </tr>
                                        <tr>
                                            <th>13:00 ~ 14:00</th>
                                            <th>             </th>
                                            <th>             </th>
                                        </tr>
                                        <tr>
                                            <th>14:00 ~ 15:00</th>
                                            <th>             </th>
                                            <th>             </th>
                                        </tr>
                                        <tr>
                                            <td>15:00 ~ 17:00</td>
                                            <td>             </td>
                                            <td>             </td>
                                        </tr>
                                        <tr>
                                            <td>17:00 ~ 18:00</td>
                                            <td>             </td>
                                            <td>             </td>
                                        </tr>
                                     </thead>
                                     <tfoot>
                                        <tr>
                                            <th>18:00 ~ 21:00</th>
                                            <th>             </th>
                                            <th>             </th>
                                        </tr>
                                    </tfoot>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>



                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

     

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">Ã</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="./../vendor/jquery/jquery.min.js"></script>
    <script src="./../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="./../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="./../js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="./../vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="./../vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="./../js/demo/datatables-demo.js"></script>

</body>

</html>