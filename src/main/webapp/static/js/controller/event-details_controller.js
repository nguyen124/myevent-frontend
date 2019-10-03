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
		self.session = {

		}
		self.addMode = false;

		fetchUser($routeParams.id);

		function fetchUser(id) {
			EventService.getAnEvent(id).then(function(data) {
				self.event = data;
			}, function(err) {
				console.error(err);
			})
		}

		self.addSession = function() {
			self.addMode = true;
		}
		self.cancel = function() {
			self.addMode = false;
		}
		self.saveSession = function() {
			var eventId = $routeParams.id;
		}
	}
	module.controller('EventDetailsController', controller)
}(angular.module('myApp')))