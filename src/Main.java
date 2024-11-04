import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Estudiante estudiante1 = new Estudiante("Juan", 20);
        Estudiante estudiante2 = new Estudiante("María", 22);
        Curso curso = new Curso("Matemáticas", Arrays.asList(estudiante1, estudiante2));

        // Serializar el objeto Curso a un archivo XML
        File file = new File("curso.xml");
        JAXBUtil.marshal(curso, file);

        // Deserializar el archivo XML a un objeto Curso
        Curso cursoDeserializado = JAXBUtil.unmarshalCurso(file);
        System.out.println("Nombre del curso: " + cursoDeserializado.getNombreCurso());
        for (Estudiante estudiante : cursoDeserializado.getEstudiantes()) {
            System.out.println("Estudiante: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
        }
    }
}
