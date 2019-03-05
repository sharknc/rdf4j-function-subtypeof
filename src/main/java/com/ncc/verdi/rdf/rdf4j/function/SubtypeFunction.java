package com.ncc.verdi.rdf.rdf4j.function;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

/**
 *
 */
public class SubtypeFunction implements Function {
    // define a constant for the namespace of our custom function
    public static final String NAMESPACE = "http://example.org/custom-function/";

    /**
     * return the URI 'http://example.org/custom-function/palindrome' as a
     * String
     */
    public String getURI() {
        return NAMESPACE + "subtype";
    }

    /**
     * Executes the palindrome function.
     *
     * @return A boolean literal representing true if the input argument is a
     *         palindrome, false otherwise.
     * @throws ValueExprEvaluationException
     *         if more than one argument is supplied or if the supplied argument
     *         is not a literal.
     */
    public Value evaluate(ValueFactory valueFactory, Value... args)
            throws ValueExprEvaluationException
    {
        // our palindrome function expects only a single argument, so throw an error
        // if there's more than one
        if (args.length != 1) {
            throw new ValueExprEvaluationException(
                    "palindrome function requires"
                            + "exactly 1 argument, got "
                            + args.length);
        }

        Value arg = args[0];
        // check if the argument is a literal, if not, we throw an error
        if (!(arg instanceof Literal)) {
            throw new ValueExprEvaluationException(
                    "invalid argument (literal expected): " + arg);
        }

        // get the actual string value that we want to check for palindrome-ness.
        String label = ((Literal)arg).getLabel();

        // extract the subtype
        String subtype = getSubtype(label);

        // a function is always expected to return a Value object, so we
        // return our boolean result as a Literal
        return valueFactory.createLiteral(subtype);
    }

    /**
     *
     * @param label
     * @return
     */
    public String getSubtype(String label) {
        return label.substring(0,label.indexOf(".",label.indexOf(".") + 1 ));
    }
}
