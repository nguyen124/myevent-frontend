<div class="col-md-12">
	<h3>Create Session</h3>
	<form name="newSessionForm" ng-submit="ctrl.saveSession()">

		<div class="form-group"
			ng-class="{'error':newSessionForm.name.$invalid &&
		newSessionForm.name.$touched}">
			<label for="sessionName">Session Name:</label> <em
				ng-if="newSessionForm.name.$error.required && newSessionForm.name.$touched">Required</em>
			<input ng-model="ctrl.session.name" name="name" required
				id="sessionName" type="text" class="form-control"
				placeholder="session name..." />
		</div>
		<div class="form-group"
			ng-class="{'error':newSessionForm.presenter.$invalid && newSessionForm.presenter.$touched}">
			<label for="eventDate">Presenter:</label> <em
				ng-if="newSessionForm.presenter.$error.required && newSessionForm.presenter.$touched">Required</em>
			<input ng-model="ctrl.session.presenter" name="presenter" required
				id="presenter" type="text" class="form-control"
				placeholder="presenter..." />
		</div>
		<div class="form-group"
			ng-class="{'error':newSessionForm.duration.$invalid && newSessionForm.duration.$touched}">
			<label for="duration">Duration:</label> <em
				ng-if="newSessionForm.duration.$error.required && newSessionForm.duration.$touched">Required</em>
			<select ng-model="ctrl.session.duration" required name="duration"
				class="form-control">
				<option value="">select duration...</option>
				<option value="1">Half Hour</option>
				<option value="2">1 Hour</option>
				<option value="3">Half Day</option>
				<option value="4">Full Day</option>
			</select>
		</div>
		<div class="form-group"
			ng-class="{'error':newSessionForm.level.$invalid && newSessionForm.level.$touched}">
			<label for="level">Level:</label> <em
				ng-if="newSessionForm.level.$error.required && newSessionForm.level.$touched">Required</em>
			<select ng-model="ctrl.session.level" required name="level"
				class="form-control">
				<option value="">select level...</option>
				<option value="Beginner">Beginner</option>
				<option value="Intermediate">Intermediate</option>
				<option value="Advanced">Advanced</option>
			</select>
		</div>
		<div class="form-group"
			ng-class="{'error':newSessionForm.abstraction.$invalid && newSessionForm.abstraction.$touched}">
			<label for="abstraction">abstraction:</label>
			<div class="d-inline"
				ng-if="newSessionForm.abstraction.$invalid && newSessionForm.abstraction.$touched">
				<em ng-if="newSessionForm.abstraction.$errors.required">Required</em>
				<em ng-if="newSessionForm.abstraction.$errors.maxlength">Abstraction
					can't be more than 400 characters</em> <em
					ng-if="newSessionForm.abstraction.$errors.restrictedWords">Restricted
					words found: {{newSessionForm.abstraction.$errors.restrictedWords}}</em>
			</div>

			<textarea ng-model="ctrl.session.abstraction" name="abstraction"
				id="abstraction" rows=3 class="form-control"
				placeholder="abstraction..."></textarea>
		</div>
		<button type="submit" class="btn btn-primary" value="Submit">Save</button>
		<button type="button" class="btn btn-default" ng-click="ctrl.cancel()">Cancel</button>

	</form>
</div>
