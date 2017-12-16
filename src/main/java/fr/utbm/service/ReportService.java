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
	    int i=0;
	    for(Client c : cs.getSubscribers()) {
	    	listItems.add(new reportItem(c.getFirstName(),cs.getStartDate()));
	    	System.out.println(listItems.get(i).toString());
	    	i++;
	    }
	    
	    
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
        List<reportItem> list = new ArrayList<reportItem>();
        reportItem rI = new reportItem();
        rI.setCourseCode(cs.getCourse().getCode());
        list.add(rI);
        JRBeanCollectionDataSource itemsRBeanCourseCode = new JRBeanCollectionDataSource(list);
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", itemsJRBean);
        parameters.put("ItemDataSourceCourseCode", cs.getCourse().getCode());


        /* Using compiled version(.jasper) of Jasper report to generate PDF */
        JasperPrint jasperPrint = JasperFillManager.fillReport("C:/Users/user/eclipse-workspace/jasper/Template.jasper", parameters, new JREmptyDataSource());

        String outputFile = "C:/Users/user/Desktop/report.pdf";
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
