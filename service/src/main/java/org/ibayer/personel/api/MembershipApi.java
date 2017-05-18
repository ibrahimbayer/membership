package org.ibayer.personel.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.ibayer.personel.model.Person;
import org.ibayer.personel.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ibrahim.bayer
 *
 * Api class to perform restful operations over {@link Person} resource.
 */
@RestController
@RequestMapping("/memberships")
public class MembershipApi {

	@Autowired
	PersonRepository personRepository;

	/**
	 * Saves a new membership with person data. 
	 * @param person The resource to be saved.
	 * @return response entity of saved {@link Person} with latest status including applicable operation links
	 */
	@ApiOperation(notes = "Saves a new membership", value = "Creates a new membership", nickname = "post_Membership", tags = {
			"Membership" })
	@ApiResponses({ @ApiResponse(code = 201, message = "Nice!", response = Person.class),
			@ApiResponse(code = 400, message = "Membership save failed", response = Person.class),
			@ApiResponse(code = 500, message = "Membership save failed (internal system error)", response = Person.class)})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Resource<Person>> insert(@Valid @ApiParam(value="Membership")@RequestBody Person person) {
		Resource<Person> body = new Resource<>(personRepository.save(person));
		body.add(linkTo(methodOn(MembershipApi.class).get(body.getContent().getId())).withSelfRel());
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	/**
	 * Gets membership identified by id. The links of process is listed inside response.
	 * @param id identity of membership
	 * @return response entity of {@link Person} resource
	 */
	@ApiOperation(notes = "Gets existing membership", nickname = "get_Membership", tags = {
	"Membership" }, value = "Gets existing membership")
	@ApiResponses({ @ApiResponse(code = 202, message = "Done!", response = Person.class),
			@ApiResponse(code = 400, message = "Membership get failed", response = Person.class),
			@ApiResponse(code = 500, message = "Membership get failed (internal system error)", response = Person.class)})
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource<Person>> get(@PathVariable Long id){
		Person person = personRepository.findOne(id);
		Resource<Person> body = new Resource<Person>(person);
		body.add(linkTo(methodOn(MembershipApi.class).get(body.getContent().getId())).withSelfRel());
		return new ResponseEntity<Resource<Person>>(body,HttpStatus.OK);
	}

}
