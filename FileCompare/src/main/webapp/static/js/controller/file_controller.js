'use strict';

App.controller('FileController', ['$scope', 'FileService', function($scope, FileService) {
          var self = this;
          self.fileDetail={fileDesc:'',fileResp:'',dropLoc1:'',dropLoc2:'',pickLoc1:'',pickLoc2:''};
          self.fileDetails=[];
              
          self.fetchAllFileDetails = function(){
        	  FileService.fetchAllFileDetails()
                  .then(
      					       function(d) {
      						        self.fileDetails = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching fileDetails');
            					}
      			       );
          };
           
         

         self.submitFileDetails = function(fileDetail, fileDesc){
        	 FileService.submitFileDetails(fileDetail, fileDesc)
		              .then(
				              self.fetchAllFIleDetails, 
				              function(errResponse){
					               console.error('Error while updating fileDetails.');
				              }	
                  );
          };

         

          self.fetchAllFileDetails();

          self.submit = function() {
                  console.log('Saving fileDetailsr', self.fileDetail);    
                  self.submitFileDetails(self.fileDetail);
             /* self.reset();*/
          };
              
         
          self.reset = function(){
        	  self.fileDetail={fileDesc:'',fileResp:'',dropLoc1:'',dropLoc2:'',pickLoc1:'',pickLoc2:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
