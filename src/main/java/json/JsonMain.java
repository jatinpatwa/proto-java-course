package json;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class JsonMain {

    private static String toJSON(Simple message) throws InvalidProtocolBufferException {
        return JsonFormat.printer()
                .omittingInsignificantWhitespace()
                .print(message);
    }

    private static Simple fromJSON(String json) throws InvalidProtocolBufferException {
        Simple.Builder builder = Simple.newBuilder();

        JsonFormat.parser().merge(json, builder);

        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple message = Simple.newBuilder()
                .setId(42)
                .setName("A Name")
                .setIsSimple(true)
                .addAllSimpleList(Arrays.asList(1, 2, 3))
                .build();

        String json = toJSON(message);

        System.out.println(json);
        System.out.println(fromJSON(json));

    }
}
