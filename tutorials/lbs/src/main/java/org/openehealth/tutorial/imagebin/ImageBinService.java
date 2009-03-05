
/*
 * 
 */

package org.openehealth.tutorial.imagebin;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.1.3
 * Thu Mar 05 14:39:02 CET 2009
 * Generated source version: 2.1.3
 * 
 */


@WebServiceClient(name = "ImageBinService", 
                  wsdlLocation = "file:/C:/dev/svn/ipf/tutorials/lbs/src/main/resources/wsdl/imagebin.wsdl",
                  targetNamespace = "http://tutorial.openehealth.org/imagebin/") 
public class ImageBinService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://tutorial.openehealth.org/imagebin/", "ImageBinService");
    public final static QName ImageBin = new QName("http://tutorial.openehealth.org/imagebin/", "ImageBin");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/dev/svn/ipf/tutorials/lbs/src/main/resources/wsdl/imagebin.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/dev/svn/ipf/tutorials/lbs/src/main/resources/wsdl/imagebin.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public ImageBinService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ImageBinService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImageBinService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns ImageBin
     */
    @WebEndpoint(name = "ImageBin")
    public ImageBin getImageBin() {
        return super.getPort(ImageBin, ImageBin.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImageBin
     */
    @WebEndpoint(name = "ImageBin")
    public ImageBin getImageBin(WebServiceFeature... features) {
        return super.getPort(ImageBin, ImageBin.class, features);
    }

}
