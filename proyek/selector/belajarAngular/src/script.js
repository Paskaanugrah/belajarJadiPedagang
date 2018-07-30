var myApp = angular.module('myApp', ['selector']);

myApp.controller('showData', function($scope, $http,$location) {
	$http({
		headers : {
			'Authorization' : 'Basic cmVzdDpyZXN0',
		},
		method : 'GET',
		datatype : 'json',
		url : 'http://localhost:8080/tenancy-management/api/CP/list',
		
	}).then(function mySuccess(response) {
		$scope.datas = response.data.data;

		$scope.myRecipients = [];
		console.log('data di sini ' + $scope.datas[0].id);
		
		var tmp = [];
		var i;
		for(i=0; i<$scope.datas.length; i++){
			tmp[i] = { value: $scope.datas[i].id, label: $scope.datas[i].cpName};
			console.log('------' + tmp[i].value + " & " + tmp[i].label);
		}
		$scope.recipients = tmp;
	
	}, function myError(reason) {
		$scope.datas = reason.statusText;
	});
});