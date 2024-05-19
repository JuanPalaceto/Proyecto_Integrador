package service;

import dao.IDao;
import dao.PacienteDAOH2;
import model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    //metodos manuales
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorID(int id){
        return pacienteiDao.buscarPorId(id);
    }
}
