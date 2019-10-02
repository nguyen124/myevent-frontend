<div ng-controller="EventController as ctrl">

	<img class="ctrl.event-image" src="{{ctrl.event.imageUrl}}"
		alt="{{ctrl.event.name}}">

	<div class="row">
		<div class="col-md-11">
			<h2>{{ctrl.event.name}}</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div>
				<strong>Date:</strong> {{ctrl.event.date | date:'longDate'}}
			</div>
			<div>
				<strong>Time:</strong> {{ctrl.event.time}}
			</div>
			<div>
				<strong>Price:</strong> {{ctrl.event.price | currency : 'USD'}}
			</div>
		</div>
		<div class="col-md-6">
			<address>
				<strong>Address:</strong><br /> {{ctrl.event.location.address}}<br />
				{{ctrl.event.location.city}}, {{ctrl.event.location.country}}
			</address>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-2">
			<h3 style="margin: 0">Sessions</h3>
		</div>
		<div class="col-md-7">
			<div class="btn-group btn-group-sm" style="margin-right: 20px;">
				<button class="btn btn-default" ng-class="{active:sortBy==='name'}"
					ng-click="sortBy='name'">Name</button>
				<button class="btn btn-default" ng-class="{active:sortBy==='vote'}"
					ng-click="sortBy='vote'">Vote</button>
			</div>
			<div class="btn-group btn-group-sm">
				<button class="btn btn-default"
					ng-class="{active: filterBy==='all'}" ng-click="filterBy='all'">All</button>
				<button class="btn btn-default"
					ng-class="{active:filterBy==='beginner'}"
					ng-click="filterBy='beginner'">Beginner</button>
				<button class="btn btn-default"
					ng-class="{active:filterBy==='intermediate'}"
					ng-click="filterBy='intermediate'">Intermediate</button>
				<button class="btn btn-default"
					ng-class="{active:filterBy==='advanced'}"
					ng-click="filterBy='advanced'">Advanced</button>
			</div>
		</div>
		<div class="col-md-2">
			<a ng-click="addSession()">Add Session</a>
		</div>
	</div>

</div>