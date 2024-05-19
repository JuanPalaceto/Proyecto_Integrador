package service;

import dao.IDao;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;

import java.util.List;

public class ClinicaService {
    private IDao<Paciente> pacienteIDao;
    private IDao<Domicilio> domicilioIDao;
    private IDao<Odontologo> odontologoIDao;

    public ClinicaService(IDao<Paciente> pacienteIDao, IDao<Domicilio> domicilioIDao, IDao<Odontologo> odontologoIDao) {
        this.pacienteIDao = pacienteIDao;
        this.domicilioIDao = domicilioIDao;
        this.odontologoIDao = odontologoIDao;
    }

    public ClinicaService() {
        this.pacienteIDao = null;
        this.domicilioIDao = null;
        this.odontologoIDao = null;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public void setDomicilioIDao(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Paciente guardarPaciente(Paciente paciente) throws Exception {
        if (pacienteIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarPacientePorID(int id) throws Exception {
        if (pacienteIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        return pacienteIDao.buscarPorId(id);}
    public void eliminarPaciente(int id) throws Exception {
        if (pacienteIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        pacienteIDao.eliminar(id); }
    public void actualizarPaciente(Paciente paciente) throws Exception {
        if (pacienteIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        pacienteIDao.actualizar(paciente);
    }
    public List<Paciente> buscarTodosPacientes() throws Exception {
        if (pacienteIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        return pacienteIDao.buscarTodos();}

    public Domicilio guardarDomicilio(Domicilio domicilio) throws Exception {
        if (domicilioIDao == null) {
            throw new Exception("No se ha inicializado el DAO de paciente.");
        }

        return domicilioIDao.guardar(domicilio);
    }
    public Domicilio buscarDomicilioPorID(int id) throws Exception {
        if (domicilioIDao == null) {
            throw new Exception("No se ha inicializado el DAO de domicilio.");
        }

        return domicilioIDao.buscarPorId(id);
    }
    public void eliminarDomicilio(int id) throws Exception {
        if (domicilioIDao == null) {
            throw new Exception("No se ha inicializado el DAO de domicilio.");
        }

        domicilioIDao.eliminar(id);
    }
    public void actualizarDomicilio(Domicilio domicilio) throws Exception {
        if (domicilioIDao == null) {
            throw new Exception("No se ha inicializado el DAO de domicilio.");
        }
        domicilioIDao.actualizar(domicilio);
    }
    public List<Domicilio> buscarTodosPDomicilios() throws Exception {
        if (domicilioIDao == null) {
            throw new Exception("No se ha inicializado el DAO de domicilio.");
        }

        return domicilioIDao.buscarTodos();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) throws Exception {
        if (odontologoIDao == null) {
            throw new Exception("No se ha inicializado el DAO de odontologo.");
        }

        return odontologoIDao.guardar(odontologo);
    }
    public Odontologo buscarOdontologoPorID(int id) throws Exception {
        if (odontologoIDao == null) {
            throw new Exception("No se ha inicializado el DAO de odontologo.");
        }

        return odontologoIDao.buscarPorId(id);
    }
    public void eliminarOdontologo(int id) throws Exception {
        if (odontologoIDao == null) {
            throw new Exception("No se ha inicializado el DAO de odontologo.");
        }

        odontologoIDao.eliminar(id);
    }
    public void actualizarOdontologo(Odontologo odontologo) throws Exception {
        if (odontologoIDao == null) {
            throw new Exception("No se ha inicializado el DAO de odontologo.");
        }

        odontologoIDao.actualizar(odontologo); }
    public List<Odontologo> buscarTodosOdontologo() throws Exception {
        if (odontologoIDao == null) {
            throw new Exception("No se ha inicializado el DAO de odontologo.");
        }

        return odontologoIDao.buscarTodos();
    }
}















