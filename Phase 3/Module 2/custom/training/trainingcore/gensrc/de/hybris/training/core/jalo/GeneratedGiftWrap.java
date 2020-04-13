/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 11, 2020, 4:00:30 PM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem GiftWrap}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedGiftWrap extends GenericItem
{
	/** Qualifier of the <code>GiftWrap.wrapCode</code> attribute **/
	public static final String WRAPCODE = "wrapCode";
	/** Qualifier of the <code>GiftWrap.wrapType</code> attribute **/
	public static final String WRAPTYPE = "wrapType";
	/** Qualifier of the <code>GiftWrap.cost</code> attribute **/
	public static final String COST = "cost";
	/** Qualifier of the <code>GiftWrap.instructions</code> attribute **/
	public static final String INSTRUCTIONS = "instructions";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(WRAPCODE, AttributeMode.INITIAL);
		tmp.put(WRAPTYPE, AttributeMode.INITIAL);
		tmp.put(COST, AttributeMode.INITIAL);
		tmp.put(INSTRUCTIONS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute.
	 * @return the cost - Cost for the wrap type
	 */
	public Integer getCost(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, COST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute.
	 * @return the cost - Cost for the wrap type
	 */
	public Integer getCost()
	{
		return getCost( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute. 
	 * @return the cost - Cost for the wrap type
	 */
	public int getCostAsPrimitive(final SessionContext ctx)
	{
		Integer value = getCost( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute. 
	 * @return the cost - Cost for the wrap type
	 */
	public int getCostAsPrimitive()
	{
		return getCostAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost - Cost for the wrap type
	 */
	public void setCost(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, COST,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost - Cost for the wrap type
	 */
	public void setCost(final Integer value)
	{
		setCost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost - Cost for the wrap type
	 */
	public void setCost(final SessionContext ctx, final int value)
	{
		setCost( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost - Cost for the wrap type
	 */
	public void setCost(final int value)
	{
		setCost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.instructions</code> attribute.
	 * @return the instructions - Details for the gift wrapping
	 */
	public String getInstructions(final SessionContext ctx)
	{
		return (String)getProperty( ctx, INSTRUCTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.instructions</code> attribute.
	 * @return the instructions - Details for the gift wrapping
	 */
	public String getInstructions()
	{
		return getInstructions( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.instructions</code> attribute. 
	 * @param value the instructions - Details for the gift wrapping
	 */
	public void setInstructions(final SessionContext ctx, final String value)
	{
		setProperty(ctx, INSTRUCTIONS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.instructions</code> attribute. 
	 * @param value the instructions - Details for the gift wrapping
	 */
	public void setInstructions(final String value)
	{
		setInstructions( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.wrapCode</code> attribute.
	 * @return the wrapCode - Unique identifier for giftwrap option
	 */
	public String getWrapCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, WRAPCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.wrapCode</code> attribute.
	 * @return the wrapCode - Unique identifier for giftwrap option
	 */
	public String getWrapCode()
	{
		return getWrapCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.wrapCode</code> attribute. 
	 * @param value the wrapCode - Unique identifier for giftwrap option
	 */
	public void setWrapCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, WRAPCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.wrapCode</code> attribute. 
	 * @param value the wrapCode - Unique identifier for giftwrap option
	 */
	public void setWrapCode(final String value)
	{
		setWrapCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.wrapType</code> attribute.
	 * @return the wrapType - Gift wrapping type (Standard and Premium)
	 */
	public EnumerationValue getWrapType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, WRAPTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.wrapType</code> attribute.
	 * @return the wrapType - Gift wrapping type (Standard and Premium)
	 */
	public EnumerationValue getWrapType()
	{
		return getWrapType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.wrapType</code> attribute. 
	 * @param value the wrapType - Gift wrapping type (Standard and Premium)
	 */
	public void setWrapType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, WRAPTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.wrapType</code> attribute. 
	 * @param value the wrapType - Gift wrapping type (Standard and Premium)
	 */
	public void setWrapType(final EnumerationValue value)
	{
		setWrapType( getSession().getSessionContext(), value );
	}
	
}
