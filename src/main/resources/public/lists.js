angular.module('shoppingListsApp', [])
	.controller('ShoppingLists', function ($http) {
		var self = this;
		var lists;

		$http.get('http://localhost:8080/shoppingLists').
		success(function (data) {
			self.lists = data;
		});
	});
