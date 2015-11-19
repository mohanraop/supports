package support.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.AssignDao;
import support.domain.entity.AssignDetails;
@Service("assignService")
@Transactional
public class AssignServiceImpl implements AssignService {
	

	@Resource(name = "assignDao")
	private AssignDao assignDao; 
	
	@Override
	public void create(AssignDetails assignDetails) {
		assignDao.save(assignDetails);
	}
	
	@Override
	public List<AssignDetails> findAll() {
		return assignDao.findAll();
	}

}
