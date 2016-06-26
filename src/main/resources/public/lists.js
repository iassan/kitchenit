function ShoppingLists($scope, $http) {
	$http.get('http://localhost:8080/shoppingLists').
	success(function(data) {
		$scope.shoppingLists = data;
	});
}
