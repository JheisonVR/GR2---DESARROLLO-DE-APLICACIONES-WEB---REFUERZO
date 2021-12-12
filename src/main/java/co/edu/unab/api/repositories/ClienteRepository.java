package co.edu.unab.api.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    ArrayList<ClienteModel>findByNombre (String nombre);
    ArrayList<ClienteModel>findByNombreApellido (String nombre ,String apellido);

    @Query(value = "{'address.ciudad':?0}",fields="{'nombre':1,'apellido:1'}" )
    ArrayList<ClienteModel> clientePorCiudad(String ciudad);
    
    ArrayList<ClienteModel>findByPuntosGreaterThanEqual(long puntos);
    
    ArrayList<ClienteModel>findByPuntosLessThanEqual(long puntos);
    ArrayList<ClienteModel>findByFRegistroAfter(Date fecha);
    
    //LessThanEqual
      

}

