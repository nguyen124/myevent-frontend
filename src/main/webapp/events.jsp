<div ng-controller="EventController as ctrl">
	<div ng-repeat="event in ctrl.events">
		<div class="well hoverwell thumbnail">
			<img class="thumbnail-image" src="{{event.imageUrl}}"
				alt="event.name">

			<div class="row">
				<div class="col-md-11">
					<h2>
						<a href="#!events/{{event.id}}"> {{event.name}} </a>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div>
						<strong>Date:</strong> {{event.date | date:'longDate'}}
					</div>

					<div>
						<strong>Price:</strong> {{event.price | currency:"USD$"}}
					</div>
				</div>
				<div class="col-md-6">
					<address>
						<strong>Address:</strong><br /> {{event.location.address}}<br />
						{{event.location.city}}, {{event.location.country}}
					</address>
				</div>
			</div>
		</div>
	</div>
</div>