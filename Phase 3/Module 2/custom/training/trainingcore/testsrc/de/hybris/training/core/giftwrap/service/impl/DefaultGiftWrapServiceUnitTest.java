/**
 *
 */
package de.hybris.training.core.giftwrap.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.giftwrap.dao.GiftWrapDAO;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * @author jaiupadhyay
 *
 */

@UnitTest
public class DefaultGiftWrapServiceUnitTest
{
	private DefaultGiftWrapService giftWrapService;
	private GiftWrapDAO giftWrapDAO;
	private GiftWrapModel giftWrapModel;
	/** Name of test band. */
	private static final String WRAP_CODE = "STDtest1";
	/** Name of test band. */
	private static final GiftWrapType WRAP_TYPE = GiftWrapType.STANDARD;
	/** History of test band. */
	private static final Integer WRAP_COST = 2;

	private static final String WRAP_INSTRUCTIONS = "this is the unit test";

	@Before
	public void setUp()
	{
		// We will be testing BandServiceImpl - an implementation of BandService
		giftWrapService = new DefaultGiftWrapService();
		// So as not to implicitly also test the DAO, we will mock out the DAO using Mockito
		giftWrapDAO = mock(GiftWrapDAO.class);
		// and inject this mocked DAO into the BandService
		giftWrapService.setGiftWrapDAO(giftWrapDAO);
		// This instance of a BandModel will be used by the tests
		giftWrapModel = new GiftWrapModel();
		giftWrapModel.setWrapCode(WRAP_CODE);
		giftWrapModel.setWrapType(WRAP_TYPE);
		giftWrapModel.setCost(WRAP_COST);
		giftWrapModel.setInstructions(WRAP_INSTRUCTIONS);
	}

	/**
	 * This test tests and demonstrates that the Service's getAllBands method calls the DAOs' getBands method and returns
	 * the data it receives from it.
	 */
	@Test
	public void testGetAllGiftWrapOptions()
	{
		// We construct the data we would like the mocked out DAO to return when called
		final List<GiftWrapModel> giftWrapModels = Arrays.asList(giftWrapModel);
		//Use Mockito and compare results
		when(giftWrapDAO.findAllGiftWrapOption()).thenReturn(giftWrapModels);
		// Now we make the call to BandService's getBands() which we expect to call the DAOs' findBands() method
		final List<GiftWrapModel> result = giftWrapService.getAllGiftWrapOptions();
		// We then verify that the results returned from the service match those returned by the mocked-out DAO
		assertEquals("We should find one", 1, result.size());
		assertEquals("And should equals what the mock returned", giftWrapModel, result.get(0));
	}

	@Test
	public void testGetGiftWrapOptionsForType()
	{
		final List<GiftWrapModel> giftWrapModels = Arrays.asList(giftWrapModel);
		// Tell Mockito we expect a call to the DAO's getBand(), and, if it occurs, Mockito should return BandModel instance
		when(giftWrapDAO.findGiftWrapByType(WRAP_TYPE)).thenReturn(giftWrapModels);
		// We make the call to the Service's getBandForCode() which we expect to call the DAO's findBandsByCode()
		final List<GiftWrapModel> result = giftWrapService.getGiftWrapOptionsForType(WRAP_TYPE);
		// We then verify that the result returned from the Service is the same as that returned from the DAO
		assertEquals("GiftWrapOption should equals() what the mock returned", giftWrapModel, result.get(0));
	}

}
