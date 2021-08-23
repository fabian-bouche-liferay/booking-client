<%@ include file="/init.jsp" %>

<ul>
	<c:forEach items="${bookings}" var="bookingId">
	
		<portlet:renderURL var="bookingURL">
			<portlet:param name="mvcRenderCommandName" value="checkStatus" />
			<portlet:param name="bookingId" value="${bookingId}" />
		</portlet:renderURL>
	
		<li><a href="#" onclick="redirectToBookingDetails('${bookingURL}')">${bookingId}</a></li>
	</c:forEach>
</ul>

<script type="text/javascript">

function redirectToBookingDetails(bookingURL) {
	window.parent.postMessage(bookingURL, "*");
}

</script>