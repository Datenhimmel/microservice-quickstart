package de.adesso.microservice.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.adesso.microservice.domain.Comment;
import de.adesso.microservice.domain.CommentRepository;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;

	@RequestMapping(value="/{articleID}", method=RequestMethod.GET)
	public List<Comment> getComments(@PathVariable String articleID) {
		return commentRepository.findByArticleID(articleID);
	}

	@RequestMapping(value="/{articleID}/{id}", method=RequestMethod.GET)
    public Comment getComment(@PathVariable String articleID, @PathVariable String id) {
		return commentRepository.findOne(id);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void addComment(@RequestBody Comment comment) {
    	comment.setCreatedOn(new Date());
    	commentRepository.save(comment);
    }
    
    @RequestMapping(value="/{articleID}/{id}", method=RequestMethod.DELETE)
    public void deleteComment(@PathVariable String articleID, @PathVariable String id) {
    	commentRepository.delete(id);
    }
}