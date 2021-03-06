/*
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.fxopt;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.basics.currency.AdjustablePayment;
import com.opengamma.strata.product.ProductTrade;
import com.opengamma.strata.product.ResolvableTrade;
import com.opengamma.strata.product.TradeInfo;

/**
 * A trade in a vanilla FX option.
 * <p>
 * An Over-The-Counter (OTC) trade in an {@link FxVanillaOption}.
 * <p>
 * An FX option is a financial instrument that provides an option based on the future value of
 * a foreign exchange. The option is European, exercised only on the exercise date.
 */
@BeanDefinition
public final class FxVanillaOptionTrade
    implements ProductTrade, ResolvableTrade<ResolvedFxVanillaOptionTrade>, ImmutableBean, Serializable {

  /**
   * The additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   */
  @PropertyDefinition(overrideGet = true)
  private final TradeInfo info;
  /**
   * The FX option product that was agreed when the trade occurred.
   * <p>
   * The product captures the contracted financial details of the trade.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final FxVanillaOption product;
  /**
   * The premium of the FX option.
   * <p>
   * The premium sign should be compatible with the product Long/Short flag.
   * This means that the premium is negative for long and positive for short.
   */
  @PropertyDefinition(validate = "notNull")
  private final AdjustablePayment premium;

  //-------------------------------------------------------------------------
  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.info = TradeInfo.empty();
  }

  @Override
  public ResolvedFxVanillaOptionTrade resolve(ReferenceData refData) {
    return ResolvedFxVanillaOptionTrade.builder()
        .info(info)
        .product(product.resolve(refData))
        .premium(premium.resolve(refData))
        .build();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code FxVanillaOptionTrade}.
   * @return the meta-bean, not null
   */
  public static FxVanillaOptionTrade.Meta meta() {
    return FxVanillaOptionTrade.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(FxVanillaOptionTrade.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static FxVanillaOptionTrade.Builder builder() {
    return new FxVanillaOptionTrade.Builder();
  }

  private FxVanillaOptionTrade(
      TradeInfo info,
      FxVanillaOption product,
      AdjustablePayment premium) {
    JodaBeanUtils.notNull(product, "product");
    JodaBeanUtils.notNull(premium, "premium");
    this.info = info;
    this.product = product;
    this.premium = premium;
  }

  @Override
  public FxVanillaOptionTrade.Meta metaBean() {
    return FxVanillaOptionTrade.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   * @return the value of the property
   */
  @Override
  public TradeInfo getInfo() {
    return info;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the FX option product that was agreed when the trade occurred.
   * <p>
   * The product captures the contracted financial details of the trade.
   * @return the value of the property, not null
   */
  @Override
  public FxVanillaOption getProduct() {
    return product;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the premium of the FX option.
   * <p>
   * The premium sign should be compatible with the product Long/Short flag.
   * This means that the premium is negative for long and positive for short.
   * @return the value of the property, not null
   */
  public AdjustablePayment getPremium() {
    return premium;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FxVanillaOptionTrade other = (FxVanillaOptionTrade) obj;
      return JodaBeanUtils.equal(info, other.info) &&
          JodaBeanUtils.equal(product, other.product) &&
          JodaBeanUtils.equal(premium, other.premium);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(info);
    hash = hash * 31 + JodaBeanUtils.hashCode(product);
    hash = hash * 31 + JodaBeanUtils.hashCode(premium);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("FxVanillaOptionTrade{");
    buf.append("info").append('=').append(info).append(',').append(' ');
    buf.append("product").append('=').append(product).append(',').append(' ');
    buf.append("premium").append('=').append(JodaBeanUtils.toString(premium));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FxVanillaOptionTrade}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code info} property.
     */
    private final MetaProperty<TradeInfo> info = DirectMetaProperty.ofImmutable(
        this, "info", FxVanillaOptionTrade.class, TradeInfo.class);
    /**
     * The meta-property for the {@code product} property.
     */
    private final MetaProperty<FxVanillaOption> product = DirectMetaProperty.ofImmutable(
        this, "product", FxVanillaOptionTrade.class, FxVanillaOption.class);
    /**
     * The meta-property for the {@code premium} property.
     */
    private final MetaProperty<AdjustablePayment> premium = DirectMetaProperty.ofImmutable(
        this, "premium", FxVanillaOptionTrade.class, AdjustablePayment.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "info",
        "product",
        "premium");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case -318452137:  // premium
          return premium;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public FxVanillaOptionTrade.Builder builder() {
      return new FxVanillaOptionTrade.Builder();
    }

    @Override
    public Class<? extends FxVanillaOptionTrade> beanType() {
      return FxVanillaOptionTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code info} property.
     * @return the meta-property, not null
     */
    public MetaProperty<TradeInfo> info() {
      return info;
    }

    /**
     * The meta-property for the {@code product} property.
     * @return the meta-property, not null
     */
    public MetaProperty<FxVanillaOption> product() {
      return product;
    }

    /**
     * The meta-property for the {@code premium} property.
     * @return the meta-property, not null
     */
    public MetaProperty<AdjustablePayment> premium() {
      return premium;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return ((FxVanillaOptionTrade) bean).getInfo();
        case -309474065:  // product
          return ((FxVanillaOptionTrade) bean).getProduct();
        case -318452137:  // premium
          return ((FxVanillaOptionTrade) bean).getPremium();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code FxVanillaOptionTrade}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<FxVanillaOptionTrade> {

    private TradeInfo info;
    private FxVanillaOption product;
    private AdjustablePayment premium;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(FxVanillaOptionTrade beanToCopy) {
      this.info = beanToCopy.getInfo();
      this.product = beanToCopy.getProduct();
      this.premium = beanToCopy.getPremium();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case -318452137:  // premium
          return premium;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          this.info = (TradeInfo) newValue;
          break;
        case -309474065:  // product
          this.product = (FxVanillaOption) newValue;
          break;
        case -318452137:  // premium
          this.premium = (AdjustablePayment) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    /**
     * @deprecated Use Joda-Convert in application code
     */
    @Override
    @Deprecated
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    /**
     * @deprecated Use Joda-Convert in application code
     */
    @Override
    @Deprecated
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    /**
     * @deprecated Loop in application code
     */
    @Override
    @Deprecated
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public FxVanillaOptionTrade build() {
      return new FxVanillaOptionTrade(
          info,
          product,
          premium);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the additional trade information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the trade.
     * @param info  the new value
     * @return this, for chaining, not null
     */
    public Builder info(TradeInfo info) {
      this.info = info;
      return this;
    }

    /**
     * Sets the FX option product that was agreed when the trade occurred.
     * <p>
     * The product captures the contracted financial details of the trade.
     * @param product  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder product(FxVanillaOption product) {
      JodaBeanUtils.notNull(product, "product");
      this.product = product;
      return this;
    }

    /**
     * Sets the premium of the FX option.
     * <p>
     * The premium sign should be compatible with the product Long/Short flag.
     * This means that the premium is negative for long and positive for short.
     * @param premium  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder premium(AdjustablePayment premium) {
      JodaBeanUtils.notNull(premium, "premium");
      this.premium = premium;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("FxVanillaOptionTrade.Builder{");
      buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
      buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
      buf.append("premium").append('=').append(JodaBeanUtils.toString(premium));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
