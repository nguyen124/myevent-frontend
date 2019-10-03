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
		<button class="btn btn-default" ng-class="{active: filterBy==='all'}"
			ng-click="filterBy='all'">All</button>
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
	<button class="btn btn-primary" ng-click="ctrl.addSession()">
		Add Session</button>
</div>


<div class="row" ng-if="ctrl.event.eventSessions"
	ng-repeat="session in ctrl.event.eventSessions">
	<div class="col-md-10">
		<div class="well">{{session.name}}</div>
		<div>
			<h6>{{session.presenter}}</h6>
			<span>Duration: {{session.duration}}</span><br /> <span>Level:
				{{session.level}}</span>
			<p>Abstraction: {{session.abstraction}}</p>
		</div>
	</div>
</div>