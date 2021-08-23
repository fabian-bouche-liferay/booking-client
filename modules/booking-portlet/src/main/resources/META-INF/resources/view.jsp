<%@ include file="/init.jsp" %>

<h1>Bookings</h1>

<iframe src="${listBookingsAsyncResourceURL}"></iframe>

<portlet:actionURL name="initBooking" var="initBookingActionURL" />

<h1>Add bookings</h1>

<aui:form action="${initBookingActionURL}" method="post" name="fm">
	<aui:input name="city" type="text" />
	<aui:input name="arrivalDate" type="date" />
	<aui:input name="departureDate" type="date" />

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>

<script type="text/javascript">

	window.addEventListener("message", (event) => {
		
		document.location = event.data;
		
	}, false);
	
</script>