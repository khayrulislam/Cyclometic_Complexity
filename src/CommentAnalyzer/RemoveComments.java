package CommentAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;
import Util.Utils;

public class RemoveComments {

	ArrayList<Statement> statementListOfAClass;

	public RemoveComments(ArrayList<Statement> statementListOfAClass) {
		this.statementListOfAClass = statementListOfAClass;
	}

	public void removeAllTheCommentFromStatementList() {
		
		for (int i = 0; i < statementListOfAClass.size(); i++) {

			if (isStatementContains(Utils.START_OF_SINGLE_LINE_COMMENT, statementListOfAClass.get(i))) {

				removeSingleLineCommentFromStatement(statementListOfAClass.get(i));

				if (removeStatementIfEmpty(statementListOfAClass.get(i)))
					i--;

			}
			
			if (isStatementContains(Utils.START_OF_MULTI_LINE_COMMENT, statementListOfAClass.get(i))) {

				removeAllTheCommentInABlock(i);

			}

		}
		
		removeExtraSpaceInAStatement();

	}
	
	private void removeExtraSpaceInAStatement() {
		
		for(int i=0;i<statementListOfAClass.size();i++) {
			
			statementListOfAClass.get(i).setStatement( statementListOfAClass.get(i).getStatement().replaceAll("\\s+", " ") );
			
		}
		
	}

	private boolean removeStatementIfEmpty(Statement statement) {

		if (statement.getStatement().trim().isEmpty()) {
			statementListOfAClass.remove(statement);
			return true;
		}

		else {
			statement.setStatement(statement.getStatement().trim());
			return false;
		}

	}

	private void removeSingleLineCommentFromStatement(Statement statement) {

		statement.setStatement(statement.getStatement().replaceFirst(Utils.SINGLE_LINE_COMMENT_REGEX, ""));

	}

	private void removeAllTheCommentInABlock(int i) {

		int startIndex, endIndex;

		startIndex = getIndex(Utils.START_OF_MULTI_LINE_COMMENT, statementListOfAClass.get(i));

		while (true) {

			if (isStatementContains(Utils.END_OF_MULTI_LINE_COMMENT, statementListOfAClass.get(i))) {

				endIndex = getIndex(Utils.END_OF_MULTI_LINE_COMMENT, statementListOfAClass.get(i)) + 2;

				removeMultiLineComment(statementListOfAClass.get(i), startIndex, endIndex);

				if (removeStatementIfEmpty(statementListOfAClass.get(i)))
					i--;

				break;

			}

			else {

				removeMultiLineComment(statementListOfAClass.get(i), startIndex,
						statementListOfAClass.get(i).getStatement().length());

				startIndex = 0;

				if ( ! removeStatementIfEmpty(statementListOfAClass.get(i))) i++;
			}

		}
	}

	private void removeMultiLineComment(Statement statement, int startIndex, int endIndex) {
		
		statement.setStatement(
				statement.getStatement().replace(statement.getStatement().substring(startIndex, endIndex), ""));

	}

	private boolean isStatementContains(String subString, Statement statement) {

		return statement.getStatement().contains(subString);

	}

	private int getIndex(String subString, Statement statement) {

		return statement.getStatement().indexOf(subString);

	}

/*	public void printStatements() {

		for (Statement statement : statementListOfAClass)
			System.out.println(statement.getStatementLineNumber() + " " + statement.getStatement());

	}*/

}
