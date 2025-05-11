/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 11-May-2025, 2:29:21 pm                     ---
 * ----------------------------------------------------------------
 */
package org.nagacc.core.jalo;

import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.cms2.jalo.site.CMSSite;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.AbstractOrderEntry;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nagacc.core.constants.NagaccCoreConstants;
import org.nagacc.core.jalo.ApparelProduct;
import org.nagacc.core.jalo.ApparelSizeVariantProduct;
import org.nagacc.core.jalo.ApparelStyleVariantProduct;
import org.nagacc.core.jalo.ElectronicsColorVariantProduct;
import org.nagacc.core.jalo.Seller;
import org.nagacc.core.jalo.SellerCarouselComponent;

/**
 * Generated class for type <code>NagaccCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNagaccCoreManager extends Extension
{
	/** Relation ordering override parameter constants for SellerProductRelation from ((nagacccore))*/
	protected static String SELLERPRODUCTRELATION_SRC_ORDERED = "relation.SellerProductRelation.source.ordered";
	protected static String SELLERPRODUCTRELATION_TGT_ORDERED = "relation.SellerProductRelation.target.ordered";
	/** Relation disable markmodifed parameter constants for SellerProductRelation from ((nagacccore))*/
	protected static String SELLERPRODUCTRELATION_MARKMODIFIED = "relation.SellerProductRelation.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("seller", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.AbstractOrderEntry", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("dispatchDate", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.AbstractOrder", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("todaysDispatchOrdersCount", AttributeMode.INITIAL);
		tmp.put("todaysDispatchOrders", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.cms2.jalo.site.CMSSite", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Seller createSeller(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.SELLER );
			return (Seller)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Seller : "+e.getMessage(), 0 );
		}
	}
	
	public Seller createSeller(final Map attributeValues)
	{
		return createSeller( getSession().getSessionContext(), attributeValues );
	}
	
	public SellerCarouselComponent createSellerCarouselComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NagaccCoreConstants.TC.SELLERCAROUSELCOMPONENT );
			return (SellerCarouselComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SellerCarouselComponent : "+e.getMessage(), 0 );
		}
	}
	
	public SellerCarouselComponent createSellerCarouselComponent(final Map attributeValues)
	{
		return createSellerCarouselComponent( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.dispatchDate</code> attribute.
	 * @return the dispatchDate
	 */
	public Date getDispatchDate(final SessionContext ctx, final AbstractOrder item)
	{
		return (Date)item.getProperty( ctx, NagaccCoreConstants.Attributes.AbstractOrder.DISPATCHDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.dispatchDate</code> attribute.
	 * @return the dispatchDate
	 */
	public Date getDispatchDate(final AbstractOrder item)
	{
		return getDispatchDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.dispatchDate</code> attribute. 
	 * @param value the dispatchDate
	 */
	public void setDispatchDate(final SessionContext ctx, final AbstractOrder item, final Date value)
	{
		item.setProperty(ctx, NagaccCoreConstants.Attributes.AbstractOrder.DISPATCHDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.dispatchDate</code> attribute. 
	 * @param value the dispatchDate
	 */
	public void setDispatchDate(final AbstractOrder item, final Date value)
	{
		setDispatchDate( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return NagaccCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrderEntry.seller</code> attribute.
	 * @return the seller
	 */
	public Seller getSeller(final SessionContext ctx, final AbstractOrderEntry item)
	{
		return (Seller)item.getProperty( ctx, NagaccCoreConstants.Attributes.AbstractOrderEntry.SELLER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrderEntry.seller</code> attribute.
	 * @return the seller
	 */
	public Seller getSeller(final AbstractOrderEntry item)
	{
		return getSeller( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrderEntry.seller</code> attribute. 
	 * @param value the seller
	 */
	public void setSeller(final SessionContext ctx, final AbstractOrderEntry item, final Seller value)
	{
		item.setProperty(ctx, NagaccCoreConstants.Attributes.AbstractOrderEntry.SELLER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrderEntry.seller</code> attribute. 
	 * @param value the seller
	 */
	public void setSeller(final AbstractOrderEntry item, final Seller value)
	{
		setSeller( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.seller</code> attribute.
	 * @return the seller
	 */
	public Collection<Seller> getSeller(final SessionContext ctx, final Product item)
	{
		final List<Seller> items = item.getLinkedItems( 
			ctx,
			false,
			NagaccCoreConstants.Relations.SELLERPRODUCTRELATION,
			"Seller",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.seller</code> attribute.
	 * @return the seller
	 */
	public Collection<Seller> getSeller(final Product item)
	{
		return getSeller( getSession().getSessionContext(), item );
	}
	
	public long getSellerCount(final SessionContext ctx, final Product item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			NagaccCoreConstants.Relations.SELLERPRODUCTRELATION,
			"Seller",
			null
		);
	}
	
	public long getSellerCount(final Product item)
	{
		return getSellerCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.seller</code> attribute. 
	 * @param value the seller
	 */
	public void setSeller(final SessionContext ctx, final Product item, final Collection<Seller> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			NagaccCoreConstants.Relations.SELLERPRODUCTRELATION,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(SELLERPRODUCTRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.seller</code> attribute. 
	 * @param value the seller
	 */
	public void setSeller(final Product item, final Collection<Seller> value)
	{
		setSeller( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to seller. 
	 * @param value the item to add to seller
	 */
	public void addToSeller(final SessionContext ctx, final Product item, final Seller value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			NagaccCoreConstants.Relations.SELLERPRODUCTRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(SELLERPRODUCTRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to seller. 
	 * @param value the item to add to seller
	 */
	public void addToSeller(final Product item, final Seller value)
	{
		addToSeller( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from seller. 
	 * @param value the item to remove from seller
	 */
	public void removeFromSeller(final SessionContext ctx, final Product item, final Seller value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			NagaccCoreConstants.Relations.SELLERPRODUCTRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(SELLERPRODUCTRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from seller. 
	 * @param value the item to remove from seller
	 */
	public void removeFromSeller(final Product item, final Seller value)
	{
		removeFromSeller( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrders</code> attribute.
	 * @return the todaysDispatchOrders
	 */
	public List<AbstractOrder> getTodaysDispatchOrders(final SessionContext ctx, final CMSSite item)
	{
		List<AbstractOrder> coll = (List<AbstractOrder>)item.getProperty( ctx, NagaccCoreConstants.Attributes.CMSSite.TODAYSDISPATCHORDERS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrders</code> attribute.
	 * @return the todaysDispatchOrders
	 */
	public List<AbstractOrder> getTodaysDispatchOrders(final CMSSite item)
	{
		return getTodaysDispatchOrders( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrders</code> attribute. 
	 * @param value the todaysDispatchOrders
	 */
	public void setTodaysDispatchOrders(final SessionContext ctx, final CMSSite item, final List<AbstractOrder> value)
	{
		item.setProperty(ctx, NagaccCoreConstants.Attributes.CMSSite.TODAYSDISPATCHORDERS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrders</code> attribute. 
	 * @param value the todaysDispatchOrders
	 */
	public void setTodaysDispatchOrders(final CMSSite item, final List<AbstractOrder> value)
	{
		setTodaysDispatchOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute.
	 * @return the todaysDispatchOrdersCount
	 */
	public Integer getTodaysDispatchOrdersCount(final SessionContext ctx, final CMSSite item)
	{
		return (Integer)item.getProperty( ctx, NagaccCoreConstants.Attributes.CMSSite.TODAYSDISPATCHORDERSCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute.
	 * @return the todaysDispatchOrdersCount
	 */
	public Integer getTodaysDispatchOrdersCount(final CMSSite item)
	{
		return getTodaysDispatchOrdersCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @return the todaysDispatchOrdersCount
	 */
	public int getTodaysDispatchOrdersCountAsPrimitive(final SessionContext ctx, final CMSSite item)
	{
		Integer value = getTodaysDispatchOrdersCount( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @return the todaysDispatchOrdersCount
	 */
	public int getTodaysDispatchOrdersCountAsPrimitive(final CMSSite item)
	{
		return getTodaysDispatchOrdersCountAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @param value the todaysDispatchOrdersCount
	 */
	public void setTodaysDispatchOrdersCount(final SessionContext ctx, final CMSSite item, final Integer value)
	{
		item.setProperty(ctx, NagaccCoreConstants.Attributes.CMSSite.TODAYSDISPATCHORDERSCOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @param value the todaysDispatchOrdersCount
	 */
	public void setTodaysDispatchOrdersCount(final CMSSite item, final Integer value)
	{
		setTodaysDispatchOrdersCount( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @param value the todaysDispatchOrdersCount
	 */
	public void setTodaysDispatchOrdersCount(final SessionContext ctx, final CMSSite item, final int value)
	{
		setTodaysDispatchOrdersCount( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSSite.todaysDispatchOrdersCount</code> attribute. 
	 * @param value the todaysDispatchOrdersCount
	 */
	public void setTodaysDispatchOrdersCount(final CMSSite item, final int value)
	{
		setTodaysDispatchOrdersCount( getSession().getSessionContext(), item, value );
	}
	
}
