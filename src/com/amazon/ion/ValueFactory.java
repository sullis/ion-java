// Copyright (c) 2007-2009 Amazon.com, Inc.  All rights reserved.

package com.amazon.ion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 * The factory for all {@link IonValue}s.
 */
public interface ValueFactory
{
    /**
     * Constructs a new <code>null.blob</code> instance.
     */
    public IonBlob newNullBlob();


    /**
     * Constructs a new Ion {@code blob} instance, copying bytes from an array.
     *
     * @param value the data for the new blob, to be <em>copied</em> from the
     * given array into the new instance.
     * May be {@code null} to create a {@code null.blob} value.
     */
    public IonBlob newBlob(byte[] value);


    /**
     * Constructs a new Ion {@code blob}, copying bytes from part of an array.
     * <p>
     * This method copies {@code length} bytes from the given array into the
     * new value, starting at the given offset in the array.
     *
     * @param value the data for the new blob, to be <em>copied</em> from the
     * given array into the new instance.
     * May be {@code null} to create a {@code null.blob} value.
     * @param offset the offset within the array of the first byte to copy;
     * must be non-negative an no larger than {@code bytes.length}.
     * @param length the number of bytes to be copied from the given array;
     * must be non-negative an no larger than {@code bytes.length - offset}.
     *
     * @throws IndexOutOfBoundsException
     * if the preconditions on the {@code offset} and {@code length} parameters
     * are not met.
     */
    public IonBlob newBlob(byte[] value, int offset, int length);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.bool</code> instance.
     */
    public IonBool newNullBool();


    /**
     * Constructs a new <code>bool</code> instance with the given value.
     *
     * @param value the new {@code bool}'s value.
     *
     * @return a bool with
     * <code>{@link IonBool#booleanValue()} == value</code>.
     */
    public IonBool newBool(boolean value);


