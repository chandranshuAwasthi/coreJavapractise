package com.explore.featuredemo;

import com.explore.featuredemo.controller.ApplicationConstants;
import com.explore.featuredemo.controller.InventoryIntegrationServiceImpl;
import com.explore.featuredemo.controller.ProductInstanceCharacteristicValue;
import com.explore.featuredemo.controller.ProductInstanceCharacteristicValueInventoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FeatureService.class)
@PowerMockIgnore({"org.xml.*", "javax.xml.*", "com.sun.*", "org.w3c.*"})
public class InventoryIntegrationServiceImplTest {

	@Mock
	ProductInstanceCharacteristicValueInventoryService productInstanceCharacteristicValueInventoryService;
	InventoryIntegrationServiceImpl target;
	@Before
	public void setup() {
		target = new InventoryIntegrationServiceImpl();
		productInstanceCharacteristicValueInventoryService = mock(ProductInstanceCharacteristicValueInventoryService.class);
		target.setProductInstanceCharacteristicValueInventoryService(productInstanceCharacteristicValueInventoryService);
	}

	
	
	@Test
	public void testisEemcdApplicableWhenBothNamesareAvailable()  {
		Long poId = 12354L;
        List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
        ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
        picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
        picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
        ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
        picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
        picv1.setValue(ApplicationConstants.DISCOUNT);
        bbpicvorders.add(picv1);
        bbpicvorders.add(picv2);       
        try {
			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
			        .thenReturn(bbpicvorders);
			String expectedResult="Y";
	        String returnResult=target.isEemcdApplicable(poId);
	        assertEquals(expectedResult, returnResult);     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	
	
	@Test
	public void testisEemcdApplicableWhenDifferentNamesareAvailable() {
		Long poId = 12354L;
        List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
        ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
        picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
        picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
        ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
        picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
        picv1.setValue(ApplicationConstants.DISCOUNT);
        bbpicvorders.add(picv1);
        bbpicvorders.add(picv2);       
        try {
			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
			        .thenReturn(bbpicvorders);
			String expectedResult="Y";
	        String returnResult=target.isEemcdApplicable(poId);
	        assertEquals(expectedResult, returnResult);     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        
        @Test
    	public void testisEemcdApplicableWhenOnlyOneNameisAvailable() {
    		Long poId = 12354L;
            List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
            ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
            picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
            picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
            ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
            picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
            picv1.setValue(ApplicationConstants.DISCOUNT);
            bbpicvorders.add(picv1);
            bbpicvorders.add(picv2);       
            try {
    			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
    					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
    			        .thenReturn(bbpicvorders);
    			String expectedResult="Y";
    	        String returnResult=target.isEemcdApplicable(poId);
    	        assertEquals(expectedResult, returnResult);     
    		} catch (InventoryException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
            
            @Test
        	public void testisEemcdApplicableWhenOneisexpectedAndOtherisDifferent()  {
        		Long poId = 12354L;
                List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
                ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
                picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
                picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
                ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
                picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
                picv1.setValue(ApplicationConstants.DISCOUNT);
                bbpicvorders.add(picv1);
                bbpicvorders.add(picv2);       
                try {
        			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
        					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
        			        .thenReturn(bbpicvorders);
        			String expectedResult="Y";
        	        String returnResult=target.isEemcdApplicable(poId);
        	        assertEquals(expectedResult, returnResult);     
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}}
                
                @Test
            	public void testisEemcdApplicableWhenPicvIsempty() throws Exception {
            		Long poId = 12354L;
                    List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
                    ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
                    picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
                    picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
                    ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
                    picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
                    picv1.setValue(ApplicationConstants.DISCOUNT);
                    bbpicvorders.add(picv1);
                    bbpicvorders.add(picv2);       
                    try {
            			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
            					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
            			        .thenReturn(bbpicvorders);
            			String expectedResult="Y";
            	        String returnResult=target.isEemcdApplicable(poId);
            	        assertEquals(expectedResult, returnResult);     
            		} catch (Exception e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}

	}

                
                @Test
            	public void testisEemcdApplicableWhenPoidIsNull() throws MaskException {
            		Long poId = 12354L;
                    List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
                    ProductInstanceCharacteristicValue picv1=new ProductInstanceCharacteristicValue();
                    picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
                    picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
                    ProductInstanceCharacteristicValue picv2=new ProductInstanceCharacteristicValue();
                    picv1.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
                    picv1.setValue(ApplicationConstants.DISCOUNT);
                    bbpicvorders.add(picv1);
                    bbpicvorders.add(picv2);       
                    try {
            			when(productInstanceCharacteristicValueInventoryService.getBillingPicvByProductOrderIdAndName(poId,
            					new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME}))
            			        .thenReturn(bbpicvorders);
            			String expectedResult="Y";
            	        String returnResult=target.isEemcdApplicable(poId);
            	        assertEquals(expectedResult, returnResult);     
            		} catch (InventoryException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}

	}

	
}
