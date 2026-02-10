package TD3v4.dao;

import TD3v4.modele.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO de Etudiant.
 */
@Repository
public interface EtudiantDAO extends JpaRepository<Etudiant, Integer> {
}
