import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

// Anotación para definir la clase como la raíz del documento XML
@XmlRootElement
public class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes;

    // Constructor sin argumentos necesario para JAXB
    public Curso() {
    }

    public Curso(String nombreCurso, List<Estudiante> estudiantes) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = estudiantes;
    }

    // Anotación para definir un elemento XML
    @XmlElement
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    // Anotación para agrupar la lista dentro de un contenedor XML
    @XmlElementWrapper(name = "estudiantes")
    @XmlElement(name = "estudiante")
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
