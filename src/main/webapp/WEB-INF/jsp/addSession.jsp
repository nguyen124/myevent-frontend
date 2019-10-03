<div class="col-md-12">
	<h3>Create Session</h3>
	<ng-form name="newSessionForm" ng-submit="ctrl.saveSession()"
		autocomplete="on" novalidate>

	<div class="form-group"
		ng-class="{'error':newSessionForm.name.$invalid &&
		newSessionForm.name.$touched}">
		<label for="sessionName">Session Name:</label> <em
			ng-if="newSessionForm.name.$error.required && newSessionForm.name.$touched">Required</em>
		<input ng-model="ctrl.session.name" formControlName="name"
			id="sessionName" type="text" class="form-control"
			placeholder="session name..." />
	</div>


	</ng-form>
</div>

<div class="row">form detail: {{newSessionForm}}</div>

<div>form details: {{newSessionForm.name}}</div>

<div>model: {{ctrl.session}}</div>