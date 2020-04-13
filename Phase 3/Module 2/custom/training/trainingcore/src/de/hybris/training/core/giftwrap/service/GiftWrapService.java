/**
 *
 */
package de.hybris.training.core.giftwrap.service;

import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.List;


/**
 * @author jaiupadhyay
 *
 */
public interface GiftWrapService
{
	List<GiftWrapModel> getAllGiftWrapOptions();



	/**
	 * @param wrapType
	 * @return
	 */
	List<GiftWrapModel> getGiftWrapOptionsForType(GiftWrapType wrapType);

}
