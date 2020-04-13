/**
 *
 */
package de.hybris.training.core.giftwrap.service.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.enums.GiftWrapType;
import de.hybris.training.core.giftwrap.service.GiftWrapService;
import de.hybris.training.core.model.GiftWrapModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


@IntegrationTest
public class DefaultGiftWrapServiceIntegrationTest extends ServicelayerTest
{
	@Resource
	private GiftWrapService giftWrapService;
	@Resource
	private ModelService modelService;
	/** Test band */
	private GiftWrapModel giftWrapModel;
	/** Name of test band. */
	private static final String WRAP_CODE = "PRMitest1";
	/** Name of test band. */
	private static final GiftWrapType WRAP_TYPE = GiftWrapType.PREMIUM;
	/** History of test band. */
	private static final String WRAP_INSTRUCTIONS = "New contemporary, 7-piece Jaz unit from London, formed in 2015";
	/** Albums sold by test band. */
	private static final Integer WRAP_COST = Integer.valueOf(2);

	@Before
	public void setUp()
	{
		try
		{
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			new JdbcTemplate(Registry.getCurrentTenant().getDataSource()).execute("CHECKPOINT");
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}
		catch (final InterruptedException exc)
		{
		}
		// This instance of a BandModel will be used by the tests
		giftWrapModel = modelService.create(GiftWrapModel.class);
		giftWrapModel.setWrapCode(WRAP_CODE);
		giftWrapModel.setWrapType(WRAP_TYPE);
		giftWrapModel.setCost(WRAP_COST);
		giftWrapModel.setInstructions(WRAP_INSTRUCTIONS);
	}

	@Test(expected = UnknownIdentifierException.class)
	public void testFailBehavior()
	{
		giftWrapService.getGiftWrapOptionsForType(WRAP_TYPE);
	}

	/**
	 * This test tests and demonstrates that the Service's getAllBand method calls the DAOs' getAllBand method and
	 * returns the data it receives from it.
	 */
	@Test
	public void testGiftWrapService()
	{
		List<GiftWrapModel> giftWrapModels = giftWrapService.getAllGiftWrapOptions();
		final int size = giftWrapModels.size();
		modelService.save(giftWrapModel);
		giftWrapModels = giftWrapService.getAllGiftWrapOptions();
		assertEquals(size + 1, giftWrapModels.size());
		assertEquals("Unexpected giftwrap option found", giftWrapModel, giftWrapModels.get(giftWrapModels.size() - 1));
		final List<GiftWrapModel> persistedGiftWrapModel = giftWrapService.getGiftWrapOptionsForType(WRAP_TYPE);
		assertNotNull("No giftwrap option found", persistedGiftWrapModel);
		assertEquals("Different giftwrap option found", giftWrapModel, persistedGiftWrapModel);
	}

	/**
	 * This test tests and demonstrates that the Service's getAllBand method calls the DAOs' getAllBand method and
	 * returns the data it receives from it.
	 */
	//	@Test
	//	public void testGiftWrapServiceForType() throws Exception
	//	{
	//		createCoreData();
	//		importCsv("/trainingcore/import/giftwrap/giftWrapData.impex", "utf-8");
	//		final List<GiftWrapModel> giftwrap = giftWrapService.getGiftWrapOptionsForType(GiftWrapType.PREMIUM);
	//		assertEquals(giftwrap.size(), 3);
	//
	//	}
}
