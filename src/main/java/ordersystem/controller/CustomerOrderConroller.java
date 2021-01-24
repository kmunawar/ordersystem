package ordersystem.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ordersystem.model.CustomerOrder;
import ordersystem.service.CustomerOrderService;
import ordersystem.utilities.PdfDocumentGenerator;

/**
 * @author Mian Munawar
 *
 */
@RestController
public class CustomerOrderConroller {
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/orders")
	public List<CustomerOrder> getAllOrders() {
		
		return customerOrderService.getAllOrders();
	}	

	@RequestMapping("/orders/{id}")
	public CustomerOrder getOrder(@PathVariable Long id) {		
		CustomerOrder order = customerOrderService.getOrder(id);
		return order;
	}
	
	@RequestMapping(value = "/orders/invoice/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getInvoice(@PathVariable Long id) {
		
		CustomerOrder customerOrder = customerOrderService.getOrder(id);

		
		ByteArrayInputStream bis = PdfDocumentGenerator.report(customerOrder);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=invoice.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));			
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public void addOrder(@RequestBody CustomerOrder order) {
		customerOrderService.addOrder(order);
	}		

	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}")
	public void updateOrder(@RequestBody CustomerOrder order, @PathVariable Long id) {
		customerOrderService.updateOrder(order, id);
	}		

	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{id}")
	public void deleteOrder(@PathVariable Long id) {				
		customerOrderService.deleteOrder(id);
	}	

}
