package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        PreparedStatement preparedStatement = null;

        try {
            Connection connection = BD.getConnection();

            // 2 Crear la sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            // Ejecutar la sentencia
            preparedStatement.executeUpdate();

            logger.info("Odontologo guardado en base de datos: " + odontologo.getId());

            preparedStatement.close();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return odontologo;
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
    public List buscarTodos() {
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();

        try {
            // 1 Levantar el drive y conectarnos
            Connection connection = BD.getConnection();

            // 2 Crear la sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            // Ejecutar la sentencia
            ResultSet set = preparedStatement.executeQuery();

            // 4 evaluar los resultados
            while(set.next()) {
                int id = set.getInt(1);
                int matricula = set.getInt(2);
                String nombre = set.getString(3);
                String apellido = set.getString(4);

                Odontologo odontologo = new Odontologo(id, matricula, nombre, apellido);

                odontologos.add(odontologo);
            }

            logger.info("Se consultaron odontologos de base de datos.");

            preparedStatement.close();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return odontologos;
    }
}










