package demo;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryIntegrationServiceImpl {

	ProductInstanceCharacteristicValueInventoryService productInstanceCharacteristicValueInventoryService= null;

	public ProductInstanceCharacteristicValueInventoryService getProductInstanceCharacteristicValueInventoryService() {
		return productInstanceCharacteristicValueInventoryService;
	}

	public void setProductInstanceCharacteristicValueInventoryService(ProductInstanceCharacteristicValueInventoryService productInstanceCharacteristicValueInventoryService) {
		this.productInstanceCharacteristicValueInventoryService = productInstanceCharacteristicValueInventoryService;
	}

	public String isEemcdApplicable(final Long ultimateProductInstanceId) throws Exception {
		String isEemcdApplicable = null;
		if (ultimateProductInstanceId != null) {
			List<ProductInstanceCharacteristicValue> listOfPicvWithName = productInstanceCharacteristicValueInventoryService
					.getBillingPicvByultimateProductInstanceIdAndName(ultimateProductInstanceId, ApplicationConstants.SUPPLIERSERVICETYPE, ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME);
			if (CollectionUtils.isEmpty(listOfPicvWithName) || ( listOfPicvWithName.size() < ApplicationConstants.MIN_BILL_PICV_SIZE)) {
				isEemcdApplicable = ApplicationConstants.EEMCD_NOT_APPLICABLE;
				return isEemcdApplicable;
			}
			List<ProductInstanceCharacteristicValue> resultWithName = listOfPicvWithName.stream()
					.filter(picvWithName -> picvWithName != null && picvWithName.getValue() != null
							&& (ApplicationConstants.EE_MOBILE_CUSTOMER_DISC.trim()
							.equalsIgnoreCase(picvWithName.getValue().replaceAll("\\s", ""))
							|| ApplicationConstants.DISCOUNT
							.equalsIgnoreCase(picvWithName.getValue().replaceAll("\\s", ""))))
					.collect(Collectors.toList());
			//resultWithName.size() < ApplicationConstants.MIN_BILL_PICV_SIZE-- checking the size is greter than 2 which includes both serviceType and service name
			if (CollectionUtils.isEmpty(resultWithName) || resultWithName.size() < ApplicationConstants.MIN_BILL_PICV_SIZE) {
				isEemcdApplicable = ApplicationConstants.EEMCD_NOT_APPLICABLE;
				return isEemcdApplicable ;
			}  else {
				isEemcdApplicable = ApplicationConstants.EEMCD_APPLICABLE;
				return isEemcdApplicable;
			}
		}
		return isEemcdApplicable;
	}



/**
	 * Update address in customer vo.
	 * 
	 * @param customer
	 *            the customer
	 * @param customerVO
	 *            the customer vo
	 *//**
	 * Updates the line detail vo with current installation address
	 * 
	 * @param lineDetails
	 *            the line details
	 * @param addressOutput
	 *            The address output
	 * @return Line details
	 * @throws ApplicationException
	 */
}
