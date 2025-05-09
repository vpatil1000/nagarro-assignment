/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.nagacc.fulfilmentprocess.constants.NagaccFulfilmentProcessConstants;

public class NagaccFulfilmentProcessManager extends GeneratedNagaccFulfilmentProcessManager
{
	public static final NagaccFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (NagaccFulfilmentProcessManager) em.getExtension(NagaccFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
