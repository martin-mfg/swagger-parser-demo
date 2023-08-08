package org.example;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

public class Main {
    public static void main(String[] args) {
        parseOpenApi("/input1.yaml"); // prints [DOG, FISH]
        parseOpenApi("/input2.yaml"); // prints ["DOG","FISH"]
    }

    private static void parseOpenApi(final String input) {
        final String inputUrl = Main.class.getResource(input).toString();
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = new OpenAPIParser().readLocation(inputUrl, null, options);
        System.out.println(
                result.getOpenAPI().getComponents().getParameters().entrySet().iterator().next().getValue().getSchema().getDefault()
        );
    }
}
