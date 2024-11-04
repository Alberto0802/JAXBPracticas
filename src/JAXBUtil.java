import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {

    // Método para serializar (marshal) un objeto Estudiante a un archivo XML
    public static <T> void marshal(T object, File file) throws JAXBException {
        // Crear un contexto JAXB para la clase del objeto
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, file);
    }

    // Método para deserializar (unmarshal) un archivo XML a un objeto Estudiante
    public static Estudiante unmarshal(File file) throws JAXBException {
        // Crear un contexto JAXB para la clase Estudiante
        JAXBContext context = JAXBContext.newInstance(Estudiante.class);
        // Crear un objeto Unmarshaller para convertir el XML a un objeto
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // Deserializar el archivo y devolver el objeto Estudiante
        return (Estudiante) unmarshaller.unmarshal(file);
    }

    public static Curso unmarshalCurso(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Curso.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Curso) unmarshaller.unmarshal(file);
    }

}
