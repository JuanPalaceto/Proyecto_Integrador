package test;

import dao.BD;
import dao.OdontologoDAOH2;
import dao.OdontologoDAOHashMap;
import dao.OdontologoDAOLista;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoServiceTest {
    @Test
    public void agregarOdontologo() {
        BD.crearTablas();

        OdontologoDAOH2 dao = new OdontologoDAOH2();
        OdontologoService odontologoService = new OdontologoService(dao);

        Odontologo odontologo = new Odontologo(123, "Juan", "Palaceto");
        odontologoService.guardarOdontologo(odontologo); // guarda en bd
        Odontologo odontologo1 = new Odontologo(124, "Juan", "P");
        odontologoService.guardarOdontologo(odontologo1); // guarda en bd

        // comprobar el id
        List<Odontologo> odontologoList = odontologoService.buscarTodos();
        for (Odontologo o : odontologoList) {
            System.out.println(o.getId() + ", " + o.getNombre());
        }

        OdontologoDAOLista dao1 = new OdontologoDAOLista();
        odontologoService.setOdontologoIDao(dao1);
        odontologoService.guardarOdontologo(odontologo); // guarda en lista

        // prueba del hashmap
        OdontologoDAOHashMap dao2 = new OdontologoDAOHashMap();
        odontologoService.setOdontologoIDao(dao2);
        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo);

        List<Odontologo> odontologoHash = odontologoService.buscarTodos();
        for (Odontologo o : odontologoHash) {
            System.out.println("matricula: " + o.getMatricula() + ". "  + o.getId() + ", " + o.getNombre());
        }

        Assertions.assertTrue(odontologo.getMatricula()!=0);
    }

    @Test
    public void buscarTodos() {
        BD.crearTablas();

        OdontologoDAOH2 dao = new OdontologoDAOH2();
        OdontologoService odontologoService = new OdontologoService(dao);

        Odontologo odontologo = new Odontologo(123, "Juan", "Palaceto");
        Odontologo odontologo1 = new Odontologo(124, "Luisa", "Valencia");
        Odontologo odontologo2 = new Odontologo(125, "Jorgito", "Pereyra");

        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        List<Odontologo> odontologoList = odontologoService.buscarTodos();

        for (Odontologo o : odontologoList) {
            System.out.println("Id: " + o.getId() + ", Nombre: " + o.getNombre() + ", Apellido: " + o.getApellido());
        }

        // prueba del hashmap
        OdontologoDAOHashMap dao2 = new OdontologoDAOHashMap();
        odontologoService.setOdontologoIDao(dao2);

        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo2);

        List<Odontologo> odontologoList1 = odontologoService.buscarTodos();

        for (Odontologo o : odontologoList1) {
            System.out.println("Id: " + o.getId() + ", Nombre: " + o.getNombre() + ", Apellido: " + o.getApellido());
        }

        Assertions.assertTrue(odontologoList.size() > 0);
    }
}
