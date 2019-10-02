(function(module) {
	module.component('eventDetails', {
		templateUrl : 'event-details.jsp',
		bindings : {
			event : '='
		}
	})
}(anguar.module('myApp')))