(function(module) {
	var controller = function($scope, EventService, $routeParams) {
		var self = this;

		self.event = {
			id : 1,
			name : '',
			date : null,
			time : '',
			price : '',
			imageUrl : '',
			location : {
				address : '',
				city : '',
				country : ''
			},
			onlineUrl : '',
			eventSessions : []
		}
		fetchUser($routeParams.id);
		function fetchUser(id) {
			EventService.getAnEvent(id).then(function(data) {
				self.event = data;
			}, function(err) {
				console.error(err);
			})
		}
	}

	module.controller('EventDetailsController', controller)
}(angular.module('myApp')))