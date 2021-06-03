/*******************************************************************************
 * Copyright (c) 2011 BT Harlequins
 * 
 * All rights reserved. This program and the accompanying materials are the confidential
 * property of BT Harlequins. It must not be copied, reproduced, modified, altered, or
 * circulated to any third party, in any form or media, without the prior written consent
 * of BT Harlequins
 *******************************************************************************/
package com.explore.featuredemo.controller;

import java.util.Date;
import java.util.List;


public interface ProductInstanceCharacteristicValueInventoryService {


	List<ProductInstanceCharacteristicValue> getBillingPicvByProductOrderIdAndName(final Long productOrderId,final String...attr) throws Exception;

}

