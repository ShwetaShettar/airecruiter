var app = angular.module('app', []);

function getQueryVariable(variable) {
	  var query = window.location.search.substring(1);
	  var vars = query.split("&");
	  for (var i=0;i<vars.length;i++) {
	    var pair = vars[i].split("=");
	    if (pair[0] == variable) {
	      return pair[1];
	    }
	  } 
	}

app.controller('jobController', ['$scope', '$http',function($scope,$http) {
	var id = getQueryVariable("id");
	$http.get("services/jobs/"+id).then(function(response){
		$scope.job = response.data;
	});
}]);