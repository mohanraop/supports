<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS Application</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="FileController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">File Management</span>
               		<div class="row">
                          <div class="form-actions floatRight">
                             <b> <a href="/FileCompare">User Management</a> &nbsp &nbsp &nbsp&nbsp<a href="/FileCompare/fm">File Management</a> </b>
                          </div>
                      </div>
              </div>
              
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.fileDetail.fileDesc" />
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Files </label>
                              <div class="col-md-7">
                              <select
           							 ng-model="ctrl.fileDetail.fileDesc"
            						ng-options="fileDetail.fileDesc as fileDetail.fileDesc for fileDetail in ctrl.fileDetails"></select>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.fileDesc.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="panel panel-default">
	              		  <div class="panel-heading"><span class="lead">Drop Locations</span></div>
	                      <div class="row">
	                      <br>
	                          <div class="form-group col-md-12">
	                              <label class="col-md-2 control-lable" for="file"> &nbsp &nbsp &nbsp Location 1: </label>
	                              <div class="col-md-7">
	                                  <input type="text" ng-model="ctrl.fileDetail.dropLoc1" name="dropLoc1" class="dropLoc1 form-control input-sm" placeholder="Enter the path where it need to be dropped" required ng-minlength="3"/>
	                                  <div class="has-error" ng-show="myForm.$dirty">
	                                      <span ng-show="myForm.dropLoc1.$error.required">This is a required field</span>
	                                      <span ng-show="myForm.dropLoc1.$error.minlength">Minimum length required is 3</span>
	                                      <span ng-show="myForm.dropLoc1.$invalid">This field is invalid </span>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
	                      <div class="row">
	                          <div class="form-group col-md-12">
	                              <label class="col-md-2 control-lable" for="file"> &nbsp &nbsp &nbsp Location 2: </label>
	                              <div class="col-md-7">
	                                  <input type="text" ng-model="ctrl.fileDetail.dropLoc2" name="dropLoc2" class="dropLoc2 form-control input-sm" placeholder="Enter the path where it need to be dropped" required ng-minlength="3"/>
	                                  <div class="has-error" ng-show="myForm.$dirty">
	                                      <span ng-show="myForm.dropLoc2.$error.required">This is a required field</span>
	                                      <span ng-show="myForm.dropLoc2.$error.minlength">Minimum length required is 3</span>
	                                      <span ng-show="myForm.dropLoc2.$invalid">This field is invalid </span>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
                      </div>
					  <div class="panel panel-default">
	              		  <div class="panel-heading"><span class="lead">Pickup Locations</span></div>
	                      <div class="row">
	                      <br>
	                          <div class="form-group col-md-12">
	                              <label class="col-md-2 control-lable" for="file"> &nbsp &nbsp &nbsp Location 1: </label>
	                              <div class="col-md-7">
	                                  <input type="text" ng-model="ctrl.fileDetail.pickLoc1" name="pickLoc1" class="pickLoc1 form-control input-sm" placeholder="Enter the path where it need to be pickup" required ng-minlength="3"/>
	                                  <div class="has-error" ng-show="myForm.$dirty">
	                                      <span ng-show="myForm.pickLoc1.$error.required">This is a required field</span>
	                                      <span ng-show="myForm.pickLoc1.$error.minlength">Minimum length required is 3</span>
	                                      <span ng-show="myForm.pickLoc1.$invalid">This field is invalid </span>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
	                      <div class="row">
	                          <div class="form-group col-md-12">
	                              <label class="col-md-2 control-lable" for="file"> &nbsp &nbsp &nbsp Location 2: </label>
	                              <div class="col-md-7">
	                                  <input type="text" ng-model="ctrl.fileDetail.pickLoc2" name="pickLoc2" class="pickLoc2 form-control input-sm" placeholder="Enter the path where it need to be pickup" required ng-minlength="3"/>
	                                  <div class="has-error" ng-show="myForm.$dirty">
	                                      <span ng-show="myForm.pickLoc2.$error.required">This is a required field</span>
	                                      <span ng-show="myForm.pickLoc2.$error.minlength">Minimum length required is 3</span>
	                                      <span ng-show="myForm.pickLoc2.$invalid">This field is invalid </span>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Process" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/file_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/file_controller.js' />"></script>
  </body>
</html>