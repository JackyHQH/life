//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.TimeZone;
//
//public class objMapper {
//
//    public static class NumberToStringSerializer extends ToStringSerializer {
//        public NumberToStringSerializer() {
//        }
//
//        public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
//            if (value instanceof Number) {
//                String format = ObjectMapperCollection.NUMBER_FORMAT.format(value);
//                gen.writeString(format);
//            } else {
//                super.serialize(value, gen, provider);
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//         ObjectMapper MARMOT_SCRIPT_OBJECT_MAPPER = new ObjectMapper() {
//            {
//                this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//                this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//                this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//                SimpleModule numberModule = new SimpleModule();
//                numberModule.addSerializer(Number.class, ObjectMapperCollection.NumberToStringSerializer.instance);
//                this.registerModule(numberModule);
//                this.setTimeZone(TimeZone.getDefault());
//            }
//        };
//
//
//        System.out.println(bigDecimal);
//    }
//}
