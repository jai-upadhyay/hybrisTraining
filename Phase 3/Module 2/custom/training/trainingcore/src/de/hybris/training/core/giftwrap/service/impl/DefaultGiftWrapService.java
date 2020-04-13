package de.hybris.training.core.giftwrap.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.giftwrap.dao.GiftWrapDAO;
import de.hybris.training.core.giftwrap.service.GiftWrapService;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * @author jaiupadhyay
 *
 */
public class DefaultGiftWrapService implements GiftWrapService
{


	private GiftWrapDAO giftWrapDAO;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.training.core.service.GiftWrapService#getAllGiftWrapOptions()
	 */
	@Override
	public List<GiftWrapModel> getAllGiftWrapOptions()
	{
		// XXX Auto-generated method stub
		return giftWrapDAO.findAllGiftWrapOption();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.training.core.service.GiftWrapService#getGiftWrapOptionsForType(java.lang.String)
	 */
	@Override
	public List<GiftWrapModel> getGiftWrapOptionsForType(final GiftWrapType wrapType)
	{
		final List<GiftWrapModel> result = giftWrapDAO.findGiftWrapByType(wrapType);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("wrapType with code '" + wrapType + "' not found!");
		}
		else if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException(
					"wrapType code '" + wrapType + "' is not unique, " + result.size() + " gift wrap options are found!");
		}
		return result;
	}

	@Required
	public void setGiftWrapDAO(final GiftWrapDAO giftWrapDAO)
	{
		this.giftWrapDAO = giftWrapDAO;
	}



}
