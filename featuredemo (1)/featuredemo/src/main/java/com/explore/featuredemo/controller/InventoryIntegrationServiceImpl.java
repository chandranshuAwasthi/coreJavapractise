package com.explore.featuredemo.controller;

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

	public String isEemcdApplicable(final Long productOrderId) throws Exception {

		String isEemcdApplicable = null;
		if (productOrderId != null) {
			//LOG.info(" product order number: {}", productOrderId);
			List<ProductInstanceCharacteristicValue> listOFPicvWithName = productInstanceCharacteristicValueInventoryService
					.getBillingPicvByProductOrderIdAndName(productOrderId,
							new String[] { ApplicationConstants.SUPPLIERSERVICETYPE,  ApplicationConstants.CPE_SUPPLIER_SERVICE_NAME});
			if (CollectionUtils.isEmpty(listOFPicvWithName)
					&& listOFPicvWithName.size() < ApplicationConstants.MIN_BILL_PICV_SIZE) {
				return isEemcdApplicable = ApplicationConstants.EEMCD_NOT_APPLICABLE;
			}
			List<ProductInstanceCharacteristicValue> resultWithName = listOFPicvWithName.stream() // convert list to
																									// stream
					.filter(picvWithName -> ApplicationConstants.EE_MOBILE_CUSTOMER_DISC.trim()
							.equals(picvWithName.getValue().trim())
							&& ApplicationConstants.DISCOUNT.equalsIgnoreCase(picvWithName.getValue()))
					.collect(Collectors.toList());
			if (CollectionUtils.isEmpty(resultWithName)) {
				return isEemcdApplicable = ApplicationConstants.EEMCD_NOT_APPLICABLE;
			} else {
				return isEemcdApplicable = ApplicationConstants.EEMCD_APPLICABLE;
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
