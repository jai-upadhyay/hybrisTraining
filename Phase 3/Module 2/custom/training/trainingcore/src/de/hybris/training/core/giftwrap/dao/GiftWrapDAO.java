/**
 *
 */
package de.hybris.training.core.giftwrap.dao;

import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.List;


/**
 * @author jaiupadhyay
 *
 */
public interface GiftWrapDAO
{
	/**
	 * Return a list of GiftWrapModel that are currently persisted. If none are found an empty list is returned.
	 *
	 * @return all the gift wrap options in the system
	 */
	List<GiftWrapModel> findAllGiftWrapOption(); //to edit

	/**
	 * Finds all GiftWrapModel with given wrapType. If none is found, an empty list will be returned.
	 *
	 * @param wrapType
	 *           the wrap type to search for gift wrap options
	 * @return All gift wrap options with the given wrap type
	 */
	List<GiftWrapModel> findGiftWrapByType(GiftWrapType wrapType); //to edit
}
