/**
 *
 */
package de.hybris.training.core.giftwrap.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.giftwrap.dao.GiftWrapDAO;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author jaiupadhyay
 *
 */
@Component(value = "giftWrapDAO")
public class DefaultGiftWrapDAO implements GiftWrapDAO
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.training.core.giftwrap.dao.GiftWrapDAO#findAllGiftWrapOption()
	 */
	@Override
	public List<GiftWrapModel> findAllGiftWrapOption()
	{
		final String queryString = //
				"SELECT {p:" + GiftWrapModel.PK + "} " + "FROM {" + GiftWrapModel._TYPECODE + " AS p} ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		// Note that we could specify paginating logic by providing a start and count variable (commented out below)
		// This can provide a safeguard against returning very large amounts of data, or hogging the database when there are
		// for example millions of items being returned.
		// As we know that there are only a few persisted bands in this use case we do not need to provide this.
		//query.setStart(start);
		//query.setCount(count);
		// Return the list of BandModels.
		return flexibleSearchService.<GiftWrapModel> search(query).getResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.training.core.giftwrap.dao.GiftWrapDAO#findGiftWrapByType(java.lang.String)
	 */
	@Override
	public List<GiftWrapModel> findGiftWrapByType(final GiftWrapType wrapType)
	{
		final String queryString = //
				"SELECT {p:" + GiftWrapModel.PK + "}" //
						+ "FROM {" + GiftWrapModel._TYPECODE + " AS p} "//
						+ "WHERE " + "{p:" + GiftWrapModel.WRAPTYPE + "}=?wrapType ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		System.out.println("Wraptype is " + wrapType.ordinal());
		query.addQueryParameter("wrapType", wrapType.ordinal());
		return flexibleSearchService.<GiftWrapModel> search(query).getResult();
	}

}
