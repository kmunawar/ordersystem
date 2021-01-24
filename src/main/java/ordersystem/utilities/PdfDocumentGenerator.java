package ordersystem.utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ordersystem.model.CustomerOrder;
import ordersystem.model.OrderItem;

/**
 * @author Mian Munawar
 *
 */
public class PdfDocumentGenerator {

	public PdfDocumentGenerator() {
		super();
	}
	
	
	public static ByteArrayInputStream report(CustomerOrder customerOrder) {
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(80);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Customer Invoice", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            
            PdfPCell cell;

            Long id = customerOrder.getId();
            cell = new PdfPCell(new Phrase("Order Number: " + id));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);            
            
            String name = customerOrder.getCustomer().getFullName();
            cell = new PdfPCell(new Phrase("Name: " + name));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);            

            String address = customerOrder.getCustomer().getAddress();
            cell = new PdfPCell(new Phrase("Address: " + address));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            
            for (OrderItem orderItem: customerOrder.getOrderItems()) {
                String title = orderItem.getMenuItem().getTitle();
                Double cost = orderItem.getMenuItem().getPrice();
                cell = new PdfPCell(new Phrase(title + " --- $" + Double.toString(cost)));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);            
            }            

            Long deliveryTimeMins = customerOrder.getDeliveryTimeMins();
            cell = new PdfPCell(new Phrase("Delivery Time Estimate (mins): " + deliveryTimeMins));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            
            Double totalCost = customerOrder.getTotalPrice();
            Double tax = customerOrder.getTax();
            Double deliveryCharge = customerOrder.getDeliveryCharge();
            cell = new PdfPCell(new Phrase("Delivery Charge: " + Double.toString(deliveryCharge) + " Tax: "
            		+ Double.toString(tax) + " Total: $" + Double.toString(totalCost)));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);            
            
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            
            document.close();            
        	
        } catch (Exception e) {
        	Logger.getLogger(PdfDocumentGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	

}
