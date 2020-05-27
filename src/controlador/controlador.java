package controlador;
import arch_excel.Excel;
import java.util.Calendar;

public class Controlador {
   private Excel excel = new Excel();
   
    public String obtenerDiaString()
    {
        Calendar cal = Calendar.getInstance();
        String fechaActual=String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"-"+String.valueOf(cal.get(Calendar.MONTH))+"-"+String.valueOf(cal.get(Calendar.YEAR));
        String nombreArch = fechaActual+".xlsx";
        return nombreArch;
    }
    public void genearArchivo(String [][]contenido)
    {
        String nombreArch = obtenerDiaString();
        String rutaArchivo = "C:\\Ficheros-Excel\\"+nombreArch;
        String cabecera [] = {"Tiempo","Temperatura","Promedio"}; 
        excel.Escribir(nombreArch,rutaArchivo,cabecera,contenido);
    }
}
