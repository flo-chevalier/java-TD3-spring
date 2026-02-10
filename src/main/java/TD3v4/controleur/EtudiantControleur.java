package TD3v4.controleur;

import TD3v4.erreur.Erreur;
import TD3v4.modele.Etudiant;
import TD3v4.service.EtudiantService;
import TD3v4.service.PromotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
@RequestMapping("/etudiants")
public class EtudiantControleur {

    private final EtudiantService etudiantService;
    private final PromotionService promotionService;

    public EtudiantControleur(final EtudiantService etudiantService, final PromotionService promotionService) {
        this.etudiantService = etudiantService;
        this.promotionService = promotionService;
    }

    @GetMapping
    public String lister(final Model model) {
        model.addAttribute("etudiants", etudiantService.getEtudiants());
        return "etudiants/liste";
    }

    @GetMapping("/{id}")
    public String detail(final @PathVariable Integer id, final Model model) {
        model.addAttribute("etudiant", etudiantService.getEtudiant(id));
        return "etudiants/detail";
    }

    @GetMapping("/nouveau")
    public String formulaire(final Model model) {
        model.addAttribute("etudiant", new Etudiant());
        model.addAttribute("promotions", promotionService.getPromotions());
        return "etudiants/formulaire";
    }

    @PostMapping
    public String creer(final @ModelAttribute Etudiant etudiant, final Model model) {
        final var erreurs = new HashSet<Erreur>();
        if (etudiant.getPrenom() == null || etudiant.getPrenom().isBlank()) {
            erreurs.add(new Erreur("Prénom est obligatoire"));
        }
        if (etudiant.getNom() == null || etudiant.getNom().isBlank()) {
            erreurs.add(new Erreur("Nom est obligatoire"));
        }
        if (etudiant.getPromotion() == null) {
            erreurs.add(new Erreur("Promotion est obligatoire"));
        }

        if (!erreurs.isEmpty()) {
            model.addAttribute("erreurs", erreurs);
            model.addAttribute("etudiant", etudiant);
            model.addAttribute("promotions", promotionService.getPromotions());
            return "etudiants/formulaire";
        }

        try {
            etudiantService.ajouter(etudiant);
            return "redirect:/etudiants";
        } catch (Exception e) {
            erreurs.add(new Erreur(e.getMessage()));
            model.addAttribute("erreurs", erreurs);
            model.addAttribute("etudiant", etudiant);
            model.addAttribute("promotions", promotionService.getPromotions());
            return "etudiants/formulaire";
        }
    }
}
