/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.java.spi.messages.items;

import org.apache.plc4x.java.api.exceptions.PlcIncompatibleDatatypeException;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DefaultShortFieldItem extends BaseDefaultFieldItem<Short> {

    public DefaultShortFieldItem(Short... values) {
        super(values);
    }

    @Override
    public Object getObject(int index) {
        return getValue(index);
    }

    @Override
    public boolean isValidBoolean(int index) {
        return getValue(index) != null;
    }

    @Override
    public Boolean getBoolean(int index) {
        if (!isValidBoolean(index)) {
            throw new PlcIncompatibleDatatypeException(Boolean.class, index);
        }
        return getValue(index) != 0L;
    }

    @Override
    public boolean isValidByte(int index) {
        Short value = getValue(index);
        return (value != null) && (value <= Byte.MAX_VALUE) && (value >= Byte.MIN_VALUE);
    }

    @Override
    public Byte getByte(int index) {
        if (!isValidByte(index)) {
            throw new PlcIncompatibleDatatypeException(Byte.class, index);
        }
        return getValue(index).byteValue();
    }

    @Override
    public boolean isValidShort(int index) {
        return getValue(index) != null;
    }

    @Override
    public Short getShort(int index) {
        if (!isValidShort(index)) {
            throw new PlcIncompatibleDatatypeException(Short.class, index);
        }
        return getValue(index);
    }

    @Override
    public boolean isValidInteger(int index) {
        return isValidShort(index);
    }

    @Override
    public Integer getInteger(int index) {
        if (!isValidInteger(index)) {
            throw new PlcIncompatibleDatatypeException(Integer.class, index);
        }
        return getValue(index).intValue();
    }

    @Override
    public boolean isValidLong(int index) {
        return isValidShort(index);
    }

    @Override
    public Long getLong(int index) {
        if (!isValidLong(index)) {
            throw new PlcIncompatibleDatatypeException(Long.class, index);
        }
        return getValue(index).longValue();
    }

    public boolean isValidBigInteger(int index) {
        return isValidShort(index);
    }

    public BigInteger getBigInteger(int index) {
        if (!isValidBigInteger(index)) {
            throw new PlcIncompatibleDatatypeException(BigInteger.class, index);
        }
        return BigInteger.valueOf(getValue(index));
    }

    @Override
    public boolean isValidFloat(int index) {
        return isValidShort(index);
    }

    @Override
    public Float getFloat(int index) {
        if (!isValidFloat(index)) {
            throw new PlcIncompatibleDatatypeException(Float.class, index);
        }
        return getValue(index).floatValue();
    }

    @Override
    public boolean isValidDouble(int index) {
        return isValidShort(index);
    }

    @Override
    public Double getDouble(int index) {
        if (!isValidDouble(index)) {
            throw new PlcIncompatibleDatatypeException(Double.class, index);
        }
        return getValue(index).doubleValue();
    }

    public boolean isValidBigDecimal(int index) {
        return isValidShort(index);
    }

    public BigDecimal getBigDecimal(int index) {
        if(!isValidBigDecimal(index)) {
            throw new PlcIncompatibleDatatypeException(BigDecimal.class, index);
        }
        return new BigDecimal(getValue(index));
    }
}
