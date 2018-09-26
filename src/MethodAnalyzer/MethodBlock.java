package MethodAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;

public class MethodBlock {

	private String methodName;
	
	private ArrayList<Statement> statementListOfAMethod = new ArrayList<>();

	public String getMethodName() {
		return methodName;
	}

	public ArrayList<Statement> getStatementListOfAMethod() {
		return statementListOfAMethod;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setStatementListOfAMethod(ArrayList<Statement> statementListOfAMethod) {
		this.statementListOfAMethod = statementListOfAMethod;
	}
	
	
}
