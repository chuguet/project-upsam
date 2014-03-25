package com.upsam.hospital.model.jaxb;

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class JaxbUtils.
 */
@Component
public class JaxbUtils {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(JaxbUtils.class);

	/**
	 * Read xml.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the clazz
	 * @return the object
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public Object readXML(File xmlFile, Class<?> clazz) throws JAXBException {
		JAXBContext jc;
		jc = JAXBContext.newInstance(clazz);
		Unmarshaller u;
		u = jc.createUnmarshaller();
		return u.unmarshal(xmlFile);
	}

	/**
	 * Read xml.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the clazz
	 * @return the object
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public Object readXML(InputStream xmlFile, Class<?> clazz) throws JAXBException {
		JAXBContext jc;
		Unmarshaller u;
		jc = JAXBContext.newInstance(clazz);
		u = jc.createUnmarshaller();
		return u.unmarshal(xmlFile);
	}

	/**
	 * Removes the header xml file.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @return the string
	 */
	public String removeHeaderXmlFile(String xmlFile) {
		xmlFile = xmlFile.substring(xmlFile.indexOf(">") + 1);
		return xmlFile;
	}

	/**
	 * Write xml.
	 * 
	 * @param container
	 *            the container
	 * @param clazz
	 *            the clazz
	 * @return the string
	 */
	public String writeXML(Object container, Class<?> clazz) {
		JAXBContext jaxbContext;
		Writer writer = new StringWriter();
		try {
			jaxbContext = JAXBContext.newInstance(clazz);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(container, writer);
		}
		catch (JAXBException e) {
			LOG.error(e.getMessage(), e);
		}
		return writer.toString();
	}

}
