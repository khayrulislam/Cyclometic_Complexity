package StatementAnalyzer;

import java.util.ArrayList;

import CommentAnalyzer.RemoveComments;
import FileReader.Statement;

public class Analyzer {

	
	public void startStatementAnalysis(ArrayList<Statement> statementListOfAClass) {
		
		RemoveComments rc = new RemoveComments();
		rc.removeAllTheCommentFromStatementList(statementListOfAClass);
	}
	
	
}
