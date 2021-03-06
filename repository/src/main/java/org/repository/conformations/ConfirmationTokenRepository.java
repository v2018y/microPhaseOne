package org.repository.conformations;



import org.domain.entity.token.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken , Integer> {
	ConfirmationToken findByconfirmationToken(String confirmationToken);
}
