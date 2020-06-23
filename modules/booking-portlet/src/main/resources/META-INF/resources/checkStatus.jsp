<%@ include file="/init.jsp" %>

<h1>Booking ${booking.bookingId}</h1>

<dl>
	<dt>City</dt>
	<dd>${booking.bookingInformation.city}</dd>
	<dt>Arrival date</dt>
	<dd>${booking.bookingInformation.arrivalDate}</dd>
	<dt>Departure date</dt>
	<dd>${booking.bookingInformation.departureDate}</dd>
	<dt>Status</dt>
	<dd>${booking.bookingStatus}</dd>
</dl>

<portlet:renderURL var="homeURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:actionURL name="updateBookingStatus" var="updateBookingStatusURL" />

<h1>Add bookings</h1>

<aui:form action="${updateBookingStatusURL}" method="post" name="fm">
	<aui:input type="hidden" name="bookingId" value="${booking.bookingId}" />
	<aui:select name="bookingStatus" value="${booking.bookingStatus}">
		<aui:option selected="${booking.bookingStatus == 'PENDING'}" value="PENDING">PENDING</aui:option>
		<aui:option selected="${booking.bookingStatus == 'VALIDATED'}" value="VALIDATED">VALIDATED</aui:option>
		<aui:option selected="${booking.bookingStatus == 'CANCELLED'}" value="CANCELLED">CANCELLED</aui:option>
	</aui:select>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>

<a href="${homeURL}">Back</a>