package com.wellsfargo.fsd.it.Controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.it.Entity.AttendeeEntity;
import com.wellsfargo.fsd.it.Entity.UserEntity;
import com.wellsfargo.fsd.it.exception.InterviewException;
import com.wellsfargo.fsd.it.exception.UserException;
import com.wellsfargo.fsd.it.service.AttendeeService;

@RestController
@RequestMapping("/Attendees")
public class AttendeeController {
	
	@Autowired
	private AttendeeService attendeeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<UserEntity>> getAllAttendees(@PathVariable("id") int interview)
	{
		return new ResponseEntity<List<UserEntity>>(attendeeService.getAllAttendees(interview),HttpStatus.OK);
		
	}
//	@PostMapping
//	public ResponseEntity<String> createAttendee(@RequestBody @Valid AttendeeEntity attendee,BindingResult result) throws UserException, InterviewException{
//		if(result.hasErrors()) {
//			throw new UserException(GlobalExceptionController.errMsgFrom(result));
//		}
////		return new ResponseEntity<>(attendeeService.add(attendee),HttpStatus.OK);
//		attendeeService.add(attendee);
//		return new ResponseEntity<String>("User has been applied to the interview successfully",HttpStatus.OK);
//	}

	@PostMapping
	public ResponseEntity<AttendeeEntity> createAttendee(@RequestBody @Valid AttendeeEntity attendee,BindingResult result) throws UserException, InterviewException{
		if(result.hasErrors()) {
			throw new UserException(GlobalExceptionController.errMsgFrom(result));
		}
//		return new ResponseEntity<>(attendeeService.add(attendee),HttpStatus.OK);
		
		return new ResponseEntity<AttendeeEntity>(attendeeService.add(attendee),HttpStatus.OK);
	}
	
}
