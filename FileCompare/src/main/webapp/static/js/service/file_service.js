'use strict';

App.factory('FileService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllFileDetails: function() {
					return $http.get('/FileCompare/fileDetails/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching file Details');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    
			submitFileDetails: function(fileDetail, fileDesc){
					return $http.put('/FileCompare/submitFileDetails/', fileDetail)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating fileDetails');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
