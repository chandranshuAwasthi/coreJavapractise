package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class InventoryIntegrationServiceImplTest {

	/*@Test
	void contextLoads() {
	}
*/

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
	public void testisEemcdApplicableWhenBothNamesAreAvailable() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
		ProductInstanceCharacteristicValue picv2 = new ProductInstanceCharacteristicValue();
		picv2.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv2.setValue(ApplicationConstants.DISCOUNT);
		bbpicvorders.add(picv1);
		bbpicvorders.add(picv2);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "Y";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenOneValuesisDifferent() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
		ProductInstanceCharacteristicValue picv2 = new ProductInstanceCharacteristicValue();
		picv2.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv2.setValue("ApplicationConstants.DISCOUNT");
		bbpicvorders.add(picv1);
		bbpicvorders.add(picv2);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenonlyOneNameandValueAvailable() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
		bbpicvorders.add(picv1);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenPicvIsNull() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = null;

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);
	}

	@Test
	public void testisEemcdApplicableWhenPicvIsEmpty() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = null;

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenAddedPicvIsNull() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv = null;
		ProductInstanceCharacteristicValue picv2 = null;
		bbpicvorders.add(picv);
		bbpicvorders.add(picv2);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenBothValuesareDifferent() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue("ApplicationConstants.EE_MOBILE_CUSTOMER_DISC");
		ProductInstanceCharacteristicValue picv2 = new ProductInstanceCharacteristicValue();
		picv2.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv2.setValue("ApplicationConstants.DISCOUNT");
		bbpicvorders.add(picv1);
		bbpicvorders.add(picv2);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "N";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenValuesHavingExtraSpaces() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue("EE Mobile  Customer Disc");
		ProductInstanceCharacteristicValue picv2 = new ProductInstanceCharacteristicValue();
		picv2.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv2.setValue("DISC OUNT");
		bbpicvorders.add(picv1);
		bbpicvorders.add(picv2);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "Y";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}

	@Test
	public void testisEemcdApplicableWhenManyNamesareAvailable() throws Exception {
		Long ultimateProductInstance = 12354L;
		List<ProductInstanceCharacteristicValue> bbpicvorders = new ArrayList<>();
		ProductInstanceCharacteristicValue picv1 = new ProductInstanceCharacteristicValue();
		picv1.setName(ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
		picv1.setValue(ApplicationConstants.EE_MOBILE_CUSTOMER_DISC);
		ProductInstanceCharacteristicValue picv2 = new ProductInstanceCharacteristicValue();
		picv2.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv2.setValue(ApplicationConstants.DISCOUNT);
		ProductInstanceCharacteristicValue picv3 = new ProductInstanceCharacteristicValue();
		picv3.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv3.setValue("ApplicationConstants.DISCOUNT");
		ProductInstanceCharacteristicValue picv4 = new ProductInstanceCharacteristicValue();
		picv4.setName(ApplicationConstants.SUPPLIERSERVICETYPE);
		picv4.setValue("ApplicationConstants");
		ProductInstanceCharacteristicValue picv5 = null;
		bbpicvorders.add(picv1);
		bbpicvorders.add(picv2);
		bbpicvorders.add(picv3);
		bbpicvorders.add(picv4);
		bbpicvorders.add(picv5);

		when(productInstanceCharacteristicValueInventoryService
				.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstance, new String[] {
						ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME }))
				.thenReturn(bbpicvorders);
		String expectedResult = "Y";
		String returnResult = target.isEemcdApplicable(ultimateProductInstance);
		assertEquals(expectedResult, returnResult);

	}




}
