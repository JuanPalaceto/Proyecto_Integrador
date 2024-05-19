package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OdontologoDAOHashMap implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOHashMap.class);
    private Map<Integer, Odontologo> odontologoMap;

    public OdontologoDAOHashMap() {
        odontologoMap = new HashMap<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        if (!odontologoMap.containsKey(odontologo.getMatricula())) {
            odontologo.setId(odontologoMap.size() + 1);

            odontologoMap.put(odontologo.getMatricula(), odontologo);
            logger.info("Se agregó el odontolog: " + odontologo.getMatricula() + ", " + odontologo.getNombre() + " " + odontologo.getApellido());
        }

        return odontologoMap.get(odontologo.getMatricula());
    }

    @Override
    public Odontologo buscarPorId(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Se consultaron odontologos de Hash");

        return new ArrayList<>(odontologoMap.values());
    }
}
