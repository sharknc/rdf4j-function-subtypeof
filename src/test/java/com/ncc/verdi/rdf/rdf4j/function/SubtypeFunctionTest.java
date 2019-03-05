package com.ncc.verdi.rdf.rdf4j.function;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SubtypeFunctionTest {


    /**
     *
     */
    @Test
    public void getSubtype() {

        String label = "type.subtype.subsubtype";
        SubtypeOfFunction stf = new SubtypeOfFunction();
        String subtype = stf.getSubtype(label);

        Assert.assertEquals("type.subtype", subtype);
    }
}
