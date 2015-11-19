package support.service;

import java.util.List;

import support.domain.entity.AssignDetails;

public interface AssignService {

	void create(AssignDetails assignDetails);

	List<AssignDetails> findAll();

}
