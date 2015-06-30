var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.config(function($routeProvider){
	$routeProvider.when('/', {
		templateUrl:'/home.html',
		controller:'homeCtrl'
	}).otherwise({redirectTo:'/'})
});

app.controller('homeCtrl', function($scope, $http) {
});

app.config(function($routeProvider){
	$routeProvider.when('/listAll', {
		templateUrl:'/listAll.html',
		controller:'GeekCtrl'
	})
});

app.controller('GeekCtrl', function($scope, $http) {
	$http.get('/api/geek').success(function(getGeeks) {
        $scope.getGeeks = getGeeks;
    });
});