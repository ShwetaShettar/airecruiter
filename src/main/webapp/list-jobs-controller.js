var app = angular.module('app', []);
app.controller('listJobsController', ['$scope', '$http' ,function($scope,$http) {
	$http.get("services/jobs").then(function(response){
		$scope.jobs = response.data;
	});
}]);