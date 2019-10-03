<h1>New Event</h1>
<hr>
<div class="col-md-6" ng-controller="EventController as ctrl">
	<form name="newEventForm" ng-submit="ctrl.saveEvent()"
		autocomplete="on" novalidate>
		<div class="form-group"
			ng-class="{'error': (newEventForm.name.$invalid && newEventForm.name.$touched)}">
			<label for="eventName">Event Name:</label> <em
				ng-if="newEventForm.name.$error.required && newEventForm.name.$touched">Required</em>
			<input ng-model="ctrl.event.name" name="name" required id="name"
				type="text" class="form-control" placeholder="Name of your event..." />
		</div>
		<div class="form-group"
			ng-class="{'error': newEventForm.date.$invalid && newEventForm.date.$touched}">
			<label for="eventDate">Event Date:</label> <em
				ng-if="newEventForm.date.$error.required && newEventForm.date.$touched">Required</em>
			<input ng-model="ctrl.event.date" name="date" required id="eventDate"
				type="text" class="form-control"
				placeholder="format (mm/dd/yyyy)..." />
		</div>
		<div class="form-group"
			ng-class="{'error': newEventForm.time.$invalid && newEventForm.time.$touched}">
			<label for="eventTime">Event Time:</label> <em
				ng-if="newEventForm.time.$error.required && newEventForm.time.$touched">Required</em>
			<input ng-model="ctrl.event.time" name="time" required id="eventTime"
				type="text" class="form-control" placeholder="start and end time..." />
		</div>
		<div class="form-group"
			ng-class="{'error': newEventForm.price.$invalid && newEventForm.price.$touched}">
			<label for="eventPrice">Event Price:</label> <em
				ng-if="newEventForm.price.$error.required && (newEventForm.price.$touched)">Required</em>
			<input ng-model="ctrl.event.price" name="price" required
				id="eventPrice" type="text" type="number" class="form-control"
				placeholder="event price..." />
		</div>

		<div>
			<div class="form-group">
				<label for="address">Event Location:</label> <input
					ng-model="ctrl.event.location.address" name="address" id="address"
					type="text" class="form-control" placeholder="Address of event..." />
			</div>
			<div class="row">
				<div class="col-md-6">
					<input ng-model="ctrl.event.location.city" name="city" id="city"
						type="text" class="form-control" placeholder="City..." />
				</div>
				<div class="col-md-6">
					<input ng-model="ctrl.event.location.country" name="country"
						id="country" type="text" class="form-control"
						placeholder="Country..." />
				</div>
			</div>
		</div>


		<div class="form-group">
			<label for="onlineUrl">Online Url:</label> <input
				ng-model="ctrl.event.onlineUrl" name="onlineUrl" id="onlineUrl"
				type="text" class="form-control" placeholder="Online Url..." />
		</div>
		<div class="form-group"
			ng-class="{'error': newEventForm.imageUrl.$invalid && newEventForm.imageUrl.$touched}">
			<label for="imageUrl">Image:</label> <em
				ng-if="newEventForm.imageUrl.$error.required && newEventForm.imageUrl.$touched && newEventForm.imageUrl.errors.required">Required</em>
			<em
				ng-if="newEventForm.imageUrl.$invalid && newEventForm.imageUrl.$touched  && newEventForm.imageUrl.errors.pattern">Must
				be a png or jpg url</em> <input ng-model="ctrl.event.imageUrl"
				name="imageUrl" required pattern=".*\/.*.(png|jpg)" id="imageUrl"
				type="text" class="form-control" placeholder="url of image..."></input>
			<img src="{{ctrl.event.imageUrl}}" /> <img />
		</div>

		<button type="submit" class="btn btn-primary" value="Submit">Save</button>
		<button type="button" class="btn btn-default" ng-click="cancel()">Cancel</button>
	</form>

</div>