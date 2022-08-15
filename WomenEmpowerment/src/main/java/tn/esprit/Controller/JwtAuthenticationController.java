package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tn.esprit.config.JwtTokenUtil;
import tn.esprit.Response.JwtRequest;
import tn.esprit.Response.JwtResponse;
import tn.esprit.security.JwtUserDetailsService;
import tn.esprit.Service.IEmailService;
import tn.esprit.Service.IUserService;

@RestController
@CrossOrigin(origins="*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	IUserService us;
	
	@Autowired
	IEmailService es;
	
	@Autowired
	private JavaMailSender jms;
	

	// http://localhost:9091/SpringMVC/servlet/authenticate
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		final String name = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok(new JwtResponse(token,userDetails.getUsername(),userDetails.getAuthorities()));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
}
