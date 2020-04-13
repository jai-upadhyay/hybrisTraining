package de.hybris.training.core.setup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import java.io.InputStream;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import de.hybris.training.core.constants.TrainingCoreConstants;
import de.hybris.platform.core.initialization.SystemSetup.Type;

@SystemSetup(extension = TrainingCoreConstants.EXTENSIONNAME)
public class GiftWrapOptionSetup
{
    // private static final Logger LOG = LoggerFactory.getLogger(GiftWrapOptionSetup.class);
    private ImportService importService;
    public ImportService getImportService()
    {
        return importService;
    }
    public void setImportService(final ImportService importService)
    {
        this.importService = importService;
    }
    @SystemSetup(type =  Type.ESSENTIAL)
    public boolean putInMyEssentialData()
    {
        // LOG.info("Starting custom essential data loading for the training-core (GIFT WRAP) extension");
        // LOG.info("Custom essential data loading for the training-core (GIFT WRAP) extension completed.");
        return true;
    }
    @SystemSetup(type =  Type.PROJECT)
    public boolean addMyProjectData()
    {
        // LOG.info("Starting custom project data loading for the Concerttours extension");
        impexImport("/trainingcore/import/giftwrap/giftWrapData.impex");
        // importImpexFile(context, "/trainingcore/import/common/essential-data.impex");
        // LOG.info("Custom project data loading for the training-core (GIFT WRAP) extension completed.");
        return true;
    }
    protected boolean impexImport(final String filename)
    {
        final String message = "training-core (GIFT WRAP) impexing [" + filename + "]...";
        try (final InputStream resourceAsStream = getClass().getResourceAsStream(filename))
        {
            // LOG.info(message);
            final ImportConfig importConfig = new ImportConfig();
            importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
            importConfig.setLegacyMode(Boolean.FALSE);
            final ImportResult importResult = getImportService().importData(importConfig);
            if (importResult.isError())
            {
                // LOG.error(message + " FAILED");
                return false;
            }
        }
        catch (final Exception e)
        {
            // LOG.error(message + " FAILED", e);
            return false;
        }
        return true;
    }
}