package pe.edu.upc.avinka.service.crud.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.avinka.model.entity.Feedback;
import pe.edu.upc.avinka.model.repository.FeedbackRepository;
import pe.edu.upc.avinka.service.crud.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private FeedbackRepository feedbackRepository;
	
	@Override
	public JpaRepository<Feedback, Integer> getRepository() {
		
		return feedbackRepository;
	}

}
