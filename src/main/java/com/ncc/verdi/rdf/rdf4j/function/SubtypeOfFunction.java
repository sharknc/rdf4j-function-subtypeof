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

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

/**
 * RDF4J subtypeOf custom FILTER function implementation
 */
public class SubtypeOfFunction implements Function {

    // define a constant for the namespace of our custom function
    public static final String NAMESPACE = "https://tac.nist.gov/custom-function/";

    /**
     * return the URI 'https://tac.nist.gov/custom-function/' as a
     * String
     */
    public String getURI() {
        return NAMESPACE + "subtypeOf";
    }

    /**
     * Executes the subtypeof function.
     *
     * @return A boolean literal representing true if the input argument is a
     *         subtype of the key, false otherwise.
     * @throws ValueExprEvaluationException
     *         if more or less than two arguments are supplied or if the supplied arguments
     *         are not literals.
     */
    public Value evaluate(ValueFactory valueFactory, Value... args)
            throws ValueExprEvaluationException
    {
        // our subtypeOf function expects two arguments
        if (args.length != 2) {
            throw new ValueExprEvaluationException(
                    "subtypeOf function requires"
                            + "exactly two argument, got "
                            + args.length);
        }

        Value arg1 = args[0];
        Value arg2 = args[1];
        // check if the argument is a literal, if not, we throw an error
        if (!(arg1 instanceof Literal) || !(arg2 instanceof Literal)) {
            throw new ValueExprEvaluationException(
                    "invalid argument (literal expected)");
        }

        // get the actual string vale of object to be checked
        String type = ((Literal)arg1).getLabel();
        String target = ((Literal)arg2).getLabel();

        // check if object is subtype of type
        boolean isSubtype = isSubtypeOf(type, target);

        // a function is always expected to return a Value object, so we
        // return our boolean result as a Literal
        return valueFactory.createLiteral(isSubtype);
    }

    /**
     * Will
     * @param type
     * @param target
     * @return
     */
    public boolean isSubtypeOf(String type, String target) {

        //validate parameters
        if( type != null && target != null && !type.isEmpty() && !target.isEmpty() ) {

            String[] typeArr = type.split(".");
            String[] targetArr = target.split(".");
        }

        return false;
    }
}
