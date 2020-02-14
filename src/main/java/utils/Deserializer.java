package utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

////public class Deserializer extends StdDeserializer<JsonPojo> {
//
//    private static final long serialVersionUID = 1883547683050039861L;
//
//    public Deserializer() {
//        this(null);
//    }
//
//    public Deserializer(final Class<?> vc) {
//        super(vc);
//    }
//
//    /**
//     * {"id":1,"itemNr":"theItem","owner":2}
//     */
////    @Override
////    public JsonPojo deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
////        final JsonNode node = jp.getCodec()
////            .readTree(jp);
////        final int id = (Integer) ((IntNode) node.get("userId")).numberValue();
////        final String Name = node.get("name")
////            .asText();
////        final int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
////
//// //       return new JsonPojo(id, Name, new Role(userId, null, "name"));
////    }
//
//}