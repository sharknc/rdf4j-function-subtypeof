package com.ncc.verdi.rdf.rdf4j.function;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
        SubtypeFunction stf = new SubtypeFunction();
        String subtype = stf.getSubtype(label);

        Assert.assertEquals("type.subtype", subtype);
    }
}
