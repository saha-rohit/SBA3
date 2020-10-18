package com.wellsfargo.fsd.it.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.it.Entity.AttendeeEntity;
import com.wellsfargo.fsd.it.Entity.InterviewEntity;
import com.wellsfargo.fsd.it.Entity.UserEntity;
import com.wellsfargo.fsd.it.dao.Attendeedao;
import com.wellsfargo.fsd.it.dao.Interviewdao;
import com.wellsfargo.fsd.it.dao.Userdao;
import com.wellsfargo.fsd.it.exception.InterviewException;
import com.wellsfargo.fsd.it.exception.UserException;
@Service
public class AttendeeServiceimpl implements AttendeeService{
	
	@Autowired
	private Attendeedao attendeedao;
	
	@Autowired
	private Interviewdao interviewdao;
	
	@Autowired
	private Userdao userdao;
	
	

	@Override
	@Transactional
	public AttendeeEntity add(AttendeeEntity attendee) throws UserException, InterviewException {
		// TODO Auto-generated method stub
		
		if (attendee!=null)
		{
			if (attendeedao.existsById(attendee.getAttendeeId()))
			{
				throw new InterviewException("Attendee id already exists");
			}
			
			if (!userdao.existsById(attendee.getUser().getUserId()))
			{
				throw new UserException("User doesn't exists");
			}
			if (!interviewdao.existsById(attendee.getInterview().getInterviewId()))
			{
				throw new InterviewException("Interview id doesn't exists");
			}
			List<UserEntity> entities=null;
			entities=attendeedao.findAllinterviewId(attendee.getInterview());
			//entities=attendeedao.findAll();
//			System.out.println(entities.size());
			for(UserEntity e:entities)
			{
//				System.out.println(e);
				if (e.getUserId()==attendee.getUser().getUserId())
				{
					throw new InterviewException("User has already been added to this interview");
				}
			}
			
			
			UserEntity usertoadd=attendee.getUser();
			InterviewEntity interviewtoadd=attendee.getInterview();
			
			attendee.setUser(usertoadd);
			attendee.setInterview(interviewtoadd);
			System.out.println(usertoadd.getAttendees().size());
			usertoadd.getAttendees().add(attendee);
			System.out.println(usertoadd.getAttendees().size());
			//InterviewEntity i=null;
			interviewtoadd.getAttendees().add(attendee);			
			attendeedao.save(attendee);		
			
			
			
		}
		return attendee;
	}

	@Override
	public List<UserEntity> getAllAttendees(int interview) {
		List<UserEntity> entities=null;
		InterviewEntity i=interviewdao.findById(interview).orElse(null);
		System.out.println(i);
		if (i!=null)
		{
			entities=attendeedao.findAllinterviewId(i);
		}
			System.out.println(entities);
		return entities;
		
		//return attendeedao.findAll();
		// TODO Auto-generated method stub
	
	}

}
