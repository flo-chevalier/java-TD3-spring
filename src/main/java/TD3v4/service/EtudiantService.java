package TD3v4.service;

import TD3v4.dao.EtudiantDAO;
import TD3v4.modele.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    EtudiantService(final EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public List<Etudiant> getEtudiants() {
        return etudiantDAO.findAll();
    }

    public Etudiant getEtudiant(final Integer id) {
        return etudiantDAO.findById(id).orElseThrow();
    }

    public Etudiant ajouter(final Etudiant etudiant) {
        return etudiantDAO.save(etudiant);
    }
}
