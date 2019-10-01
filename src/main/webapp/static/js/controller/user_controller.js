'use strict';

(function(module) {
	var controller = function($scope, UserService) {
		var self = this;

		self.user = {
			id : null,
			accountHolderName : '',
			balance : '',
			dob : '',
			psCode : ''
		};
		self.users = [];
		self.submit = submit;
		self.edit = edit;
		self.remove = remove;
		self.reset = reset;
		self.actionValue = 'Add';

		fetchAllUsers();

		function fetchAllUsers() {
			UserService.fetchAllUsers().then(function(data) {
				self.users = data;
				self.error = '';
			}, function(err) {
				console.error(err);
			});
		}

		function createUser() {
			UserService.createUser(self.user).then(fetchAllUsers,
					function(errResponse) {
						self.error = 'Error while creating User';
					});
		}

		function updateUser(id) {
			UserService.updateUser(self.user).then(fetchAllUsers,
					function(errResponse) {
						console.error('Error while updating User');
					});
		}

		function deleteUser(id) {
			UserService.deleteUser(id).then(fetchAllUsers,
					function(errResponse) {
						console.error('Error while deleting User');
					});
		}

		function submit() {
			if (self.actionValue == 'Add') {
				createUser();
			} else if (self.actionValue == 'Update') {
				updateUser();
			}
			reset();
		}

		function edit(id) {
			console.log('id to be edited', id);
			for (var i = 0; i < self.users.length; i++) {
				if (self.users[i].id === id) {
					self.user = {};
					self.user = angular.copy(self.users[i]);
					self.actionValue = 'Update';
					console.log("actionValue: " + self.actionValue);
					break;
				}
			}
		}

		function remove(id) {
			console.log('id to be deleted', id);
			if (self.user.id === id) {
				reset();
			}
			deleteUser(id);
		}

		function reset() {
			self.user = {
				id : null,
				accountHolderName : '',
				balance : '',
				dob : '',
				psCode : ''
			};
			self.actionValue = 'Add';
			$scope.myForm.$setPristine();
		}
	};
	module.controller('UserController', controller);
}(angular.module('myApp')))