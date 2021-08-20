package com.liferay.samples.fbo.bookings_web_service;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.ws.spi.Provider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.spi.ProviderImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
		immediate = true,
		service = BookingsPortFactory.class
		)
public class BookingsPortFactory {

    private BookingsPortService bookingsPortService;
    private URL wsdlURL;

	@Activate
	@Modified
	public void activate(BundleContext bundleContext, Map<String, Object> properties) {

		ServiceReference<Provider> providerServiceReference = bundleContext.getServiceReference(Provider.class);
		if(providerServiceReference == null) {

			ProviderImpl providerImpl = new ProviderImpl();
			
			Dictionary<String, Object> providerProperties = new Hashtable<>();
			
			bundleContext.registerService(Provider.class, providerImpl, providerProperties);
		}
		
		this.wsdlURL = getClass().getClassLoader().getResource("wsdl/bookings.wsdl");
	    this.bookingsPortService = new BookingsPortService(wsdlURL);
	}
	
	public BookingsPort getPort() {
		
		BookingsPort port = bookingsPortService.getBookingsPortSoap11();
		
		Client cxfClient = (Client) port;
		cxfClient.getInInterceptors().add(new LoggingInInterceptor());
		cxfClient.getOutInterceptors().add(new LoggingOutInterceptor());
		
		return port;
	}

}
