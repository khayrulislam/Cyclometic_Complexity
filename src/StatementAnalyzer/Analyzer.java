package StatementAnalyzer;

import java.util.ArrayList;

import CommentAnalyzer.RemoveComments;
import FileReader.Statement;
import MethodAnalyzer.ExtractMethods;

public class Analyzer {

	ArrayList<Statement> statementListOfAClass;

	public Analyzer(ArrayList<Statement> statementListOfAClass) {
		this.statementListOfAClass = statementListOfAClass;
	}

	public void startStatementAnalysis() {

		RemoveComments rc = new RemoveComments(statementListOfAClass);
		rc.removeAllTheCommentFromStatementList();

		printStatements();
		
		ExtractMethods em = new ExtractMethods(statementListOfAClass);
		em.splitMethodsFromClass();
		
		printStatements();
	}

	public void printStatements() {

		for (Statement statement : statementListOfAClass)
			System.out.println(statement.getStatementLineNumber() + " " + statement.getStatement()+"----");

	}
}
