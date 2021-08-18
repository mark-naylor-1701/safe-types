// author: Mark W. Naylor
// file:  WaterTemperature.java
// date:  2021-Aug-08

package org.mark_naylor_1701.safe_types;

import static org.mark_naylor_1701.safe_types.Water.freezingPoint;
import static org.mark_naylor_1701.safe_types.Water.boilingPoint;

public class WaterTemperature extends  Celsius {
    static private final String freezeMsg = "Temperature below freezing point; 0.0";
    static private final String boilMsg = "Temperature above boiling point; 100.0.";

    public WaterTemperature(Double val) {
        super(val);
        assert val >= freezingPoint : freezeMsg;
        assert val <= boilingPoint : boilMsg;
    }

    public WaterTemperature(Celsius val) {
        super(val.getValue());
        assert val.getValue().doubleValue() >= freezingPoint : freezeMsg;
        assert val.getValue().doubleValue() <= boilingPoint : boilMsg;
    }

    @Override
    public WaterTemperature add(Celsius that) {
        return new WaterTemperature(super.add(that));
    }

    @Override
    public WaterTemperature subtract(Celsius that) {
        return new WaterTemperature(super.subtract(that));
    }
}

// ------------------------------------------------------------------------------
// BSD 3-Clause License

// Copyright © 2021, Mark W. Naylor
// All rights reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:

// 1. Redistributions of source code must retain the above copyright notice, this
//    list of conditions and the following disclaimer.

// 2. Redistributions in binary form must reproduce the above copyright notice,
//    this list of conditions and the following disclaimer in the documentation
//    and/or other materials provided with the distribution.

// 3. Neither the name of the copyright holder nor the names of its
//    contributors may be used to endorse or promote products derived from
//    this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
