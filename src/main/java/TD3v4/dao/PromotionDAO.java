package TD3v4.dao;

import TD3v4.modele.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionDAO extends JpaRepository<Promotion, Integer> {
}
