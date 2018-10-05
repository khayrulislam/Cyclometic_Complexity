package ComplexityAnalyzer;

import java.util.ArrayList;

import CodingConventionAnalyzer.CodeConventionFinalize;
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

		//printStatements();

		CodeConventionFinalize ccf = new CodeConventionFinalize(statementListOfAClass);
		ccf.finalizeTheConvention();
		
		//ExtractMethods em = new ExtractMethods(statementListOfAClass);
		//em.splitMethodsFromClass();

		printStatements();
	}

	public void printStatements() {

		for (Statement statement : statementListOfAClass)
			System.out.println(statement.getStatementLineNumber() + " " + statement.getStatement() + "----");

	}
}