    /**
     * Constructs a new <code>bool</code> instance with the given value.
     *
     * @param value the new {@code bool}'s value.
     * may be {@code null} to make {@code null.bool}.
     */
    public IonBool newBool(Boolean value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.clob</code> instance.
     */
    public IonClob newNullClob();


    /**
     * Constructs a new Ion {@code clob} instance from a byte array.
     *
     * @param value the data for the new clob, to be <em>copied</em> from the
     * given array into the new instance.
     * May be {@code null} to create a {@code null.clob} value.
     */
    public IonClob newClob(byte[] value);


    /**
     * Constructs a new Ion {@code clob}, copying bytes from part of an array.
     * <p>
     * This method copies {@code length} bytes from the given array into the
     * new value, starting at the given offset in the array.
     *
     * @param value the data for the new blob, to be <em>copied</em> from the
     * given array into the new instance.
     * May be {@code null} to create a {@code null.clob} value.
     * @param offset the offset within the array of the first byte to copy;
     * must be non-negative an no larger than {@code bytes.length}.
     * @param length the number of bytes to be copied from the given array;
     * must be non-negative an no larger than {@code bytes.length - offset}.
     *
     * @throws IndexOutOfBoundsException
     * if the preconditions on the {@code offset} and {@code length} parameters
     * are not met.
     */
    public IonClob newClob(byte[] value, int offset, int length);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.decimal</code> instance.
     */
    public IonDecimal newNullDecimal();


    /**
     * Constructs a new Ion {@code decimal} instance from a Java
     * {@code long}.
     */
    public IonDecimal newDecimal(long value);


    /**
     * Constructs a new Ion {@code decimal} instance from a Java
     * {@code double}.
     */
    public IonDecimal newDecimal(double value);


    /**
     * Constructs a new Ion {@code decimal} instance from a Java
     * {@link BigInteger}.
     */
    public IonDecimal newDecimal(BigInteger value);


    /**
     * Constructs a new Ion {@code decimal} instance from a Java
     * {@link BigDecimal}.
     */
    public IonDecimal newDecimal(BigDecimal value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new {@code null.float} instance.
     */
    public IonFloat newNullFloat();


    /**
     * Constructs a new Ion {@code float} instance from a Java
     * {@code long}.
     */
    public IonFloat newFloat(long value);


    /**
     * Constructs a new Ion {@code float} instance from a Java
     * {@code double}.
     */
    public IonFloat newFloat(double value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.int</code> instance.
     */
    public IonInt newNullInt();


    /**
     * Constructs a new <code>int</code> instance with the given value.
     *
     * @param value the new int's value.
     */
    public IonInt newInt(int value);


    /**
     * Constructs a new <code>int</code> instance with the given value.
     *
     * @param value the new int's value.
     */
    public IonInt newInt(long value);


    /**
     * Constructs a new <code>int</code> instance with the given value.
     * The integer portion of the number is used, any fractional portion is
     * ignored.
     *
     * @param value the new int's value;
     * may be <code>null</code> to make <code>null.int</code>.
     */
    public IonInt newInt(Number value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.list</code> instance.
     */
    public IonList newNullList();


    /**
     * Constructs a new empty (not null) <code>list</code> instance.
     */
    public IonList newEmptyList();

    /**
     * Constructs a new <code>list</code> with given children.
     *
     * @param values
     *  the initial set of children.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *
     * @throws ContainedValueException
     *  if any value in {@code values}
     *  has <code>{@link IonValue#getContainer()} != null</code>.
     * @throws NullPointerException
     *   if any value in {@code values} is null.
     * @throws IllegalArgumentException
     *   if any value in {@code values} is an {@link IonDatagram}.
     */
    public IonList newList(Collection<? extends IonValue> values)
        throws ContainedValueException, NullPointerException;


    /**
     * Constructs a new <code>list</code> with given children.
     *
     * @param values
     *  the initial set of children.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *  If a value is Java <code>null</code>, its corresponding element in
     *  the result will be an {@link IonNull} value.
     *
     * @throws ContainedValueException
     *  if any value in {@code values}
     *  has <code>{@link IonValue#getContainer()} != null</code>.
     * @throws NullPointerException
     *   if any value in {@code values} is null.
     * @throws IllegalArgumentException
     *   if any value in {@code values} is an {@link IonDatagram}.
     */
    public <T extends IonValue> IonList newList(T... values)
        throws ContainedValueException, NullPointerException;


    /**
     * Constructs a new <code>list</code> with given <code>int</code> children.
     *
     * @param values
     *  the initial set of child values.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *  Otherwise, the resulting sequence will contain new {@link IonInt}s with
     *  the given values.
     *
     * @return a new list where each element is an {@link IonInt}.
     */
    public IonList newList(int[] values);


    /**
     * Constructs a new <code>list</code> with given <code>long</code> child
     * elements.
     *
     * @param values
     *  the initial set of child values.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *  Otherwise, the resulting sequence will contain new {@link IonInt}s with
     *  the given values.
     *
     * @return a new list where each element is an {@link IonInt}.
     */
    public IonList newList(long[] values);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.null</code> instance.
     */
    public IonNull newNull();


    /**
     * Constructs a new Ion null value with the given type.
     *
     * @param type must not be Java null, but it may be {@link IonType#NULL}.
     *
     * @return a new value such that {@link IonValue#isNullValue()} is
     * {@code true}.
     */
    public IonValue newNull(IonType type);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.sexp</code> instance.
     */
    public IonSexp newNullSexp();


    /**
     * Constructs a new empty (not null) <code>sexp</code> instance.
     */
    public IonSexp newEmptySexp();


    /**
     * Constructs a new <code>sexp</code> with given child elements.
     *
     * @param values
     *  the initial set of children.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *
     * @throws ContainedValueException
     *  if any value in {@code values}
     *  has <code>{@link IonValue#getContainer()} != null</code>.
     * @throws NullPointerException
     *   if any value in {@code values} is null.
     * @throws IllegalArgumentException
     *   if any value in {@code values} is an {@link IonDatagram}.
     */
    public IonSexp newSexp(Collection<? extends IonValue> values)
        throws ContainedValueException, NullPointerException;


    /**
     * Constructs a new <code>sexp</code> with given child elements.
     *
     * @param values
     *  the initial set of children.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *
     * @throws ContainedValueException
     *  if any value in {@code values}
     *  has <code>{@link IonValue#getContainer()} != null</code>.
     * @throws NullPointerException
     *   if any value in {@code values} is null.
     * @throws IllegalArgumentException
     *   if any value in {@code values} is an {@link IonDatagram}.
     */
    public <T extends IonValue> IonSexp newSexp(T... values)
        throws ContainedValueException, NullPointerException;


    /**
     * Constructs a new <code>sexp</code> with given <code>int</code> child
     * values.
     *
     * @param values
     *  the initial set of child values.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *  Otherwise, the resulting sequence will contain new {@link IonInt}s with
     *  the given values.
     *
     * @return a new sexp where each element is an {@link IonInt}.
     */
    public IonSexp newSexp(int[] values);


    /**
     * Constructs a new <code>sexp</code> with given <code>long</code> child
     * elements.
     *
     * @param values
     *  the initial set of child values.  If <code>null</code>, then the new
     *  instance will have <code>{@link IonValue#isNullValue()} == true</code>.
     *  Otherwise, the resulting sequence will contain new {@link IonInt}s with
     *  the given values.
     *
     * @return a new sexp where each element is an {@link IonInt}.
     */
    public IonSexp newSexp(long[] values);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.string</code> instance.
     */
    public IonString newNullString();


    /**
     * Constructs a new Ion string with the given value.
     *
     * @param value the text of the new string;
     * may be <code>null</code> to make <code>null.string</code>.
     */
    public IonString newString(String value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.struct</code> instance.
     */
    public IonStruct newNullStruct();


    /**
     * Constructs a new empty (not null) <code>struct</code> instance.
     */
    public IonStruct newEmptyStruct();


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.symbol</code> instance.
     */
    public IonSymbol newNullSymbol();


    /**
     * Constructs a new Ion symbol with the given value.
     *
     * @param value the text of the symbol;
     * may be <code>null</code> to make <code>null.symbol</code>.
     *
     * @throws EmptySymbolException if <code>value</code> is the empty string.
     */
    public IonSymbol newSymbol(String value);


    //-------------------------------------------------------------------------


    /**
     * Constructs a new <code>null.timestamp</code> instance.
     */
    public IonTimestamp newNullTimestamp();


    /**
     * Constructs a new <code>timestamp</code> instance with the given value.
     */
    public IonTimestamp newTimestamp(Timestamp value);
}