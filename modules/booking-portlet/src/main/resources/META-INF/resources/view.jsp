<%@ include file="/init.jsp" %>

<h1>Bookings</h1>

<ul>
	<c:forEach items="${bookings}" var="bookingId">
	
		<portlet:renderURL var="bookingURL">
			<portlet:param name="mvcRenderCommandName" value="checkStatus" />
			<portlet:param name="bookingId" value="${bookingId}" />
		</portlet:renderURL>
	
		<li><a href="${bookingURL}">${bookingId}</a></li>
	</c:forEach>
</ul>

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