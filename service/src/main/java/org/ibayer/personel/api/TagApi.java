package org.ibayer.personel.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.ibayer.personel.model.Tag;
import org.ibayer.personel.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagApi {
	
	@Autowired
	TagRepository repository;
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource<Tag>> getTag(@PathVariable Long id){
		Resource<Tag> body = new Resource<Tag>(repository.findOne(id));
		body.add(linkTo(methodOn(TagApi.class).getTag(body.getContent().getId())).withSelfRel());
		return new ResponseEntity<Resource<Tag>>(body,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Resources<Tag>> getTags(@RequestParam String label){
		List<Tag> data = repository.findByLabel(label);
		Resources<Tag> body = new Resources<>(data);
		body.add(linkTo(methodOn(TagApi.class).getTags(label)).withSelfRel());
		//body.forEach(tag->tag.);
		return new ResponseEntity<Resources<Tag>>(body,HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Resource<Tag>> insert(@RequestBody Tag tag){
		Resource<Tag> body = new Resource<>(repository.save(tag));
		body.add(linkTo(methodOn(TagApi.class).getTag(body.getContent().getId())).withSelfRel());
		return new ResponseEntity<Resource<Tag>>(body,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Resource<Tag>> update(@RequestBody Tag tag){
		Resource<Tag> body = new Resource<Tag>(repository.save(tag));
		body.add(linkTo(methodOn(TagApi.class).getTag(body.getContent().getId())).withSelfRel());
		return new ResponseEntity<Resource<Tag>>(body, HttpStatus.OK);
		
	}

}
