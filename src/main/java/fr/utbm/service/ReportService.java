package fr.utbm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.utbm.entity.Client;
import fr.utbm.entity.CourseSession;
import fr.utbm.entity.reportItem;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportService {
	
	public void generateReport(CourseSession cs) throws IOException {
		 try {
		/* Convert List to JRBeanCollectionDataSource */
	    List<reportItem> listItems = new ArrayList<reportItem>();
	    for(Client c : cs.getSubscribers())
	    	listItems.add(new reportItem(c.getFirstName()+" "+c.getLastName(),c.getAddress(),c.getPhone(),c.getEmail()));

        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
        List<reportItem> list = new ArrayList<reportItem>();
        reportItem rI = new reportItem();
        rI.setCourseCode(cs.getCourse().getCode());
        list.add(rI);
        
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", itemsJRBean);
        parameters.put("CourseCode", cs.getCourse().getCode());
        parameters.put("Location", cs.getLocation().getCity());
        parameters.put("startDate", cs.getStartDate());
        parameters.put("endDate", cs.getEndDate());


        /* Using compiled version(.jasper) of Jasper report to generate PDF */
        JasperPrint jasperPrint = JasperFillManager.fillReport("C:/Users/user/eclipse-workspace/jasper/src/main/resources/Template.jasper", parameters, new JREmptyDataSource());

        String outputFile = "C:/Users/user/eclipse-workspace/jasper/src/main/webapp/downloads/InscritsCourseReport.pdf";
		/* outputStream to create PDF */
        OutputStream outputStream = new FileOutputStream(new File(outputFile));
        /* Write content to PDF file */
       
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
		outputStream.close();
		} catch (JRException e) {
			
			e.printStackTrace();
		}

        System.out.println("File Generated");
	}
}
