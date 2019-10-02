'use strict';

(function(module) {
	var controller = function($scope, EventService) {
		var self = this;

		self.event = {
			id : null,
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
		self.events = [];

		fetchAllEvents();

		function fetchAllEvents() {
			EventService.fetchAllEvents().then(function(data) {
				self.events = data;
				self.error = '';
			}, function(err) {
				console.error(err);
			})
		}

		function createEvent() {
			EventService.createEvent(self.event).then(fetchAllEvents,
					function(errResponse) {
						console.log('Error while creating Event');
					});
		}

		function deleteEvent(id) {
			EventService.deleteEvent(id).then(fetchAllEvents,
					function(errResponse) {
						console.error('Error while deleting Event');
					});
		}
	};
	module.controller('EventController', controller);
}(angular.module('myApp')));