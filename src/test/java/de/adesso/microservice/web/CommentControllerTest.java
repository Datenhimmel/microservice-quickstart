package de.adesso.microservice.web;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import de.adesso.microservice.Application;
import de.adesso.microservice.domain.Comment;
import de.adesso.microservice.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@WebAppConfiguration
public class CommentControllerTest {

	private String url = "http://localhost:8080/comments";
	private RestTemplate restTemplate = new RestTemplate();
	private ParameterizedTypeReference<List<Comment>> responseType = new ParameterizedTypeReference<List<Comment>>() {
	};

	/**
	 * Test nur bei im Hintergrund laufender MongoDB ausführbar. 
	 */
	@Test
	public void testAddCommentAndGetCommentsAndDeleteComment() {
		
		// Test-Kommentar-Objekt zusammenstellen
		String id = "1";
		String title = "TestTitel";
		String articleId = "testArtikel";
		String content = "testKommentartext";

		Comment testComment = new Comment();
		testComment.setArticleID(articleId);
		testComment.setId(id);
		testComment.setTitle(title);
		testComment.setContent(content);
		testComment.setAuthor(new User());
		
		// Test-Kommentar-Objekt "POST"en
		restTemplate.postForEntity(url, testComment, Comment.class);
		
		// Vorhandene Kommentare via GET anfragen
		ResponseEntity<List<Comment>> responseFromGet = restTemplate.exchange(
				url + "/" + articleId, HttpMethod.GET, null, responseType);

		List<Comment> commentList = responseFromGet.getBody();
		String statusCode = responseFromGet.getStatusCode().toString();

		// Vergleich des angelegten Test-Kommentar-Objekts mit dem
		// via REST GET erhaltenen Antwort-Kommentar
		assertThat(statusCode, equalTo(String.valueOf(200)));
		assertThat(commentList.get(0).getId(), equalTo(id));
		assertThat(commentList.get(0).getTitle(), equalTo(title));
		assertThat(commentList.get(0).getContent(), equalTo(content));
		
		// Löschen des Test-Kommentars
		restTemplate.delete(url + "/" + articleId + "/" + id);
		
		// Prüfen, ob Kommentar gelöscht wurde.
		ResponseEntity<List<Comment>> responseAfterDelete = restTemplate
				.exchange(url + "/" + articleId + "/" + id, HttpMethod.GET,
						null, responseType);
		assertThat(responseAfterDelete.getBody(), equalTo(null));
	}
}
