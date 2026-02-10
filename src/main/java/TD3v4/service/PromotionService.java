package TD3v4.service;

import TD3v4.dao.PromotionDAO;
import TD3v4.modele.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private final PromotionDAO promotionDAO;

    PromotionService(final PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    public List<Promotion> getPromotions() {
        return promotionDAO.findAll();
    }

    public Promotion getPromotion(final Integer id) {
        return promotionDAO.findById(id).orElseThrow();
    }

    public Promotion ajouterPromotion(final Promotion promotion) {
        return promotionDAO.save(promotion);
    }
}
