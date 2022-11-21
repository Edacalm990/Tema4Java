/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fechas;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 *
 * @author elisabet
 */
public class EjemplosFechas {
    public static void main(String[] args) {
        // clase que guarda fechas (sin horas)
        LocalDate fechaHoy= LocalDate.now();
        System.out.println(fechaHoy);
        
        int anno= fechaHoy.getYear();
        System.out.println("Año: " + anno);
        
        int mes= fechaHoy.getMonthValue();
        System.out.println("Mes: " + mes);
        Month mesActual = fechaHoy.getMonth();
        System.out.println("Month: " + mesActual);
        
        // Fechas concretas
        LocalDate fecha = LocalDate.of(2000, 2, 29);
        LocalDate fecha2 = LocalDate.of(2022, Month.NOVEMBER, 10);
        System.out.println(fecha);
        System.out.println(fecha2);
        
        // Ver si dos fechas son iguales
        System.out.println(fecha.equals(fecha2));
        
        // anterior y posterior
        System.out.println("Es anterior? "+fecha.isBefore(fecha2));
        System.out.println("Es posterior? "+fecha.isAfter(fecha2));
        
        // CLase para guardar mes y dia (no el año)
        MonthDay nocheVieja = MonthDay.of(12  , 31);
        
        // Clase para guardar mes y año
        YearMonth caducidadTarjeta= YearMonth.of(22,    06);
        
        // Operaciones con fechas
        LocalDate sumarDias=fechaHoy.plusDays(100);
        System.out.println(sumarDias);
        LocalDate sumarMeses=fechaHoy.plusMonths(10);
        System.out.println(sumarMeses);
        LocalDate restarDias=fechaHoy.minusDays(100);
        System.out.println(restarDias);
        
        // sumar 2 decadas
        LocalDate sumarDecadas=sumarMeses.plus(2, ChronoUnit.DECADES);
        System.out.println(sumarDecadas);
        
        System.out.println(fecha);
        System.out.println(fecha2);
        long diferenciaDia=ChronoUnit.DAYS.between(fecha, fecha2);
        System.out.println("Dias de diferencia "+diferenciaDia);
        long annos= ChronoUnit.YEARS.between(fecha, fecha2);
        System.out.println("Años de diferencia "+annos);
        
        boolean bisiesto=fechaHoy.isLeapYear();
        System.out.println("""
                           la fecha %s es bisiesto? %b
                           """.formatted(fechaHoy, bisiesto));
        
        // dia del mes actual
        System.out.println("Dias del mes actual " + fechaHoy.lengthOfMonth());
        
        Locale configLocal=Locale.getDefault();
        System.out.println("Fechas hoy Día " + fechaHoy.getDayOfWeek().getDisplayName(TextStyle.FULL, configLocal));
        System.out.println("Fechas hoy Día " + fechaHoy.getDayOfWeek().getDisplayName(TextStyle.SHORT, configLocal));
        System.out.println("Fechas hoy Día " + fechaHoy.getDayOfWeek().getDisplayName(TextStyle.NARROW, configLocal));
        
        System.out.println("Fechas hoy Mes " + mesActual.getDisplayName(TextStyle.FULL, configLocal));
        System.out.println("Fechas hoy Mes " + mesActual.getDisplayName(TextStyle.SHORT, configLocal));
        System.out.println("Fechas hoy Mes " + mesActual.getDisplayName(TextStyle.NARROW, configLocal));
        
        // dd con dos numeritos
        // MM mes con dos numeritos
        // yyyy año
        DateTimeFormatter formatoFechas= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada= fechaHoy.format(formatoFechas);
        
        System.out.println(fechaFormateada);

    }
}
