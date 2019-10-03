<div ng-controller="EventDetailsController as ctrl">

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

	<div ng-if="!ctrl.addMode" class="row">
		<%@ include file="WEB-INF/jsp/sortAndFilter.jsp"%>
	</div>

	<div ng-if="ctrl.addMode" class="row">
		<%@ include file="WEB-INF/jsp/addSession.jsp"%>
	</div>
</div>