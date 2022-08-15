package tn.esprit.Service;

import tn.esprit.Entity.Comment;

import java.util.List;

public interface CommentService {

	

	Comment addComment(Comment c);

	void deleteComment(Long id);

	//Comment updateComment(Comment c);

	Comment retrieveComment(Long id);

	List<Comment> retrieveAllComments();


	int ajouterCommentaire(Comment c);

	void affecterSubjecttoComment(int idSubject, long idComment);

	Long countNbcomments();

	

	

}
