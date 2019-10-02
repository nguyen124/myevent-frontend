'use strict';

(function() {
	var app = angular.module('myApp', [ "ngRoute" ]);
	app.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "hello.jsp"
		}).when("/events/:id", {
			templateUrl : "event-details.jsp"
		}).when("/account", {
			templateUrl : "account.jsp"
		});
	});
}());