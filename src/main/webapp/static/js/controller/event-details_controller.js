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

		function fetchAllSessions() {

		}

		self.addSession = function() {
			self.session = {};
			self.addMode = true;
		}
		self.cancel = function() {
			self.addMode = false;
			self.session = {};
		}
		self.saveSession = function() {
			var eventId = $routeParams.id;
			self.event.eventSessions.push(self.session);
			EventService.saveSession(eventId, self.session).then(
					fetchAllSessions, function(err) {
						console.error('Error while adding session');
					})

			self.addMode = false;
		}
	}
	module.controller('EventDetailsController', controller)
}(angular.module('myApp')))