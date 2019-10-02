'use strict';

(function() {
	var app = angular.module('myApp', [ "ngRoute" ]);
	app.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "hello.jsp"
		}).when("/events", {
			templateUrl : "events.jsp"
		}).when("/events/create", {
			templateUrl : "create-event.jsp"
		}).when("/events/:id", {
			templateUrl : "event-details.jsp"
		}).when("/accounts", {
			templateUrl : "accounts.jsp"
		});
	});
}());