/*
 * Copyright 2019 Next Century Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ncc.verdi.rdf.rdf4j.function;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SubtypeOfFunctionTest {


    /**
     *
     */
    @Test
    public void isSubtypeOf() {

        String predicate = "ldcOnt:PER.MilitaryPersonnel.MilitaryOfficer";
        SubtypeOfFunction stf = new SubtypeOfFunction();
        String subtype = stf.getSubtype(label);

        Assert.assertEquals("type.subtype", subtype);
    }
}
