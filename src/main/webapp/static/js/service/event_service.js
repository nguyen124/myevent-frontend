'use strict';
(function(module) {
	var eventService = function($http, $q) {
		var REST_SERVICE_URI = 'http://localhost:8080/MyApp/events';
		var factory = {
			fetchAllEvents : fetchAllEvents,
			getAnEvent : getAnEvent,
			createOrUpdateEvent : createOrUpdateEvent,
			deleteEvent : deleteEvent,
			saveSession : saveSession
		}
		return factory;

		function fetchAllEvents() {
			var deferred = $q.defer();
			$http.get(REST_SERVICE_URI).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.log('Error while fetching events');
				deferred.reject(err);
			});
			return deferred.promise;
		}

		function getAnEvent(eventId) {
			var deferred = $q.defer();
			$http.get(REST_SERVICE_URI+"/"+eventId).then(function(response){
				deferred.resolve(response.data);
			}, function(err){
				console.log('Error while get an event');
				deferred.reject(err);
			})
			return deferred.promise;
		}
		
		function createOrUpdateEvent(event) {
			var deferred = $q.defer();
			$http.post(REST_SERVICE_URI, event).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.log('Error while updating event');
				deferred.reject(err);
			});
			return deferred.promise;
		}
		
		function deleteEvent(id){
			var deferred = $q.defer();
			$http.delete(REST_SERVICE_URI +id).then(function(response){
				deferred.resolve(response.data);
			}, function(err){
				console.log('Error while deleting event');
				deferred.reject(err);
			});
			return deferred.promise;
		}
		
		function saveSession(id, session){
			var deferred = $q.defer();
			$http.post(REST_SERVICE_URI + "/" +id + "/sessions", session).then(function(response){
				deferred.resolve(response.data);
			}, function(err){
				deferred.reject(err);
			});
			return deferred.promise;
		}
	}
	module.factory('EventService', eventService);
}(angular.module('myApp')));