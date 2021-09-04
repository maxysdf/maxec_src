package idv.maxy.maxec.app.frontend.graphql.type;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Component
public class GraphQLDate extends GraphQLScalarType {

	private static final String DEFAULT_NAME = "Date";
	
    public GraphQLDate() {
        this(DEFAULT_NAME);
    }
	
	@SuppressWarnings("deprecation")
	public GraphQLDate(String name) {
		super(name, "Date type", new Coercing<Date, String>() {

			private static final String PATTERN = "yyyy/MM/dd HH:mm:ss";
			
            private Date convertImpl(Object input) {
                if (input instanceof String) {
                	try {
                		return new SimpleDateFormat(PATTERN).parse((String) input);
                	} catch(Exception ex) { }
                }
                return null;
            }
            
			@Override
			public String serialize(Object input) throws CoercingSerializeException {
                if (input instanceof Date) {
                	return new SimpleDateFormat(PATTERN).format((Date) input);
                } else {
                    Date result = convertImpl(input);
                    if (result == null) {
                        throw new CoercingSerializeException("Invalid value '" + input + "' for Date");
                    }
                    return (String) input;
                }
			}

			@Override
			public Date parseValue(Object input) throws CoercingParseValueException {
                Date result = convertImpl(input);
                if (result == null) {
                    throw new CoercingParseValueException("Invalid value '" + input + "' for Date");
                }
                return result;
			}

			@Override
			public Date parseLiteral(Object input) throws CoercingParseLiteralException {
                if (!(input instanceof StringValue)) return null;
                String value = ((StringValue) input).getValue();
                Date result = convertImpl(value);
                return result;
			}

		});
	}
}
