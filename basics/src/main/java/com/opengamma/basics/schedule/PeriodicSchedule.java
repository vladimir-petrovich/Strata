/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.basics.schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.opengamma.collect.ArgChecker;
import com.opengamma.collect.Guavate;

/**
 * A complete schedule of periods (date ranges), with both unadjusted and adjusted dates.
 * <p>
 * The schedule consists of one or more adjacent periods (date ranges).
 * This is typically used as the basis for financial calculations, such as accrual of interest.
 */
@BeanDefinition
public final class PeriodicSchedule
    implements ImmutableBean, Serializable {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The schedule periods.
   * <p>
   * There will be at least one period.
   * The periods are ordered from earliest to latest.
   * It is intended that each period is adjacent to the next one, however each
   * period is independent and non-adjacent periods are allowed.
   */
  @PropertyDefinition(validate = "notEmpty")
  private final ImmutableList<SchedulePeriod> periods;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from a collection of schedule periods.
   * <p>
   * There must be at least one period.
   * The periods will be sorted from earliest to latest.
   * <p>
   * It is intended that each period is adjacent to the next one, however each
   * period is independent and non-adjacent periods are allowed.
   * 
   * @param periods  the list of schedule periods, not empty
   * @return the periods
   */
  public static PeriodicSchedule of(Collection<SchedulePeriod> periods) {
    ArgChecker.notEmpty(periods, "periods");
    ImmutableList<SchedulePeriod> sorted = periods.stream()
        .sorted(Comparator.naturalOrder())
        .collect(Guavate.toImmutableList());
    return new PeriodicSchedule(sorted);
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the number of periods in the schedule.
   * <p>
   * This returns the number of periods, which will be at least one.
   * 
   * @return the number of periods
   */
  public int size() {
    return periods.size();
  }

  /**
   * Gets a schedule period by index.
   * <p>
   * This returns a period using a zero-based index.
   * 
   * @param index  the zero-based period index
   * @return the schedule period
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  public SchedulePeriod getPeriod(int index) {
    return periods.get(index);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code PeriodicSchedule}.
   * @return the meta-bean, not null
   */
  public static PeriodicSchedule.Meta meta() {
    return PeriodicSchedule.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(PeriodicSchedule.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static PeriodicSchedule.Builder builder() {
    return new PeriodicSchedule.Builder();
  }

  private PeriodicSchedule(
      List<SchedulePeriod> periods) {
    JodaBeanUtils.notEmpty(periods, "periods");
    this.periods = ImmutableList.copyOf(periods);
  }

  @Override
  public PeriodicSchedule.Meta metaBean() {
    return PeriodicSchedule.Meta.INSTANCE;
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
   * Gets the schedule periods.
   * <p>
   * There will be at least one period.
   * The periods are ordered from earliest to latest.
   * It is intended that each period is adjacent to the next one, however each
   * period is independent and non-adjacent periods are allowed.
   * @return the value of the property, not empty
   */
  public ImmutableList<SchedulePeriod> getPeriods() {
    return periods;
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
      PeriodicSchedule other = (PeriodicSchedule) obj;
      return JodaBeanUtils.equal(getPeriods(), other.getPeriods());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getPeriods());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("PeriodicSchedule{");
    buf.append("periods").append('=').append(JodaBeanUtils.toString(getPeriods()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code PeriodicSchedule}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code periods} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableList<SchedulePeriod>> periods = DirectMetaProperty.ofImmutable(
        this, "periods", PeriodicSchedule.class, (Class) ImmutableList.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "periods");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -678739246:  // periods
          return periods;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public PeriodicSchedule.Builder builder() {
      return new PeriodicSchedule.Builder();
    }

    @Override
    public Class<? extends PeriodicSchedule> beanType() {
      return PeriodicSchedule.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code periods} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableList<SchedulePeriod>> periods() {
      return periods;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -678739246:  // periods
          return ((PeriodicSchedule) bean).getPeriods();
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
   * The bean-builder for {@code PeriodicSchedule}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<PeriodicSchedule> {

    private List<SchedulePeriod> periods = new ArrayList<SchedulePeriod>();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(PeriodicSchedule beanToCopy) {
      this.periods = new ArrayList<SchedulePeriod>(beanToCopy.getPeriods());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -678739246:  // periods
          return periods;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -678739246:  // periods
          this.periods = (List<SchedulePeriod>) newValue;
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

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public PeriodicSchedule build() {
      return new PeriodicSchedule(
          periods);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code periods} property in the builder.
     * @param periods  the new value, not empty
     * @return this, for chaining, not null
     */
    public Builder periods(List<SchedulePeriod> periods) {
      JodaBeanUtils.notEmpty(periods, "periods");
      this.periods = periods;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("PeriodicSchedule.Builder{");
      buf.append("periods").append('=').append(JodaBeanUtils.toString(periods));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
