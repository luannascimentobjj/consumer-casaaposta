package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
