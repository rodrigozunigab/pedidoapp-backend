package cl.zuniga.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.ResetToken;



public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
